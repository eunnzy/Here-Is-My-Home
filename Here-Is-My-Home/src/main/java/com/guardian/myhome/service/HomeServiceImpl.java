package com.guardian.myhome.service;

import java.util.List;

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
	
	public List<HomePreviewVO> previewHomeList() {
		List<HomePreviewVO> previewHomeList = null;
		
		previewHomeList = homeMapper.previewList();
		
		for(int i=0; i<previewHomeList.size(); i++) {
			int homeNum = previewHomeList.get(i).getHomeNum();
			previewHomeList.get(i).setHomeImgVO(homeImgMapper.previewHomeImg(homeNum));
		}
		
		return previewHomeList;
	}
	
	public List<HomeVO> selectAllHomeList() {
		// List<HomeVO> homeList = homeMapper.selectAllHomeList();
		return  homeMapper.selectAllHomeList();
	}
	
	@Override
	public List<HomeImgVO> findHomeImgPathByHome(int homeNum) {
		// TODO Auto-generated method stub
		return null;
	}




}
