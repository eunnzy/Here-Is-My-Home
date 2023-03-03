package com.guardian.myhome.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guardian.myhome.mapper.RevMapper;
import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.vo.ReservationVO;

@Controller
@RequestMapping("home/reservation")
public class ReservationController {
	
	@Autowired
	RevMapper revMapper;
	
	@Autowired
	HomeService homeService;
	
	// 회원방문예약 신청
	@RequestMapping(value="/enroll")
	@ResponseBody
	public String insertRev(ReservationVO vo, String revTime, int homeNum, HttpServletResponse response) throws IOException {
		Map<String, Object> home =  homeService.selectHomeDetail(homeNum);
		System.out.println(home);
		vo.setRevDate(vo.getRevDate()+' ' + revTime);
		revMapper.insertRev(vo);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
        out.println("<script>alert('예약이 완료되었습니다.');history.go(-1);</script>");
        out.flush();

		return "/home/detail";
	}
	
	// 회원이 보는 예약신청 목록
	@RequestMapping("/list")
	public String getRevByImchaId(String imchaId, Model model) {
		List<ReservationVO> revList = revMapper.getRevByImchaId(imchaId);
	
		for(int i=0; i<revList.size(); i++) {
			int tmp = revList.get(i).getRevState();
			if(tmp==0) {
				revList.get(i).setState("확인 중 입니다.");
			} else if (tmp==1) {
				revList.get(i).setState("예약 확정되었습니다.");
			} else {
				revList.get(i).setState("예약 거절되었습니다.");
			}
		
		
		}
		System.out.println("error1");
		
		model.addAttribute("revList",revList);
		return "mypage/reservationImcha";
	}
	
	// 회원이 예약 취소
	@RequestMapping("/cancel")
	public String delete(int revNum, String imchaId) {
		revMapper.delete(revNum, imchaId);
		return "/home/reservation/list";
	}
	
	// 중개인이 보는 예약 목록
	@RequestMapping("/lessorList")
	public String getRevByLessor(String lessorId, Model model){
		List<ReservationVO> lessorList = revMapper.getRevByLessor(lessorId);
		
		model.addAttribute("lessorList",lessorList);

		return "mypage/reservationLessor";
	}
	
	// 예약 거부
	@RequestMapping("/reject")
	public String reject(int revNum, String imchaId) {
		revMapper.reject(revNum, imchaId);
		return "/home/reservation/lessorList";
	}
	
	// 예약 확정
	@RequestMapping("/allow")
	public String changeRevState(int homeNum, String imchaId) {
		revMapper.changeRevState(homeNum, imchaId);
		return "/home/reservation/lessorList";
	}
 }
