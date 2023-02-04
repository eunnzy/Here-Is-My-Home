package com.guardian.myhome.service;

import com.guardian.myhome.vo.MemberVO;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberVO member) throws Exception;
	
	// 아이디 중복검사
	public int idCheck(String imchaId) throws Exception;
}
