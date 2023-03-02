package com.guardian.myhome.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class LessorVO {

	private String lessorId;
	
	private String lessorPw;
	
	private String lessorNickName;
	
	private String phone;
	
	private String name;
	
	private String birthDate;
	
	private String jgsName;
	
	private String jgsNum;
	
	private int status;
	
	private String userRoll;
	
	private String lessorAddr1;
	
	private String lessorAddr2;
	
	private String lessorAddr3;
	
	private int valid;
	
	// 이미지 정보
	private List<LessorImgVO> imageList;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enrollDate;

	public String getLessorId() {
		return lessorId;
	}

	public void setLessorId(String lessorId) {
		this.lessorId = lessorId;
	}

	public String getLessorPw() {
		return lessorPw;
	}

	public void setLessorPw(String lessorPw) {
		this.lessorPw = lessorPw;
	}

	public String getLessorNickName() {
		return lessorNickName;
	}

	public void setLessorNickName(String lessorNickName) {
		this.lessorNickName = lessorNickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getJgsName() {
		return jgsName;
	}

	public void setJgsName(String jgsName) {
		this.jgsName = jgsName;
	}

	public String getJgsNum() {
		return jgsNum;
	}

	public void setJgsNum(String jgsNum) {
		this.jgsNum = jgsNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(String userRoll) {
		this.userRoll = userRoll;
	}

	public String getLessorAddr1() {
		return lessorAddr1;
	}

	public void setLessorAddr1(String lessorAddr1) {
		this.lessorAddr1 = lessorAddr1;
	}

	public String getLessorAddr2() {
		return lessorAddr2;
	}

	public void setLessorAddr2(String lessorAddr2) {
		this.lessorAddr2 = lessorAddr2;
	}

	public String getLessorAddr3() {
		return lessorAddr3;
	}

	public void setLessorAddr3(String lessorAddr3) {
		this.lessorAddr3 = lessorAddr3;
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

	public List<LessorImgVO> getImageList() {
		return imageList;
	}

	public void setImageList(List<LessorImgVO> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "LessorVO [lessorId=" + lessorId + ", lessorPw=" + lessorPw + ", lessorNickName=" + lessorNickName
				+ ", phone=" + phone + ", name=" + name + ", birthDate=" + birthDate + ", jgsName=" + jgsName
				+ ", jgsNum=" + jgsNum + ", status=" + status + ", userRoll=" + userRoll + ", lessorAddr1="
				+ lessorAddr1 + ", lessorAddr2=" + lessorAddr2 + ", lessorAddr3=" + lessorAddr3 + ", valid=" + valid
				+ ", imageList=" + imageList + ", enrollDate=" + enrollDate + "]";
	}



	
	

	
	
	
}
