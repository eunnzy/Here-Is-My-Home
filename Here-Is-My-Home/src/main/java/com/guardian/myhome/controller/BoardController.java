	
//	// 조회수가 올라가는 조회처리 
//	@GetMapping("/get")
//	public String get(@RequestParam("bno") Long bno, Model model, Criteria cri) {
//		log.info("/get");
//		service.viewsUp(bno);
//		
//		model.addAttribute("board", service.get(bno));
//		return "/community/get";
//	}
//	
//	// 수정 페이지 불러오는 매핑
//	@GetMapping("/modify")
//	public String modify(@RequestParam("bno") Long bno, Model model, Criteria cri) {
//		log.info("/modify");
//		
//		model.addAttribute("board", service.get(bno));
//		return "/community/modify";
//	}
//	
//	// 수정
//	@PostMapping("updateBoard.do")
//	public String modify(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
//		log.info("modify : " + vo);
//		service.modify(vo);
//		if(service.modify(vo)) {
//			rttr.addFlashAttribute("result", "success");
//		}
//		return "redirect:/community/list" + cri.getListLink();
//	}
//		
//	// 삭제 
//	@RequestMapping("delete.do")
//	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr, Criteria cri) {
//		log.info("remove..." + bno);
//		service.remove(bno);
//		if(service.remove(bno)) {
//			rttr.addFlashAttribute("result", "success");
//		}
//		return "redirect:/community/list" + cri.getListLink();
//	}
//	
//}



package com.guardian.myhome.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guardian.myhome.service.BoardService;
import com.guardian.myhome.vo.BoardVO;
import com.guardian.myhome.vo.Criteria;
import com.guardian.myhome.vo.PageDTO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/community/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	// 같은 동네 목록 페이지 list정보와 함께 전달 -> 지금 일반회원 vo가 없어서 메소드가 전국으로 등록되어 있음(닉네임 파트도 회원ID로 처리)
	@RequestMapping("/list")
	public String list(Model model, Criteria cri) {
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		
		int total = service.getTotal(cri);
		log.info("total : " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		return "/community/list";
	}
	
	// 회원정보 함께 넘기기 
	// 등록 페이지 불러오는 매핑
	@RequestMapping("/register")
	public String register() {
		return "/community/register";
	}
	
	// 조회수가 올라가는 조회처리 
	@RequestMapping("/get")
	public String get(@RequestParam("bno") Long bno, Model model, Criteria cri) {
		log.info("/get");
		service.viewsUp(bno);
		model.addAttribute("board", service.get(bno));
		return "/community/get";
	}
	
	// 수정테이블 불러오기
	@RequestMapping("/modify")
	public String modify(Long bno, Model model, Criteria cri) {
		model.addAttribute("board", service.get(bno));
		return "/community/modify";
	}
	
	// 등록 처리 
	@RequestMapping("insertBoard.do")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/community/list";
	}
	
	// 수정
	@RequestMapping("updateBoard.do")
	public String modify(BoardVO vo, RedirectAttributes rttr, Criteria cri) {
		log.info("modify : " + vo);
		service.modify(vo);
		return "redirect:/community/list" + cri.getListLink();
	}
		
	// 삭제 
	@RequestMapping("delete.do")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr, Criteria cri) {
		log.info("remove..." + bno);
		service.remove(bno);
		return "redirect:/community/list" + cri.getListLink();
	}
	
}

