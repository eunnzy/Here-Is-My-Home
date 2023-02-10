package com.guardian.myhome.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {

	private String imchaId;
	
	private String imchaPw;
	
	private String nickname;
	
	private String phone;
	
	private String userRoll;
	
	private String sido1;
	
	private String gugun1;
	
	
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

	

	public String getSido1() {
		return sido1;
	}

	public void setSido1(String sido1) {
		this.sido1 = sido1;
	}

	public String getGugun1() {
		return gugun1;
	}

	public void setGugun1(String gugun1) {
		this.gugun1 = gugun1;
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
				+ ", userRoll=" + userRoll + ", sido1=" + sido1 + ", gugun1=" + gugun1 + ", valid=" + valid
				+ ", enrollDate=" + enrollDate + "]";
	}

	
	
	
	
}
