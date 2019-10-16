package com.interest.model.entity;

import java.io.UnsupportedEncodingException;

public class RainbowJqsxxxEntity {

	private String ddiNo;
	private String ddiType;
	private String shopAddress;
	private String shopNo;
	private String dsiMobileCard;

	public String getDdiNo() {
		return ddiNo;
	}

	public void setDdiNo(String ddiNo) {
		this.ddiNo = ddiNo;
	}

	public String getDdiType() {
		return ddiType;
	}

	public void setDdiType(String ddiType) {
		this.ddiType = ddiType;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(byte[] address) {
		try {
			this.shopAddress = new String(address, "utf-8");
		} catch (UnsupportedEncodingException e) {
			this.shopAddress = "";
		}
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getDsiMobileCard() {
		return dsiMobileCard;
	}

	public void setDsiMobileCard(String dsiMobileCard) {
		this.dsiMobileCard = dsiMobileCard;
	}
}
