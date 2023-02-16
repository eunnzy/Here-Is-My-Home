package com.guardian.myhome.service;

import java.util.List;
import java.util.Map;

import com.guardian.myhome.vo.HomeDetailVO;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeOptionVO;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomeVO;


public interface HomeService {
	int insertHome(Map<String, Object> insertMap);
//	List<HomePreviewVO> homeInBoundsList(Map<String, Object> mapBounds); // 현재 위치 안에 있는 매물들 
	List<HomePreviewVO> homeInBoundsList(Map<String, Object> mapBounds);
	List<HomeVO> selectAllHomeList();	// 모든 매물 리스트
	Map<String, Object> selectHomeDetail(int homeNum);	// 매물 상세 정보 반환 
	String convertMoneyUnit(int money); 
	void deleteHomeImg(int homeNum);	// 매물 사진 삭제 (사진은 수정 개념 x)
	HomeImgVO previewHomeImg(int homeNum);	// 매물 미리보기시 나올 사진
	
//	List<HomePreviewVO> previewHomeList();	// 매물 미리보기 리스트 반환
}
