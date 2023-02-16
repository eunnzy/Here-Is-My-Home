package com.guardian.myhome.service;

import com.guardian.myhome.vo.LessorVO;

public interface LessorService {

	// 중개인 회원가입
	public void lessorJoin(LessorVO lessor) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String lessorId) throws Exception;
	
	// 닉네임 중복검사
	public int lessorNickNameCheck(String lessorNickName) throws Exception;
	
	// 로그인
	public LessorVO lessorLogin(LessorVO lessor) throws Exception;
		
	// 아이디 찾기
	public LessorVO findLessorId(LessorVO lessor) throws Exception;
		
	// 비밀번호 찾기
	public LessorVO findLessorPw(LessorVO lessor) throws Exception;
		
	// 비밀번호 변경
	public LessorVO updateLessorPw(LessorVO lessor) throws Exception;
	
	// 회원정보 저장
	public LessorVO getLessor(LessorVO lessor) throws Exception;
	
	// 회원정보 수정
	public void updateLessor(LessorVO lessor) throws Exception;
}
