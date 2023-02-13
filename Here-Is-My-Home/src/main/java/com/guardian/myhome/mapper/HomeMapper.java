package com.guardian.myhome.mapper;

import java.util.List;
import java.util.Map;

import com.guardian.myhome.vo.HomeDetailVO;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeOptionVO;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomePriceVO;
import com.guardian.myhome.vo.HomeVO;

/*
	mybatis를 연결하기 위한 mapper
	매물 관련 mapper
*/
public interface HomeMapper {
	int insertHome(HomeVO homeVO);	// 매물 등록
	int insertHomeOptionList(List<HomeOptionVO> homeOptionVO); // 옵션
	int insertHomeImgList(List<HomeImgVO> homeImgVO); 	// 사진
	int insertHomePrice(HomePriceVO HomePriceVO);
	
	List<HomeVO> selectAllHomeList();
	List<HomePreviewVO> selectHomeInBoundsList(Map<String, Object> mapBounds);	// 미리보기 
	HomeImgVO selectPreviewHomeImg(int homeNum);	// 매물 미리보기시 나올 
	List<HomePreviewVO> previewList(); // 미리보기리스트 반환
	HomeDetailVO selectHomeDetail(int homeNum);	// 매물 상세보기 정보
	List<String> selectHomeOptionDetail(int homeNum);
	List<HomeImgVO> selectHomeImgDetail(int homeNum);	// 해당  매물에 대한 이미지 파일 정보
	
	int insertHomeImg(HomeImgVO homeImgVO);	// 매물 사진 등록
//	void deleteHomeImg(int homeNum);	// 매물 사진 삭제 (사진은 수정 개념 x)
	
} 
