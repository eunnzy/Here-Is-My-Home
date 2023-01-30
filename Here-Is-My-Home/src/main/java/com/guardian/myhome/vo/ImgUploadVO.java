package com.guardian.myhome.vo;

import java.util.List;

import lombok.Data;

/*
	업로드 되는 이미지 파일이 2개 이상일 땐 List 타입으로 받기
 */

@Data
public class ImgUploadVO {
	private int imgNum;		// 이미지 번호
	private int homeNum;	// 매물 번호
	private String homeImgName;	// 매물 사진 이름
	private String homeImgPath;	// 매물 사진 저장 경로
}
