package com.guardian.myhome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guardian.myhome.dao.HomeDAO;
import com.guardian.myhome.mapper.LessorMapper;
import com.guardian.myhome.service.AdminService;
import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.service.LessorService;
import com.guardian.myhome.service.ImchaService;
import com.guardian.myhome.vo.AdminVO;
import com.guardian.myhome.vo.HomeReportVO;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.LessorVO;
import com.guardian.myhome.vo.ImchaVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminservice;
	
	@Autowired
	private LessorService lessorservice;
	
	
	@Autowired
	private HomeDAO homedao;

	
	// 관리자 회원가입
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
	

	// 회원가입 승인여부
	@ResponseBody
	@RequestMapping(value="/successId")
	public int successId(@RequestParam(value ="lessorId") String lessorId) throws Exception {
		System.out.println(lessorId);
		lessorservice.successId(lessorId);
		
		int result = lessorservice.successId(lessorId);
		
		if (result != 0) {
			return result;
		}
		return result;
		
	}
	
//	@ResponseBody
//	@PostMapping("/failId")
//	public void failId(String lessorId) throws Exception {
//		System.out.println(lessorId);
//		lessorservice.failed(lessorId);
//	}
	
	// 허위 매물 목록 리스트
	@GetMapping("/reportList")
	public String HomeReport(Model model) {
		System.out.println("/HomeList 요청");
		List<HomeReportVO> list = homedao.selectReportHomeList();
		System.out.println(list);
		model.addAttribute("list", list);
		return "admin/reportList";
	}
	
	// 차단여부
	@ResponseBody
	@RequestMapping(value="/successNum")
	public int successNum(@RequestParam(value ="homeNum") int homeNum) throws Exception {
		System.out.println(homeNum);
		adminservice.successNum(homeNum);
		
		int result = adminservice.successNum(homeNum);
		
		if (result != 1) {
			return result;
		}
		return result;
		
	}
}

