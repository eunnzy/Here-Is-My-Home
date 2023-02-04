package com.guardian.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
//	// 같은 동네 목록 
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list");
//		model.addAttribute("list", service.getList());
//	}
	
	// 전국 목록 
	@GetMapping("/allList")
	public void allList(Model model) {
		log.info("allList");
		model.addAttribute("allList", service.getAllList());
	}
	
	// 카테고리별 목록 
	@GetMapping("/categoryList")
	public void categoryList(String category, Model model) {
		log.info("categoryList");
		model.addAttribute("categoryList", service.getCategoryList(category));
	}
	
	// 등록 처리 
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}
		
	// 조회수가 올라가는 조회처리 
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		service.viewsUp(bno);
		model.addAttribute("board", service.get(bno));
	}
		
	// 수정
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("modify : " + vo);
			
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
		
	// 삭제 
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
//	@RequestMapping("/freeBoard")
//	public String detailHome() {
//		return "community/freeBoard";
//	}
}
