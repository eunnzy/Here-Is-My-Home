package com.guardian.myhome.mapper;

import com.guardian.myhome.vo.LessorVO;
import com.guardian.myhome.vo.MemberVO;

public interface LessorMapper {

	// 중개인 회원가입
	public void lessorJoin(LessorVO lessor);
	
	// 아이디 중복 검사
	public int idCheck(String lessorId);
	
	// 닉네임 중복 검사
//	public int nicknameCheck(String lessorNickName);
	
	// 로그인 
	public LessorVO lessorLogin(LessorVO lessor);
	
	// 중개인 정보저장
	public LessorVO getLessor(LessorVO lessor);
	
	// 중개인 정보 수정
	public void updateLessor(LessorVO lessor);
}
