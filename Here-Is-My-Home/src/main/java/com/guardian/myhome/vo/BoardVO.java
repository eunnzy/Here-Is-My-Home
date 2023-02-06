package com.guardian.myhome.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno;			//글번호
	private String imchaid;		//작성자
	private String title;		//제목
	private String category;	//카테고리
	private String content;		//내용
	private Date regdate;		//등록시간
	private Date updateDate;	//수정시간
	private int views;			//조회수
	private int likes;			//좋아요

}
