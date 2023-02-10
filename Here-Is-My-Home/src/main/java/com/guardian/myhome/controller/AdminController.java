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

import com.guardian.myhome.service.AdminService;
import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.service.MemberService;
import com.guardian.myhome.vo.AdminVO;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.MemberVO;

/*
	회원 관련 기능
	
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminservice;
	
	// 유저회원가입
	@RequestMapping(value = "/adminJoin", method = RequestMethod.GET)
	public void joinGET() {
		
	}
	
		@RequestMapping("/main")
		public String home() {
			
			return "/admin/main";
		}
	
	
	@RequestMapping(value = "/adminJoin", method = RequestMethod.POST)
	public String joinPOST(AdminVO admin) throws Exception{
		
		adminservice.adminJoin(admin);
		
		return "redirect:/admin/main";
	}
	
	// 아이디 중복체크
	@RequestMapping(value = "/adminIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String adminIdChkPOST(String adminId) throws Exception {
		
		int result = adminservice.idCheck(adminId);
		
		if (result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String registerForm() {
		return "/admin/adminLogin";
	}
	
	// 로그인
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, AdminVO admin, RedirectAttributes rttr) throws Exception {
		
//		System.out.println("login 메서드 진입");
//		System.out.println("전달된 데이터 :" + member);
//
//		return null;
		
		HttpSession session = request.getSession();
		AdminVO avo = adminservice.adminLogin(admin);
		
		if(avo == null) {
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/admin/adminLogin";
		} else {
			session.setAttribute("admin", avo);
			
			return "redirect:/admin/main";
		}
	}
	

	
	// 로그아웃
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logoutGET(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "redirect:/admin/main";
	}
	
}
