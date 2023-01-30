package com.guardian.myhome.service;

import java.util.List;

import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.OptionVO;


public interface HomeService {
	public int insertHome(HomeVO home);
	public int insertOption(OptionVO option);
	
	
	public int insertHomeImg(HomeImgVO homeImg);	// 매물 사진 등록
	public void deleteHomeImg(int imgNum);	// 매물 사진 삭제 (사진은 수정 개념 x)
	public List<HomeImgVO> findHomeImgPathByHome(int homeNum);	// 매물에 대한 사진 경로
}
