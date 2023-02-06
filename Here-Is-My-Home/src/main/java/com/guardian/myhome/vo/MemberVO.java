package com.guardian.myhome.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberVO {

	private String imchaId;
	private String imchaPw;
	private String nickname;
	private String phone;
	private String userRoll;
	private String imchaAddr1;
	private String imchaAddr2;
	private String imchaAddr3;
	private int valid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enrollDate;

	public String getImchaId() {
		return imchaId;
	}

	public void setImchaId(String imchaId) {
		this.imchaId = imchaId;
	}

	public String getImchaPw() {
		return imchaPw;
	}

	public void setImchaPw(String imchaPw) {
		this.imchaPw = imchaPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(String userRoll) {
		this.userRoll = userRoll;
	}

	public String getImchaAddr1() {
		return imchaAddr1;
	}

	public void setImchaAddr1(String imchaAddr1) {
		this.imchaAddr1 = imchaAddr1;
	}

	public String getImchaAddr2() {
		return imchaAddr2;
	}

	public void setImchaAddr2(String imchaAddr2) {
		this.imchaAddr2 = imchaAddr2;
	}

	public String getImchaAddr3() {
		return imchaAddr3;
	}

	public void setImchaAddr3(String imchaAddr3) {
		this.imchaAddr3 = imchaAddr3;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "MemberVO [imchaId=" + imchaId + ", imchaPw=" + imchaPw + ", nickname=" + nickname + ", phone=" + phone
				+ ", userRoll=" + userRoll + ", imchaAddr1=" + imchaAddr1 + ", imchaAddr2=" + imchaAddr2
				+ ", imchaAddr3=" + imchaAddr3 + ", valid=" + valid + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
