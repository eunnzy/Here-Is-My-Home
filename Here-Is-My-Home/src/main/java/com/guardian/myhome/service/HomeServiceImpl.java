package com.guardian.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.mapper.HomeMapper;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.OptionVO;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	HomeMapper homeMapper;
	
	@Override
	public int insertHome(HomeVO home) {
		return homeMapper.insertHome(home);
	}
	
	@Override
	public int insertOption(OptionVO option) {
		return homeMapper.insertOption(option);
	}
	

	@Override
	public int insertHomeImg(HomeImgVO homeImg) {
		return 0;
	}

	@Override
	public void deleteHomeImg(int imgNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HomeImgVO> findHomeImgPathByHome(int homeNum) {
		// TODO Auto-generated method stub
		return null;
	}




}
