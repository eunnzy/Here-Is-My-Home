package com.guardian.myhome.service;

import com.guardian.myhome.vo.MemberVO;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberVO member) throws Exception;
	
	// 아이디 중복검사
	public int idCheck(String imchaId) throws Exception;
	
	// 로그인
	public MemberVO memberLogin(MemberVO member) throws Exception;
	
	// 아이디 찾기
	public MemberVO findId(MemberVO member) throws Exception;
	
	// 비밀번호 찾기
	public MemberVO findPw(MemberVO member) throws Exception;
	
	// 비밀번호 변경
	public MemberVO updatePw(MemberVO member) throws Exception;
	
	// 회원정보수정
	public void updateMember(MemberVO member) throws Exception;
	
	// 회원정보 저장
	public MemberVO getMember(MemberVO member) throws Exception;

	public int nicknameCheck(String nickname) throws Exception;
}
