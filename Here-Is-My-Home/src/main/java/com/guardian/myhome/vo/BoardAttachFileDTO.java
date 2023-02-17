package com.guardian.myhome.vo;

import lombok.Data;

@Data
public class BoardAttachFileDTO {
	private String fileName;		// 원본 파일 이름 
	private String uploadPath;		// 업로드 경로 
	private String uuid;			// uuid
	private boolean image;			// 이미지 여부 
}
