package com.guardian.myhome.mapper;

import com.guardian.myhome.vo.MemberVO;

public interface MemberMapper {

	// 회원가입
	public void memberJoin(MemberVO member);
	
	// 아이디 중복 검사
	public int idCheck(String imchaId);
	
	// 로그인
	public MemberVO memberLogin(MemberVO member);
}
