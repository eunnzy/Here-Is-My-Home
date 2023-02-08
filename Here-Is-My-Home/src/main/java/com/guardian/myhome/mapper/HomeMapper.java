package com.guardian.myhome.mapper;

import java.util.List;

import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.HomeOptionVO;
import com.guardian.myhome.vo.HomePreviewVO;

/*
	mybatis를 연결하기 위한 mapper
	매물 관련 mapper
*/
public interface HomeMapper {
	int insertHome(HomeVO homeVO);	// 매물 등록
	List<HomeVO> selectAllHomeList();
	List<HomePreviewVO> previewList(); // 미리보기
	
	
	int insertHomeImg(HomeImgVO homeImgVO);	// 매물 사진 등록
	void deleteHomeImg(int homeNum);	// 매물 사진 삭제 (사진은 수정 개념 x)
	HomeImgVO previewHomeImg(int homeNum); // 미리보기 사진
	List<HomeImgVO> findHomeImgByHomeNum(int homeNum); // 매물 번호로 매물에 대한 이미지 파일 정보
	
	int insertOption(HomeOptionVO homeOptionVO);
	List<String> findOptionByHomeNum(int homeNum);
} 
