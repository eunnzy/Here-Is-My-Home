package com.guardian.myhome.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.dao.HomeDAO;
import com.guardian.myhome.vo.HomeDetailVO;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeOptionVO;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomePriceVO;
import com.guardian.myhome.vo.HomeVO;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	HomeDAO homeDAO;
//	@Autowired
//	HomeMapper homeMapper;
//	@Autowired
//	HomeOptionMapper homeOptionMapper;
//	@Autowired 
//	HomeImgMapper homeImgMapper;
	
	@Override
	public int insertHome(Map<String, Object> insertMap) {
		System.out.println("\n============ HomeService insertHome 실행 =============\n");
		if(insertMap == null)
			 return 0;
		
		System.out.println(insertMap);
		HomeVO homeVO = (HomeVO)insertMap.get("homeVO");
		homeDAO.insertHome(homeVO);
		int homeNum = homeVO.getHomeNum();
		System.out.println("매물번호:" + homeNum);
		
		System.out.println((List<HomeImgVO>)insertMap.get("homeImgList"));
		List<HomeImgVO> homeImgList = (List<HomeImgVO>)insertMap.get("homeImgList");
		for(int i=0; i<homeImgList.size(); i++) 
			homeImgList.get(i).setHomeNum(homeNum);
		System.out.println(homeImgList);
		
		List<HomeOptionVO> homeOptionList = new ArrayList<>();
		for(String op: (List<String>)insertMap.get("homeOptionList")) {
			HomeOptionVO homeOptionVO = new HomeOptionVO();
			homeOptionVO.setHomeNum(homeNum);
			homeOptionVO.setOptionName(op);
			homeOptionList.add(homeOptionVO);
		}
		System.out.println(homeOptionList);
		
		HomePriceVO homePriceVO = (HomePriceVO)insertMap.get("homePriceVO");
		homePriceVO.setHomeNum(homeNum);
		
		homeDAO.insertHomeImgList(homeImgList);
		homeDAO.insertHomeOptionList(homeOptionList);
		homeDAO.insertHomePrice(homePriceVO);
		
		return 1;
		
	}
	
	// 현재 위치를 기준으로 지도 경계에 존재하는 매물 리스트 반환하기 
//	@Override 
//	public List<HomePreviewVO> homeInBoundsList(Map<String, Object> mapBounds) {
//		List<HomePreviewVO> homeInBoundsList = null;
//		homeInBoundsList = homeDAO.selectHomeInBoundsList(mapBounds);
//		
//		for(int i=0; i<homeInBoundsList.size(); i++) {
//			int homeNum = homeInBoundsList.get(i).getHomeNum();
//			homeInBoundsList.get(i).setHomeImgVO(homeDAO.selectPreviewHomeImg(homeNum));
//		}
//		
//		return homeInBoundsList;
//	}
	
	@Override 
	public List<HomePreviewVO> homeInBoundsList(Map<String, Object> mapBounds) {
		List<HomePreviewVO> homeInBoundsList = null;
		homeInBoundsList = homeDAO.selectHomeInBoundsList(mapBounds);
		
		for(int i=0; i<homeInBoundsList.size(); i++) {
			int homeNum = homeInBoundsList.get(i).getHomeNum();
			homeInBoundsList.get(i).setHomeImg(homeDAO.selectPreviewHomeImg(homeNum));
			homeInBoundsList.get(i).setOptionList(homeDAO.selectHomeOptionList(homeNum));
		}
		
		return homeInBoundsList;
	}
	


	@Override
	public Map<String, Object> selectHomeDetail(int homeNum) {
		HomeDetailVO homeDetailVO = homeDAO.selectHomeDetail(homeNum);
		homeDetailVO.setOptionList(homeDAO.selectHomeOptionList(homeNum));
		homeDetailVO.setHomeImgList(homeDAO.selectHomeImgList(homeNum));
		
		Map<String, Object> home = new HashMap<>();
		home.put("homeNum", homeDetailVO.getHomeNum());
		home.put("homeType", homeDetailVO.getHomeType());
		home.put("addr1", homeDetailVO.getAddr1());
		home.put("addr2", homeDetailVO.getAddr2());
		home.put("addr3", homeDetailVO.getAddr3());
		home.put("latitude", homeDetailVO.getLatitude());
		home.put("longitude", homeDetailVO.getLongitude());
		home.put("homeArea", homeDetailVO.getHomeArea());
		home.put("rentType", homeDetailVO.getRentType());
		home.put("rentPeriods", homeDetailVO.getRentPeriods());
		home.put("roomCount", homeDetailVO.getRoomCount());
		home.put("parking", homeDetailVO.getParking());
		home.put("pet", homeDetailVO.getPet());
		home.put("elevator", homeDetailVO.getElevator());
		home.put("balcony", homeDetailVO.getBalcony());
		home.put("moveDate", homeDetailVO.getMoveDate());
		home.put("floor", homeDetailVO.getFloor());
		home.put("homeTitle", homeDetailVO.getHomeTitle());
		home.put("homeDetail", homeDetailVO.getHomeDetail());
		home.put("optionList", homeDetailVO.getOptionList());
		home.put("homeImgList", homeDetailVO.getHomeImgList());
		
		
		home.put("deposit", convertMoneyUnit(homeDetailVO.getDeposit()));
		home.put("monthly", convertMoneyUnit(homeDetailVO.getMonthly()));
		home.put("adminCost", convertMoneyUnit(homeDetailVO.getAdminCost()));
		
		return home;
	}
	
	@Override
	public String convertMoneyUnit(int money) {
		money = money / 10000;
		String convert = "";
		if(money == 0) {
			convert = "없음";
		}else if(money >= 10000) {
			convert += money / 10000 + "억 ";
			
			if(money % 10000 != 0) {
				money = money % 10000;
				convert += money + "만";
			}
		}else {
			convert +=  money + "만";	
		}
		
		return convert;
	}
//	public List<HomePreviewVO> previewHomeList() {
//		List<HomePreviewVO> previewHomeList = null;
//		
//		previewHomeList = homeMapper.previewList();
//		
//		if(previewHomeList != null) {
//			for(int i=0; i<previewHomeList.size(); i++) {
//				int homeNum = previewHomeList.get(i).getHomeNum();
//				previewHomeList.get(i).setHomeImgVO(homeImgMapper.previewHomeImg(homeNum));
//			}
//			
//			return previewHomeList;
//		}
//		
//		return previewHomeList;
//	}

	
	@Override
	public void deleteHomeImg(int homeNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HomeImgVO previewHomeImg(int homeNum) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HomeVO> selectAllHomeList() {
		// TODO Auto-generated method stub
		return null;
	}



}
