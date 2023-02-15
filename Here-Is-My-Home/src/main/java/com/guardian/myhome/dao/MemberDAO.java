package com.guardian.myhome.dao;

import com.guardian.myhome.vo.MemberVO;

public interface MemberDAO {

	 MemberVO findId(MemberVO member) throws Exception;
	 
	 MemberVO findPw(MemberVO member) throws Exception;
	 
	 MemberVO updatePw(MemberVO member) throws Exception;
}
