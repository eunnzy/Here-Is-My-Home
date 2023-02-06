package com.guardian.myhome.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	@RequestMapping(value="/search" , method = RequestMethod.GET)
	public String searchHome() {
		
		return "home/searchHome";
	}
	
	

}
