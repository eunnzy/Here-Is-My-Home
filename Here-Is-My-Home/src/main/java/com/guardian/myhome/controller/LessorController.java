package com.guardian.myhome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
		
		return "redirect:/member/lessorLogin";
	}
	
	// 아이디 중복체크
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
	
	// 닉네임 중복체크
	@RequestMapping(value = "/lessorNickNameChk", method = RequestMethod.POST)
	@ResponseBody
	public String lessorNickNameChkPOST(String lessorNickName) throws Exception {
				
	int result = lessorservice.lessorNickNameCheck(lessorNickName);
				
	if (result != 0) {
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
	public String lessorloginPOST(HttpServletRequest request, LessorVO lessor, RedirectAttributes rttr) throws Exception{
		
//		System.out.println("login 메서드 진입");
//		System.out.println("전달된 데이터 : " + lessor);
		
		HttpSession session = request.getSession();
		LessorVO lvo = lessorservice.lessorLogin(lessor);
		System.out.println(lvo.getStatus());
		if(lvo.getStatus() == 0 || lvo == null){
			
			 return "redirect:/member/lessorLogin";
		} else {
			session.setAttribute("lessor", lvo);
			return "redirect:/index";
		}
		
////		if(lvo == null) {
////			int result = 0;
////			rttr.addFlashAttribute("result", result);
////			return "redirect:/member/lessorLogin";
////		} else {
////			
////			session.setAttribute("lessor", lvo);
//			return "redirect:/index";
////		}

	}
	
//	// 로그아웃
//	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
//	public String logoutGET(HttpServletRequest request) throws Exception {
//		
//		HttpSession session = request.getSession();
//		
//		session.invalidate();
//		
//		return "redirect:/index";
//	}
	@RequestMapping(value = "lessorLoginCheck")
	@ResponseBody
	public int lessorLoginCheck(String id, String pw) throws Exception {
		LessorVO Lvo = new LessorVO();
		Lvo.setLessorId(id);
		Lvo.setLessorPw(pw);
		LessorVO newVo = lessorservice.lessorLogin(Lvo);
		System.out.println(newVo.getStatus());
		if(newVo.getStatus() == 1) {
			return 1;
		}else {
		return 0;
		}
	}
	// 아이디 찾기
		@RequestMapping(value="/findLessorId", method=RequestMethod.GET)
		public String findLessorIdGET() throws Exception {
			return "member/findLessorId";
		}
		
		@RequestMapping(value="/findLessorId", method=RequestMethod.POST)
		public String findLessorIdPOST(LessorVO lessor, Model model) throws Exception {
			
			LessorVO findLessorIdVo = lessorservice.findLessorId(lessor);
			
			if (findLessorIdVo == null) {
				
				model.addAttribute("check",1);
				return "/member/msg";
			}else {
				model.addAttribute("check",0);
				model.addAttribute("lessorId", findLessorIdVo.getLessorId());
				return "/member/resultLessorId";
			}
		}
		
		// 아이디 결과
		@RequestMapping(value="/resultLessorId", method=RequestMethod.GET)
		public String resultLessorIdGET(HttpServletRequest request, Model model, @RequestParam(required=false,value="lessornickName")String phone,String lessorNickName,LessorVO searchVO) throws Exception{
			
			searchVO.setLessorNickName(lessorNickName);
			searchVO.setPhone(phone);
			LessorVO findLessorId = lessorservice.findLessorId(searchVO);
			
			model.addAttribute("searchVO", findLessorId);
			
			return "/member/resultLessorId";
		}
		
		// 비밀번호 찾기
		@RequestMapping(value="/findLessorPw", method=RequestMethod.GET)
		public String findLessorPwGET() throws Exception {
			
			return "member/findLessorPw";
		}
		
		@RequestMapping(value="/findLessorPw", method=RequestMethod.POST)
		public String findLessorPwPOST(LessorVO lessor, HttpSession session, RedirectAttributes rttr) throws Exception{
			
			LessorVO findLessorPwVo = lessorservice.findLessorPw(lessor);
			
			if(findLessorPwVo == null) {
				rttr.addFlashAttribute("check", 1);
				return "/member/msg";
			}else {
				findLessorPwVo.setLessorId(lessor.getLessorId());
				rttr.addFlashAttribute("check",0);
				rttr.addFlashAttribute("findLessorPwVo", findLessorPwVo);
				return "redirect:/member/updateLessorPw";
			}
		}
		
		// 비밀번호 변경
		@RequestMapping(value="/updateLessorPw", method=RequestMethod.GET)
		public void updateLessorPwGET(@RequestParam(value="updateLessorPw", defaultValue="", required=false) String lessorId, LessorVO lessor) throws Exception{
			
		}
		
		@RequestMapping(value="/updateLessorPw", method=RequestMethod.POST)
		public String updateLessorPwPOST(@RequestParam(value="updatelessorPw", defaultValue="", required=false) String lessorId, LessorVO lessor) throws Exception{
			
			lessorservice.updateLessorPw(lessor);
			
			return "redirect:/member/lessorLogin";
		}
		
		// 중개인 리스트
		@GetMapping("/lessorList")
		public String lessorList(Model model) {
			System.out.println("/lessorList 요청");
			List<LessorVO> list = lessorservice.lessorList();
			model.addAttribute("list", list);
			return "member/lessorList";
		}

		
//    @ResponseBody
//	@PostMapping("/lessorId")
//	public void successId(String lessorId,LessorVO lessor) throws Exception {
//		System.out.println(lessorId);
//		System.out.println("open! user sign success Id ajax!");
//		lessorservice.lessorId(lessor);
//		
//	}
}
