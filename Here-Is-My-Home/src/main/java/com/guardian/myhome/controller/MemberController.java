package com.guardian.myhome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.OptionVO;

/*
	회원 관련 컨트롤러
	
 */

@Controller
@RequestMapping("/member")
public class MemberController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String registerForm() {
		return "/member/login";
	}
	
}
