package com.guardian.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.vo.HomePreviewVO;


@Controller
//@RequestMapping("/home")
public class SearchHomeController {
	
	@Autowired
	private HomeService homeService;
	
//	@RequestMapping(value="/searchHome" , method = RequestMethod.GET)
//	public ModelAndView searchHome() {
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home/searchHome");
//		
//		List<HomePreviewVO> homePreviewVO = homeService.previewHomeList();
//		System.out.println(homePreviewVO);
//		
//		return mv;
//	}
//	
//	@RequestMapping("/detail")
//	public String detailHome() {
//		return "home/detailHome";
//	}
	
}
