package com.guardian.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.dao.MemberDAO;
import com.guardian.myhome.mapper.MemberMapper;
import com.guardian.myhome.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper membermapper;
	
	@Autowired
	MemberDAO dao;
	
	
	// 회원가입
	@Override
	public void memberJoin(MemberVO member) throws Exception {

		membermapper.memberJoin(member);
	}
	
	// 아이디 중복체크
	@Override
	public int idCheck(String imchaId) throws Exception {
		return membermapper.idCheck(imchaId);
	}
	
	// 닉네임 중복체크
	@Override
	public int nicknameCheck(String nickname) throws Exception {
		return membermapper.nicknameCheck(nickname);
	}

	// 로그인
	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		
		return membermapper.memberLogin(member);
	}
	
	// 아이디찾기
	@Override
	public MemberVO findId(MemberVO member) throws Exception {
		
		return dao.findId(member);
	}
	
	// 비밀번호 찾기
	@Override
	public MemberVO findPw(MemberVO member) throws Exception {
		
		return dao.findPw(member);
	}
	
	// 비밀번호 변경
	@Override
	public MemberVO updatePw(MemberVO member) throws Exception {
		
		return dao.updatePw(member);
	}


}
