package com.guardian.myhome.service;

import com.guardian.myhome.vo.MemberVO;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberVO member) throws Exception;
	
	// 아이디 중복검사
	public int idCheck(String imchaId) throws Exception;
	
	// 닉네임 중복검사
	public int nicknameCheck(String nickname) throws Exception;
	
	// 로그인
	public MemberVO memberLogin(MemberVO member) throws Exception;
	
	// 아이디 찾기
	public MemberVO findId(MemberVO member) throws Exception;
	
	// 비밀번호 찾기
	public MemberVO findPw(MemberVO member) throws Exception;
	
	// 비밀번호 변경
	public MemberVO updatePw(MemberVO member) throws Exception;
	
}
