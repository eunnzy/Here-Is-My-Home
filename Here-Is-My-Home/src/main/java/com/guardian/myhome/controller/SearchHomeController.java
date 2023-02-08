package com.guardian.myhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guardian.myhome.service.HomeService;


@Controller
@RequestMapping("/home")
public class SearchHomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/detail")
	public String detailHome() {
		return "home/detailHome";
	}
	
	@RequestMapping(value="/search" , method = RequestMethod.GET)
	public String searchHome() {
		return "home/searchHome";
	}
	
}
