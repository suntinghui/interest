package com.interest.otp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OTPUtil {
	private static final Logger log =LoggerFactory.getLogger(OTPUtil.class);
	private static final String MAC_NAME 		= "HmacSHA1";
	public static final int Code_length 		= 18; 			// 输出串长度18位
	public static final int intervalDefault		= 30;	// OTP校验时间周期   or 300
	private static final int Otp_length  		= 5; 			// OTP长度，用于字符串截取，与实际产生值无关
	public static final String QR_optPrestr		= "otp";		// 二维码解析后返回的otp解析名称
	public static final String QR_UserIdStr		= "userId";		// 二维码解析后返回的userId解析名称
	/**
	 * 算法缺陷，UserId只支持到100亿userId量级以内，最大99.9亿（9位）*9=（10位），前2位定长，5位otp
	 * 一、18位条形码规则：
	 * 前2位：
	 * 		a）第二位>5则按第二位补齐userId*某个值后的位数，如：1~9（6~9），则补6~9位
	 * 		b）第二位=5，第1位为0，则补5位
	 * 				     第1位为非0，如：1~9（5），则补15位
	 * 		b）第二位<5则按10+第二位补齐userId*某个值后的位数，如：1~9（0~4），则补10~14位
	 * 后2~n位，userId*第一个token从后往前的非0数值
	 * 后n+1~18位，token1~token3，按顺序码放
	 *
	 * 二、实现方式
	 * a）计算新id=userId*otp1最后不为0的数值（1位）
	 * b）计算新id补位长度值（设为a）=18-新id长度-2
	 * c）按顺序组成字符串，新id补位长度!=5?(random(1~9)*10+a%10):("0"+a)+新id+otp1+otp2+otp3
	 * 								  注意：这儿是拼字符串，("0"+a)否则是数值运算，则长度出错
	 * e）截取前18位
	 * @param token		：用户的token+付款账号
	 * @param userId	：用户ID
	 * @return			：加密后的18位条形码（二维码）
	 */
	public static String makeCode(String token, Long userId) {
		StringBuffer ret =new StringBuffer();
		String otp1 =new TOTP(token, 3, intervalDefault).gen();
		// 注意，从otp2开始，后一个otp的token是前一个otp的值
		String otp2 =new TOTP(otp1, 3, intervalDefault).gen();
		String otp3 =new TOTP(otp2, 3, intervalDefault).gen();
		int lastInt =getLastBitNotZeroInt(otp1);
		long newId =userId*lastInt;
		int supplementLength =Code_length -("" +newId).length()-2; // code长度-新ID长度-前面两位
		ret.append(supplementLength !=5
				// !=5时，第一位为(1~9)的一个随机数，第二位为实际的长度数值
				?getRandom(1, 9)*10+supplementLength%10
				// ==5时，第一位为"0"
				:"0"+supplementLength);
		ret.append(newId);
		ret.append(otp1);
		ret.append(otp2);
		ret.append(otp3);
//		log.debug("otp1:-->{}<--,otp2:{}", otp1, otp2);
//		log.debug("otp3:{},otp4:{}", otp3, otp4);
//		log.debug("userId:{}", userId);
		return ret.toString().substring(0, Code_length);
	}
	public static Map<String, Object> parseCode(String qrCode) throws Exception{
		/**
		 * 一、18位条形码规则：
		 * 前2位：
		 * 		a）第二位>5则按第二位补齐userId*某个值后的位数，如：1~9（6~9），则补6~9位
		 * 		b）第二位=5，第1位为0，则补5位
		 * 				     第1位为非0，如：1~9（5），则补15位
		 * 		b）第二位<5则按10+第二位补齐userId*某个值后的位数，如：1~9（0~4），则补10~14位
		 * 后2~n位，userId*第一个token从后往前的非0数值
		 * 后n+1~18位，token1~token3，按顺序码放
		 */
		int supplementLength =Integer.parseInt(qrCode.substring(1, 2));
		if(supplementLength <5 ||
				(supplementLength ==5 &&0 !=Integer.parseInt(qrCode.substring(0, 1)))
		) {
			supplementLength =10+supplementLength;
		}
		long newId =Long.parseLong(qrCode.substring(2, Code_length-supplementLength));
		String otpStr =qrCode.substring(Code_length-supplementLength);
		if(otpStr.length() <Otp_length) {
			throw new Exception("otp.qrcode.user.id.over.long.err");
		}
		Map<String, Object> ret =new HashMap<>();
		parseOtp(ret, otpStr, 1);
		String otp1 =ret.get(QR_optPrestr+1).toString();
		int lastInt =getLastBitNotZeroInt(otp1);
		ret.put(QR_UserIdStr, newId/lastInt);
		return ret;
	}
	private static int getRandom(int start, int end) {
		int ret =-1;
		while(true) {
			ret =new Random().nextInt(end+1);
			if(ret >=start &&ret <=end) {
				return ret;
			}
		}
	}
	/**
	 * otp合法性验证，自动验证map中按规则解析出来的otp，若有多个otp，全部通过则算通过
	 * @param token			：起始秘钥
	 * @param otps			：解析后的otp对象组
	 * @return				：true，通过；false，不通过
	 * @throws Exception	：找不到初始otp
	 */
	public static boolean otpValidate(String token, Map<String, Object> otps) throws Exception {
		if(null ==otps.get(QR_optPrestr+1)) {
			throw new Exception("otp.qrcode.no.opt.err");
		}
		String currToken =token;
		for(int i=1 ;i<10 ;i++) {
			if(null !=otps.get(QR_optPrestr+i) &&otps.get(QR_optPrestr+i).toString().length() ==Otp_length) {
				if(otpValidate(currToken, otps.get(QR_optPrestr+i).toString())) {
					currToken =otps.get(QR_optPrestr+i).toString();
				} else {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean otpValidate(String securityKey, String value) {
		return null !=new TOTP(securityKey, 3, intervalDefault).verify(value);
	}
	private static void parseOtp(Map<String, Object> ret, String otpStr, int otpIndex) {
		if(otpStr.length() >Otp_length) {
			ret.put(QR_optPrestr+otpIndex, otpStr.substring(0, Otp_length));
			parseOtp(ret, otpStr.substring(Otp_length), otpIndex+1);
		} else {
			ret.put(QR_optPrestr+otpIndex, otpStr);
		}
	}
	public static int getLastBitNotZeroInt(String otp) {
		char[] chars =otp.toCharArray();
		for(int i =chars.length-1 ;i >=0 ;i--) {
			if(chars[i] !='0') {
				return new Integer(chars[i]+"");
			}
		}
		return -1;
	}
	public static class HOTP {

		private String secret = "123456";
		private int window = 3;
		private long counter = 0;

		public HOTP() {
		}

		public HOTP(String secret, int window, long counter) {
			this.secret = secret == null ? "" : secret;
			this.window = window < 0 || window > 100 ? 50 : window;
			this.counter = counter;
		}

		public String gen() {
			String ret = gen(this.counter);
			this.counter++;
			return ret;
		}

		public Integer verify(String token) {
			return verify(token, this.counter);
		}

		public String gen(long counter) {
			byte[] bytes = hmacSHA1Encrypt(toBytes(counter));
			// 转数字
			int v = convert(bytes);
			// 留5位
			v = v % 100000;
			return String.format("%05d", v);
		}

		public Integer verify(String token, long counter) {
			for (int i = 0; i < window; i++) {
				{
					long tcounter = counter - i;
					if (token.equals(gen(tcounter)))
						return i;
				}
				if (i == 0)
					continue;
				{
					long tcounter = counter + i;
					if (token.equals(gen(tcounter)))
						return i;
				}
			}
			return null;
		}

		// 怎么算
		private int convert(byte[] bytes20) {
			// 最后一个字节得到起始位置0-15
			int offset = bytes20[19] & 0xf;
			//按起始位置截取4字节累加
			int v = (bytes20[offset] & 0x7f) << 24 |
					(bytes20[offset + 1] & 0xff) << 16 |
					(bytes20[offset + 2] & 0xff) << 8  |
					(bytes20[offset + 3] & 0xff);
			return v;
		}

		//
		private Mac mac;
		private byte[] hmacSHA1Encrypt(byte[] encryptDataBytes) {
			if (mac == null) {
				try {
					mac = Mac.getInstance(MAC_NAME);
					SecretKey secretKey = new SecretKeySpec(secret.getBytes(), MAC_NAME);
					mac.init(secretKey);
				} catch(Exception e) {
					throw new RuntimeException("hmacSHA1加密失败", e);
				}
			}
			return mac.doFinal(encryptDataBytes);
		}

		private static byte[] toBytes(long v) {
			byte[] bytes = new byte[8];
			bytes[0] = (byte) ((v >>> 56) & 0xFF);
			bytes[1] = (byte) ((v >>> 48) & 0xFF);
			bytes[2] = (byte) ((v >>> 40) & 0xFF);
			bytes[3] = (byte) ((v >>> 32) & 0xFF);
			bytes[4] = (byte) ((v >>> 24) & 0xFF);
			bytes[5] = (byte) ((v >>> 16) & 0xFF);
			bytes[6] = (byte) ((v >>> 8) & 0xFF);
			bytes[7] = (byte) ((v >>> 0) & 0xFF);
			return bytes;
		}
	}

	public static class TOTP {
		private HOTP hotp;
		private int interval = intervalDefault;

		public TOTP() {
			this.hotp = new HOTP("123456", 2, 0);
		}
		public TOTP(String secret, int window, int interval) {
			this.hotp = new HOTP(secret, window, interval);
			this.interval = interval;
		}

		public String gen() {
			long timestamp = java.lang.System.currentTimeMillis();
			return gen(timestamp);
		}

		public String gen(long timestamp) {
			long tcounter = (long) (timestamp / 1000 / this.interval);
			return this.hotp.gen(tcounter);
		}

		public HashMap<String, Object> gen2() {
			long timestamp = java.lang.System.currentTimeMillis();
			return gen2(timestamp);
		}

		public HashMap<String, Object> gen2(long timestamp) {
			long timestamp_second = timestamp / 1000;
			long tcounter = (long) (timestamp_second / this.interval);
			String token = this.hotp.gen(tcounter);
			long step = timestamp_second % this.interval;
			long refresh_time = tcounter * this.interval;

			HashMap<String, Object> map = new HashMap<>();
			map.put("token", token);
			map.put("loop_length", this.interval);
			map.put("loop_step", step);
			map.put("refresh_interval", this.interval * 1000);
			map.put("refresh_time", refresh_time * 1000);
			map.put("timestamp", timestamp);
			return map;
		}

		public Integer verify(String token) {
			long timestamp = java.lang.System.currentTimeMillis();
			long tcounter = (long) (timestamp / 1000 / interval);
			return this.hotp.verify(token, tcounter);
		}
	}

}
