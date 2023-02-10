package com.guardian.myhome.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AdminVO {

	private String adminId;
	
	private String adminPw;
	
	private String adminName;
	
	private String adminTel;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enrollDate;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminTel() {
		return adminTel;
	}

	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "AdminVO [adminId=" + adminId + ", adminPw=" + adminPw + ", adminName=" + adminName + ", adminTel="
				+ adminTel + ", enrollDate=" + enrollDate + "]";
	}

	
	
}
