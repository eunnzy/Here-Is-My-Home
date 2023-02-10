package com.guardian.myhome.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomeVO;

/*
	매물 관련 - 상세보기, 검색 등.
*/

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/detail")
	public String detailHome(@RequestParam int homeNum, Model model) {
		HomeVO home = homeService.selectHomeDetail(homeNum);
		model.addAttribute("home", home);
		return "home/detailHome";
	}
	
	@RequestMapping(value="/homeInBounds", method = RequestMethod.POST)
	@ResponseBody
	public List<HomePreviewVO> homeInBounds(@RequestParam Map<String, Object> mapBounds) {
		List<HomePreviewVO> homeInBoundsList = null;
		homeInBoundsList = homeService.homeInBoundsList(mapBounds);
		System.out.println(homeInBoundsList);
		
		return homeInBoundsList;
	}
	
	
	@RequestMapping(value="/searchHome" , method = RequestMethod.GET)
	public String searchHome() {
		return "home/searchHome";
	}
	
	

}
