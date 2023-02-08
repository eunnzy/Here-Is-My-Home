package com.guardian.myhome.service;

import com.guardian.myhome.vo.LessorVO;

public interface LessorService {

	// 중개인 회원가입
	public void lessorJoin(LessorVO lessor) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String lessorId) throws Exception;
	
	// 닉네임 중복 검사
//	public int nicknameCheck(String lessorNickName) throws Exception;
	
	// 로그인
	public LessorVO lessorLogin(LessorVO lessor) throws Exception;
}
