package com.guardian.myhome.mapper;

import java.util.List;
import java.util.Map;

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
	HomeVO selectHomeDetail(int homeNum);
	List<HomePreviewVO> homeInBoundsList(Map<String, Object> mapBounds);
	List<HomePreviewVO> previewList(); // 미리보기
	
} 
