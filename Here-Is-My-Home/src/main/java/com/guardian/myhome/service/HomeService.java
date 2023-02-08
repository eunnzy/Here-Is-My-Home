package com.guardian.myhome.service;

import java.util.List;

import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomeVO;


public interface HomeService {
	int insertHome(HomeVO homeVO);	// 매물 추가
	List<HomeVO> selectAllHomeList();	// 모든 매물 리스트
	List<HomePreviewVO> previewHomeList();	// 매물 미리보기 리스트 반환
	List<HomeImgVO> findHomeImgPathByHome(int homeNum);	// 매물에 대한 사진 경로
}
