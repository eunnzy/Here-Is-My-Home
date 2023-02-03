package com.guardian.myhome.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
	SQL을 처리하기 위한 매물 이미지 VO (이미지 번호, 게시글 번호 추가)
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeImgUploadVO {
	private int imgNum;		// 이미지 번호
	private int homeNum;	// 매물 번호
	private String homeImgName;	// 매물 사진 이름
	private String homeImgPath;	// 매물 사진 저장 경로
}
