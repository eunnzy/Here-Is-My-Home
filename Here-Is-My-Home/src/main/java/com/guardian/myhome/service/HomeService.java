package com.guardian.myhome.service;

import java.util.List;

import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeVO;


public interface HomeService {
	void insertHome(HomeVO homeVO);
	List<HomeVO> selectAllHomeList();
	List<HomeImgVO> findHomeImgPathByHome(int homeNum);	// 매물에 대한 사진 경로
}
