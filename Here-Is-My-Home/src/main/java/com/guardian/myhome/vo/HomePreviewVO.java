package com.guardian.myhome.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

// 미리보기

@Data	
@NoArgsConstructor
public class HomePreviewVO {	// 매물 미리보기 VO
	private int homeNum;	// 매물 번호
	private String homeType; // 집종류
	private String addr1;	// 주소
	private String addr2;
	private String addr3;
	private double latitude;	// 위도
	private double longitude;	// 경도
	private String rentType;	// 거래 종류
	private int deposit; 	// 보증금
	private int monthly;		// 월세
	private int rentPeriods;
	private int adminCost;	// 관리비
	private String homeTitle; // 게시글 제목
	private int homeValid;	// 유효한 글
	private HomeImgVO homeImgVO;
}
