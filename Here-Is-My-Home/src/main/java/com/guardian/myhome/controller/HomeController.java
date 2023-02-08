package com.guardian.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomeVO;

/*
	매물 관련 - 상세보기, 검색 등.
*/

// @Controller
// @RequestMapping("/home")
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	// @RequestMapping("/detail")
	public String detailHome() {
		return "home/detailHome";
	}
	
	
	// @RequestMapping(value="/search" , method = RequestMethod.GET)
	public String searchHome() {
		return "home/searchHome";
	}
	
	

}
