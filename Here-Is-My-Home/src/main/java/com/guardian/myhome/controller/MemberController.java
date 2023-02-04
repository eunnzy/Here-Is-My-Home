package com.guardian.myhome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.service.MemberService;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.MemberVO;
import com.guardian.myhome.vo.OptionVO;

/*
	?뚯썝 愿??而⑦듃濡ㅻ윭
	
 */

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	// ?뚯썝媛???섏씠吏 ?대룞
	@RequestMapping(value = "/userJoin", method = RequestMethod.GET)
	public void loginGET() {
		
	}
	
	@RequestMapping(value = "/userJoin", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception{
		
		memberservice.memberJoin(member);
		
		return "redirect:/index";
	}
	
	// ?꾩씠??以묐났 寃??
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String Imcha_id) throws Exception {
		
		int result = memberservice.idCheck(Imcha_id);
		
		if (result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String registerForm() {
		return "/member/login";
	}
	
}

