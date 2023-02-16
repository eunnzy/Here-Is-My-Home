package com.guardian.myhome.dao;

import java.util.List;
import java.util.Map;

import com.guardian.myhome.vo.HomeDetailVO;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeOptionVO;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomePriceVO;
import com.guardian.myhome.vo.HomeVO;

public interface HomeDAO {
	int insertHome(HomeVO homeVO);
	int insertHomeImgList(List<HomeImgVO> homeImgList);
	int insertHomePrice(HomePriceVO HomePriceVO);
	int insertHomeOptionList(List<HomeOptionVO> homeOptionList);
//	List<HomePreviewVO> selectHomeInBoundsList(Map<String, Object> mapBounds);	// 지도 경계 내 리스트
	List<HomePreviewVO> selectHomeInBoundsList(Map<String, Object> mapBounds);
	HomeImgVO selectPreviewHomeImg(int homeNum);	// 매물 미리보기시 나올 사진
	HomeDetailVO selectHomeDetail(int homeNum);	// 매물 정보 반환
	List<HomeImgVO> selectHomeImgList(int homeNum); // 해당 매물 사진들 반환
	List<String> selectHomeOptionList(int homeNum); // 해당 매물 옵션 목록 반환
//	List<Integer> selectHomeNumByOptionCheck(List<String> homeOptionList);	// 체크한 옵션 리스트의 매물 번호 
}
