package com.guardian.myhome.service;

import java.util.List;
import java.util.Map;

import com.guardian.myhome.vo.HomeDetailVO;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeOptionVO;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomeReportVO;
import com.guardian.myhome.vo.HomeVO;


public interface HomeService {
	int insertHome(Map<String, Object> insertMap);
	List<HomePreviewVO> homeInBoundsList(Map<String, Object> mapBounds);
	List<HomeVO> selectAllHomeList();	// 모든 매물 리스트
	Map<String, Object> selectHomeDetail(int homeNum);	// 매물 상세 정보 반환 
	String convertMoneyUnit(long money); 
	HomeImgVO previewHomeImg(int homeNum);	// 매물 미리보기시 나올 사진
	int modifyHomeInfo(Map<String, Object> modifyHome);	// 매물 정보 수정
	public List<HomePreviewVO>  getListByLessorId(String lessorId); // 매물 리스트
	public void deleteManageList(String lessorId);		// 매물 삭제
	int reportHome(HomeReportVO homeReportVO);	// 매물 신고
	
	List<HomeReportVO> selectReportHomeList();
}
