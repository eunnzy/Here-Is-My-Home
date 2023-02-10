package com.guardian.myhome.mapper;

import com.guardian.myhome.vo.AdminVO;


public interface AdminMapper {

	// 회원가입
	public void adminJoin(AdminVO admin);
	
	// 아이디 중복 검사
	public int idCheck(String adminId);
	
	// 로그인
	public AdminVO adminLogin(AdminVO admin);
}
