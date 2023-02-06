package com.guardian.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.mapper.HomeImgMapper;
import com.guardian.myhome.mapper.HomeMapper;
import com.guardian.myhome.mapper.HomeOptionMapper;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeOptionVO;
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
	public void insertHome(HomeVO homeVO) {
		
		// 매물 정보 (옵션, 이미지 제외 정보들 insert 후 등록된 행의 번호(매물번호) 반환
		int homeNum = homeMapper.insertHome(homeVO);
		System.out.println("매물번호: " + homeNum);
		
		if(homeVO.getOptionList() != null) {
			for(String option: homeVO.getOptionList()) {
				HomeOptionVO homeOptionVO = new HomeOptionVO();
				homeOptionVO.setHomeNum(homeNum);
				homeOptionVO.setOptionName(option);
				homeOptionMapper.insertOption(homeOptionVO);
			}
		}	
		
		if(homeVO.getHomeImgList() != null) {
			for(HomeImgVO imgVO : homeVO.getHomeImgList()) {
				imgVO.setHomeNum(homeNum);
//				homeImgMapper.insertHomeImg(imgVO);
			}
		}
		
	}
	
	public List<HomeVO> selectAllHomeList() {
		List<HomeVO> homeList = homeMapper.selectAllHomeList();
		return null;
	}
	
	@Override
	public List<HomeImgVO> findHomeImgPathByHome(int homeNum) {
		// TODO Auto-generated method stub
		return null;
	}




}
