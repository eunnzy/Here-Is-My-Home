package com.guardian.myhome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.service.MemberService;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.MemberVO;
import com.guardian.myhome.vo.OptionVO;

/*
	회원 관련 기능
	
 */

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	// 회원가입
	@RequestMapping(value = "/userJoin", method = RequestMethod.GET)
	public void loginGET() {
		
	}
	
	@RequestMapping(value = "/userJoin", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception{
		
		memberservice.memberJoin(member);
		
		return "redirect:/index";
	}
	
	// 아이디 중복체크
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String imchaId) throws Exception {
		
		int result = memberservice.idCheck(imchaId);
		
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {
		
//		System.out.println("login 메서드 진입");
//		System.out.println("전달된 데이터 :" + member);
//
//		return null;
		
		HttpSession session = request.getSession();
		MemberVO vo = memberservice.memberLogin(member);
		
		if(vo == null) {
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/member/login";
		} else {
			session.setAttribute("member", vo);
			
			return "redirect:/index";
		}
	}
	
}

