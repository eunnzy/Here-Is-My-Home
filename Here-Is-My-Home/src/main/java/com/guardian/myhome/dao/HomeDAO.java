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
	List<HomePreviewVO> selectHomeInBoundsList(Map<String, Object> mapBounds);	// 지도 경계 내 리스트
	HomeImgVO selectPreviewHomeImg(int homeNum);	// 매물 미리보기시 나올 사진
	HomeDetailVO selectHomeDetail(int homeNum);	// 매물 정보 리스트
	List<HomeImgVO> selectHomeImgDetail(int homeNum); // 해당 매물 사진들 반환
	List<String> selectHomeOptionDetail(int homeNum); // 해당 매물 옵션 목록 반환
}
