package com.guardian.myhome.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guardian.myhome.service.BoardService;
import com.guardian.myhome.vo.BoardLikesVO;
import com.guardian.myhome.vo.ReplyVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/like/")
@AllArgsConstructor
public class BoardLikesController {
	
	private BoardService service;
	
	// 좋아요 버튼 클릭 
	@PostMapping(value = "/click", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> likesclick(@PathVariable("bno") Long bno, @PathVariable("userid") String userid) {
		log.info("like button click.........");
		if(service.likeCheck(bno, userid)) {
			log.info("likeon -> likesOff");
			service.likesOff(bno, userid);
			return new ResponseEntity<>("likesOff", HttpStatus.OK);
		} else {
			log.info("likesOff -> likeon");
			service.likesOn(bno, userid);
			return new ResponseEntity<>("likesOn", HttpStatus.OK);
		}
	}
	

}
