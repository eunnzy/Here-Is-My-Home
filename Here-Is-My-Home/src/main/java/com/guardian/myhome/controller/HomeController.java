package com.guardian.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
	매물 관련 - 상세보기, 검색 등.
*/

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/detail")
	public String detailHome() {
		return "home/detailHome";
	}
}
