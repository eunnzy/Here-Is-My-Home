package com.guardian.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
//@RequestMapping("/home")
public class SearchHomeController {
	
//	@RequestMapping("/search")
	public String searchHome() {
		return "home/searchHome";
	}
}
