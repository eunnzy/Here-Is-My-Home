package com.guardian.myhome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guardian.myhome.service.LessorService;
import com.guardian.myhome.vo.LessorVO;


@Controller
@RequestMapping(value = "/member")
public class LessorController {

	@Autowired
	private LessorService lessorservice;
	
	// 회원가입 페이지 이동
	@RequestMapping(value = "/lessorJoin", method = RequestMethod.GET)
	public void lessorJoinGET() {
		
	}
	
	// 회원가입 기능
	@RequestMapping(value = "/lessorJoin", method = RequestMethod.POST)
	public String joinPOST(LessorVO lessor) throws Exception{
		
		lessorservice.lessorJoin(lessor);
		
		return "redirect:/lessorJoin";
	}
	
	@RequestMapping(value = "/lessorIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String lessorIdChkPOST(String lessorId) throws Exception {
		
		int result = lessorservice.idCheck(lessorId);
		
		if(result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
	
//	@RequestMapping(value = "/lessorNickChk", method = RequestMethod.POST)
//	@ResponseBody
//	public String lessorNickChkPOST(String lessorNickName) throws Exception {
//		
//		int result2 = lessorservice.nicknameCheck(lessorNickName);
//		
//		if(result2 != 0) {
//			return "fail";
//		} else {
//			return "success";
//		}
//	}
	
	@RequestMapping(value = "/lessorLogin", method = RequestMethod.GET)
	public String registerForm() {
		return "/member/lessorLogin";
	}
	
	// 로그인
	@RequestMapping(value = "/lessorLogin", method = RequestMethod.POST)
	public String lessorloingPOST(HttpServletRequest request, LessorVO lessor, RedirectAttributes rttr) throws Exception{
		
//		System.out.println("login 메서드 진입");
//		System.out.println("전달된 데이터 : " + lessor);
		
		HttpSession session = request.getSession();
		LessorVO lvo = lessorservice.lessorLogin(lessor);
		
		if(lvo == null) {
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/member/lessorLogin";
		} else {
			
			session.setAttribute("lessor", lvo);
			return "redirect:/index";
		}

	}
}
