package com.guardian.myhome.mapper;

import java.util.List;

import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.OptionVO;

/*
	mybatis를 연결하기 위한 mapper
	매물 관련 mapper
*/
public interface HomeMapper {
	public int insertHome(HomeVO home);	// 매물 등록
	public int insertOption(OptionVO option);
	
	
	public int insertHomeImg(HomeImgVO homeImg);	// 매물 사진 등록
	public void deleteHomeImg(int imgNum);	// 매물 사진 삭제 (사진은 수정 개념 x)
	public List<HomeImgVO> findHomeImgPathByHome(int homeNum);	// 매물에 대한 사진 경로
//	public void addHomeOption(HomeOptionVO homeOption)
}
