package com.guardian.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.guardian.myhome.vo.MemberVO;

public interface MemberMapper {

	// 회원가입
	public void memberJoin(MemberVO member);
	
	// 아이디 중복 검사
	public int idCheck(String imchaId);
	
	// 닉네임 중복 검사
	public int nicknameCheck(String nickname);
	
	// 로그인
	public MemberVO memberLogin(MemberVO member);
	
	
	
	
	// 정보 수정
	public void updateMember(MemberVO member);
	
	// 정보 저장
	public MemberVO getMember(MemberVO memeber);
	
	
}
