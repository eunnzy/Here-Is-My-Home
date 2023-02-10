package com.guardian.myhome.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.mapper.HomeImgMapper;
import com.guardian.myhome.mapper.HomeMapper;
import com.guardian.myhome.mapper.HomeOptionMapper;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeOptionVO;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomeVO;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	HomeMapper homeMapper;
	@Autowired
	HomeOptionMapper homeOptionMapper;
	@Autowired 
	HomeImgMapper homeImgMapper;
	
	@Override
	public int insertHome(HomeVO homeVO) {
		if(homeVO.getOptionList() == null || homeVO.getHomeImgList() == null)
			return 0;
		
		System.out.println(homeVO);
		// 매물 정보 (옵션, 이미지 제외 정보들 insert 후 등록된 행의 번호(매물번호) 반환
		homeMapper.insertHome(homeVO);
		int homeNum = homeVO.getHomeNum();	// 삽입한 홈 번호
		System.out.println("매물번호: " + homeNum);
		
	//	System.out.println("\n\noptionList:" + homeVO.getOptionList());
		for(String option: homeVO.getOptionList()) {
			HomeOptionVO homeOptionVO = new HomeOptionVO();
			homeOptionVO.setHomeNum(homeNum);
			homeOptionVO.setOptionName(option);
			homeOptionMapper.insertOption(homeOptionVO);
		}
		
		// System.out.println("\n\nhomeImgList:" + homeVO.getHomeImgList());
		for(HomeImgVO imgVO : homeVO.getHomeImgList()) {
			imgVO.setHomeNum(homeNum);
			homeImgMapper.insertHomeImg(imgVO);
		}
		
		return 1;
		
	}
	
	public List<HomeVO> selectAllHomeList() {
		// List<HomeVO> homeList = homeMapper.selectAllHomeList();
		return  homeMapper.selectAllHomeList();
	}
	

	@Override
	public HomeVO selectHomeDetail(int homeNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<HomePreviewVO> previewHomeList() {
		List<HomePreviewVO> previewHomeList = null;
		
		previewHomeList = homeMapper.previewList();
		
		if(previewHomeList != null) {
			for(int i=0; i<previewHomeList.size(); i++) {
				int homeNum = previewHomeList.get(i).getHomeNum();
				previewHomeList.get(i).setHomeImgVO(homeImgMapper.previewHomeImg(homeNum));
			}
			
			return previewHomeList;
		}
		
		return previewHomeList;
	}

	
	
	@Override
	public List<HomeImgVO> findHomeImgPathByHome(int homeNum) {
		// TODO Auto-generated method stub
		return null;
	}

	// 현재 위치를 기준으로 지도 경계에 존재하는 매물 리스트
	@Override 
	public List<HomePreviewVO> homeInBoundsList(Map<String, Object> mapBounds) {
		List<HomePreviewVO> homeInBoundsList = null;
		
		homeInBoundsList = homeMapper.homeInBoundsList(mapBounds);
		
		if(homeInBoundsList != null) {
			for(int i=0; i<homeInBoundsList.size(); i++) {
				int homeNum = homeInBoundsList.get(i).getHomeNum();
				homeInBoundsList.get(i).setHomeImgVO(homeImgMapper.previewHomeImg(homeNum));
			}
			return homeInBoundsList;
		}
		
		return homeInBoundsList;
	}



}
