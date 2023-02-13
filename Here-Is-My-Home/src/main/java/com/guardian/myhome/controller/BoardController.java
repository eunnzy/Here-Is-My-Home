package com.guardian.myhome.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/community/")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	// 목록 리스트 (전국)
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		
		int total = service.getTotal(cri);
		log.info("total : " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		return "/community/list";
	}
	
	// 등록 페이지 불러오는 매핑
	@GetMapping("/register")
	public String register() {
		return "/community/register";
	}
	
	// 조회수가 올라가는 조회처리 
	@GetMapping("/get")
	public String get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("cri") Criteria cri) {
		log.info("/get");
		service.viewsUp(bno);
		model.addAttribute("board", service.get(bno));
		return "/community/get";
	}
	
	// 수정테이블 불러오기
	@GetMapping("/modify")
	public String modify(Long bno, Model model, @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("board", service.get(bno));
		return "/community/modify";
	}
	
	// 등록 처리 
	@PostMapping("insertBoard.do")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect: /community/list";
	}
	
	// 수정
	@PostMapping("updateBoard.do")
	public String modify(BoardVO vo, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
		log.info("modify : " + vo);
		service.modify(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("type", cri.getType());
		return "redirect: /community/list";
	}
		
	// 삭제 
	@RequestMapping("delete.do")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
		log.info("remove..." + bno);
		service.remove(bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("type", cri.getType());
		return "redirect: /community/list";
	}
	
}

