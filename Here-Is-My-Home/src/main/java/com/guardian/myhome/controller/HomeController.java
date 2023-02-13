package com.guardian.myhome.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.vo.HomeDetailVO;
import com.guardian.myhome.vo.HomePreviewVO;

/*
	매물 관련 - 상세보기, 검색 등.
*/

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/detail")
	public String detailHome(@RequestParam("homeNum") int homeNum, Model model) {
		Map<String, Object> home = homeService.selectHomeDetail(homeNum);
		System.out.println("detailHome: " + home);
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
	
	
	@RequestMapping(value = "/getHomeImg", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPreviewImg(@RequestParam String homeImgFile) {
		System.out.println("homeImgFile : " + homeImgFile);
		ResponseEntity<byte[]> result = null;
		File imgFile = new File("C:\\homeUpload", homeImgFile);
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(imgFile.toPath()));
		
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(imgFile), header, HttpStatus.OK);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
