package com.interest.otp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.interest.otp.OTPUtil.TOTP;

public class OTPUtilTest {
    private static final Logger log = LoggerFactory.getLogger(OTPUtilTest.class);

    @Test
    public void test() throws Exception {
//		this.charIntTest();
//		this.testQrCode();
//		this.testQrDecode();
        this.testQrCodeValidate();
    }

    public void testQrDecode() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJQMjAxOTEyMTExMDEzNDQ3NTJmNTM5MWMyYyIsImlhdCI6MTU3NjEzMjkxMCwic3ViIjoie1wiY3VzdG9tZXJOYW1lXCI6XCLpmL_kuIlcIixcImN1c3RvbWVyTmJyXCI6XCJQMjAxOTEyMTExMDEzNDQ3NTJmNTM5MWMyY1wiLFwiY3VzdG9tZXJUeXBlXCI6XCIyMDAwXCIsXCJpZFwiOjE1LFwibGFzdExvZ2luRGF0ZXRpbWVcIjoxNTc2MTMyODU0MDAwLFwibGFzdExvZ2luSXBcIjpcIjEyNy4wLjAuMVwiLFwibW9iaWxlTmJyXCI6XCIxMzQxMjQxMjNcIixcInN1bVN1Y2Nlc3NUaW1lc1wiOjI3fSIsImlzcyI6InlzaHpAYmojUGFzczBkIiwiZXhwIjoxNTc2OTk2OTEwLCJuYmYiOjE1NzYxMzI5MTB9.sKqDqFnMH9odSf55kSfa7gxyp7KxRYqe6Zk-mWGsLsM47";
        String qrCode = "241539341947685556";
        Map<String, Object> otps = OTPUtil.parseCode(qrCode);
        log.debug("otps--->{}", otps);
        log.debug("vali--->{}", OTPUtil.otpValidate(token, otps));
    }

    public void testQrCode() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJQMjAxOTEyMDUwODM0MTA5MzQ3Y2MxZDc5ZCIsImlhdCI6MTU3NTUxOTExMiwic3ViIjoie1wiY3VzdG9tZXJOYnJcIjpcIlAyMDE5MTIwNTA4MzQxMDkzNDdjYzFkNzlkXCIsXCJjdXN0b21lclR5cGVcIjpcIjIwMDBcIixcImlkXCI6OSxcImxhc3RMb2dpbkRhdGV0aW1lXCI6MTU3NTUxNjY4NzAwMCxcImxhc3RMb2dpbklwXCI6XCIxMjcuMC4wLjFcIixcIm1vYmlsZU5iclwiOlwiMTM5MDAxMzkwMDBcIixcInN1bVN1Y2Nlc3NUaW1lc1wiOjV9IiwiaXNzIjoieXNoekBiaiNQYXNzMGQiLCJleHAiOjE1NzYzODMxMTIsIm5iZiI6MTU3NTUxOTExMn0.JZjUQhmJDwjUmIiBT6KVpCU7E6HlIZ6u3WbXyBuHlIE";
        String qrCode = OTPUtil.makeCode(token, 1L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 9L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 98L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 987L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 9876L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 98765L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 987654L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 9876543L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 98765432L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 987654321L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 9876543210L);
        this.testQrCode(qrCode, token);
        qrCode = OTPUtil.makeCode(token, 9999999999L);
        this.testQrCode(qrCode, token);
        log.debug("最大ID--->{}<----===============", 9999999999L);
        qrCode = OTPUtil.makeCode(token, 98765432101L);
        this.testQrCode(qrCode, token);
    }

    private void testQrCode(String qrCode, String token) throws Exception {
        log.debug("----------------------------- new start --------------------");
        log.debug("qrCode-->{}", qrCode);
        Map<String, Object> decode = OTPUtil.parseCode(qrCode);
        log.debug("parseCode:{}", decode);
        log.debug("validate:{}<<<====={}", OTPUtil.otpValidate(token, decode), !OTPUtil.otpValidate(token, decode) ? "<<<======QRCode error=====" : "");
        log.debug("validate,errorToken:{}", OTPUtil.otpValidate(token.substring(0, token.length() - 1), decode));
        decode.put("otp2", "1" + decode.get("otp1").toString().substring(0, 4));
        log.debug("validate,errorOtp:{}", OTPUtil.otpValidate(token, decode));
        log.debug("-----------------------------  end  --------------------");
    }

    private void testQrCodeValidate() throws Exception {
        String qrCode = "731045620866476999";
//		String token ="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJQMjAxOTEyMTAxMzM0NDY0NzRmYWQ5M2QzOSIsImlhdCI6MTU3Njc0NzMzNCwic3ViIjoie1wiY3VzdG9tZXJOYW1lXCI6XCLlrZnlu7fkvJoxXCIsXCJjdXN0b21lck5iclwiOlwiUDIwMTkxMjEwMTMzNDQ2NDc0ZmFkOTNkMzlcIixcImN1c3RvbWVyVHlwZVwiOlwiMjAwMFwiLFwiaWRcIjoxMyxcImxhc3RMb2dpbkRhdGV0aW1lXCI6MTU3NjczOTAyMTAwMCxcImxhc3RMb2dpbklwXCI6XCIyMjEuMjE2Ljk1Ljc5XCIsXCJtb2JpbGVOYnJcIjpcIjE4NTAwOTcyODc2XCIsXCJzdW1TdWNjZXNzVGltZXNcIjo0MX0iLCJpc3MiOiJ5c2h6QGJqI1Bhc3MwZCIsImV4cCI6MTU3NjkyMDEzNCwibmJmIjoxNTc2NzQ3MzM0fQ.wVB8uEReiwrDhErCJWsqq50ROSQdawphtKMYUFi-Y9k";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJQMjAxOTEyMTAxMzM0NDY0NzRmYWQ5M2QzOSIsImlhdCI6MTU3Njc0NzMzNCwic3ViIjoie1wiY3VzdG9tZXJOYW1lXCI6XCLlrZnlu7fkvJoxXCIsXCJjdXN0b21lck5iclwiOlwiUDIwMTkxMjEwMTMzNDQ2NDc0ZmFkOTNkMzlcIixcImN1c3RvbWVyVHlwZVwiOlwiMjAwMFwiLFwiaWRcIjoxMyxcImxhc3RMb2dpbkRhdGV0aW1lXCI6MTU3NjczOTAyMTAwMCxcImxhc3RMb2dpbklwXCI6XCIyMjEuMjE2Ljk1Ljc5XCIsXCJtb2JpbGVOYnJcIjpcIjE4NTAwOTcyODc2XCIsXCJzdW1TdWNjZXNzVGltZXNcIjo0MX0iLCJpc3MiOiJ5c2h6QGJqI1Bhc3MwZCIsImV4cCI6MTU3NjkyMDEzNCwibmJmIjoxNTc2NzQ3MzM0fQ.wVB8uEReiwrDhErCJWsqq50ROSQdawphtKMYUFi-Y9k";
        String accountId = "39";
        this.testQrCodeValidate(qrCode, token, accountId);
    }

    private void testQrCodeValidate(String qrCode, String token, String accountId) throws Exception {
        token = token + accountId;
        log.debug("----------------------------- new start --------------------");
        log.debug("qrCode-->{}", qrCode);
        Map<String, Object> decode = OTPUtil.parseCode(qrCode);
        log.debug("parseCode:{}", decode);
        log.debug("validate:{}<<<====={}", OTPUtil.otpValidate(token, decode), !OTPUtil.otpValidate(token, decode) ? "<<<======QRCode error=====" : "");
        log.debug("-----------------------------  end  --------------------");
    }

    public void charIntTest() {
        log.debug("{}, {}", (int) '0', new Integer('0' + ""));
        log.debug("{}, {}", (int) '1', new Integer('1' + ""));
        log.debug("{}, {}", (int) '2', new Integer('2' + ""));
        log.debug("{}, {}", (int) '3', new Integer('3' + ""));
        log.debug("{}, {}", (int) '4', new Integer('4' + ""));
        log.debug("{}, {}", (int) '5', new Integer('5' + ""));
        log.debug("{}, {}", (int) '6', new Integer('6' + ""));
        log.debug("{}, {}", (int) '7', new Integer('7' + ""));
        log.debug("{}, {}", (int) '8', new Integer('8' + ""));
        log.debug("{}, {}", (int) '9', new Integer('9' + ""));
    }

    public void HOTPTest() {
        TOTP p = new TOTP("a123a4567890", 3, 30);
        HashMap<String, Object> map = p.gen2();
        log.debug("{}", map);
        log.debug("otp1:{}", p.gen());
        log.debug("{}", p.gen(123456));
        log.debug("{}", p.verify((String) map.get("token")));
        log.debug("{}", p.verify("134880"));
        p = new TOTP(p.gen(), 3, 30);
        log.debug("otp2:{}", p.gen());
        p = new TOTP(p.gen(), 3, 30);
        log.debug("otp3:{}", p.gen());
    }
}
