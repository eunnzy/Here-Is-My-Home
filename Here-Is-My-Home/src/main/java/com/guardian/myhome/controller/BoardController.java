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

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/community/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	// 같은 동네 목록 페이지 list정보와 함께 전달 -> 지금 일반회원 vo가 없어서 메소드가 전국으로 등록되어 있음(닉네임 파트도 회원ID로 처리)
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getAllList());
		return "/community/list";
	}
	
	// 전국 목록 
	@GetMapping("/allList")
	public String allList(Model model) {
		log.info("allList");
		model.addAttribute("allList", service.getAllList());
		return "/community/allList";
	}
	
	// 카테고리별 목록 
	@GetMapping("/categoryList")
	public String categoryList(String category, Model model) {
		log.info("categoryList");
		model.addAttribute("categoryList", service.getCategoryList(category));
		return "/community/categoryList";
	}
	
	// 회원정보 함께 넘기기 
	// 등록 페이지 불러오는 매핑
	@GetMapping("/register")
	public String register() {
		return "/community/register";
	}
	
	// 등록 처리 
	@PostMapping("insertBoard.do")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/community/list";
	}
		
	// 조회수가 올라가는 조회처리 
	@GetMapping("/get")
	public String get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		service.viewsUp(bno);
		model.addAttribute("board", service.get(bno));
		return "/community/get";
	}
	
	// 수정 페이지 불러오는 매핑
	@GetMapping("/modify")
	public String modify(Long bno, Model model) {
		model.addAttribute("updateboard", service.get(bno));
		return "/community/modify";
	}
	
	// 수정
	@PostMapping("updateBoard.do")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("modify : " + vo);
		service.modify(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/community/list";
	}
		
	// 삭제 
	@RequestMapping("delete.do")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		service.remove(bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/community/list";
	}
	
}
