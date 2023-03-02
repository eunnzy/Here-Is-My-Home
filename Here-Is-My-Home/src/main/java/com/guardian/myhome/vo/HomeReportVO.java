package com.guardian.myhome.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HomeReportVO {
	private int reportNum;	// 신고 번호
	private int homeNum;
//	private String lessorId;	// 중개인 아이디
	private String imchaId;	// 신고자 아이디
//	private String reportTitle; 	// 신고 제목
	private int reportType;	// 신고 유형
	private String reportContent; // 신고 내용
	private String reportRegDate;	// 신고 날짜
}
