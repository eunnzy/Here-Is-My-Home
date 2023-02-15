package com.guardian.myhome.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.service.MemberService;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.MemberVO;

/*
	회원 관련 기능
	
 */

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	
	// 유저회원가입
	@RequestMapping(value = "/userJoin", method = RequestMethod.GET)
	public void joinGET() {
		
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
	
	// 닉네임 중복체크
		@RequestMapping(value = "/nicknameChk", method = RequestMethod.POST)
		@ResponseBody
		public String	nicknameChkPOST(String nickname) throws Exception {
			
			int result = memberservice.nicknameCheck(nickname);
			
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
	
	// 로그인
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
	

	
	// 로그아웃
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logoutGET(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "redirect:/index";
	}
	
	// 아이디 찾기
	@RequestMapping(value="/findId", method=RequestMethod.GET)
	public String findIdGET() throws Exception {
		return "member/findId";
	}
	
	@RequestMapping(value="/findId", method=RequestMethod.POST)
	public String findIdPOST(MemberVO member, Model model) throws Exception {
		
		MemberVO findIdVo = memberservice.findId(member);
		
		if (findIdVo == null) {
			
			model.addAttribute("check",1);
			return "/member/msg";
		}else {
			model.addAttribute("check",0);
			model.addAttribute("imchaId", findIdVo.getImchaId());
			return "/member/resultId";
		}
	}
	
	// 아이디 결과
	@RequestMapping(value="/resultId", method=RequestMethod.GET)
	public String resultIdGET(HttpServletRequest request, Model model, @RequestParam(required=false,value="nickname")String phone,String nickname,MemberVO searchVO) throws Exception{
		
		searchVO.setNickname(nickname);
		searchVO.setPhone(phone);
		MemberVO findId = memberservice.findId(searchVO);
		
		model.addAttribute("searchVO", findId);
		
		return "/member/resultId";
	}
	
	// 비밀번호 찾기
	@RequestMapping(value="/findPw", method=RequestMethod.GET)
	public String findPwGET() throws Exception {
		
		return "member/findPw";
	}
	
	@RequestMapping(value="/findPw", method=RequestMethod.POST)
	public String findPwPOST(MemberVO member, HttpSession session, RedirectAttributes rttr) throws Exception{
		
		MemberVO findPwVo = memberservice.findPw(member);
		
		if(findPwVo == null) {
			rttr.addFlashAttribute("check", 1);
			return "/member/msg";
		}else {
			findPwVo.setImchaId(member.getImchaId());
			rttr.addFlashAttribute("check",0);
			rttr.addFlashAttribute("findPwVo", findPwVo);
			return "redirect:/member/updatePw";
		}
	}
	
	// 비밀번호 변경
	@RequestMapping(value="/updatePw", method=RequestMethod.GET)
	public void updatePwGET(@RequestParam(value="updatePw", defaultValue="", required=false) String imchaId, MemberVO member) throws Exception{
		
	}
	
	@RequestMapping(value="/updatePw", method=RequestMethod.POST)
	public String updatePwPOST(@RequestParam(value="updatePw", defaultValue="", required=false) String imchaId, MemberVO member) throws Exception{
		
		memberservice.updatePw(member);
		
		return "redirect:/member/login";
	}
}

