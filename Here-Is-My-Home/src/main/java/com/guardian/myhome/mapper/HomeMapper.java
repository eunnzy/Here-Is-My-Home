package com.guardian.myhome.mapper;

import java.util.List;

import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.HomeOptionVO;

/*
	mybatis를 연결하기 위한 mapper
	매물 관련 mapper
*/
public interface HomeMapper {
	int insertHome(HomeVO homeVO);	// 매물 등록
	List<HomeVO> selectAllHomeList();
	List<HomeImgVO> findHomeImgByHomeNum(int homeNum);	// 매물 번호로 매물에 대한 이미지 파일 정보
}
