package com.interest.model.entity;

import java.io.UnsupportedEncodingException;

import lombok.Data;

public class RainbowDeviceDocEntity {

	// 网点ID
	private String id;
	// 网点名称
	private String name;
	// 所属渠道
	private String channel;
	// 意向时间
	private String yixiangTime;
	// 关联时间
	private String guanlianTime;
	// 装票开启时间
	private String openTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(byte[] name) {
		try {
			this.name = new String(name, "utf-8");
		} catch (UnsupportedEncodingException e) {
			this.name = "";
		}
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(byte[] channel) {
		try {
			this.channel = new String(channel, "utf-8");
		} catch (UnsupportedEncodingException e) {
			this.channel = "";
		}
	}

	public String getYixiangTime() {
		return yixiangTime;
	}

	public void setYixiangTime(String yixiangTime) {
		this.yixiangTime = yixiangTime;
	}

	public String getGuanlianTime() {
		return guanlianTime;
	}

	public void setGuanlianTime(String guanlianTime) {
		this.guanlianTime = guanlianTime;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

}
