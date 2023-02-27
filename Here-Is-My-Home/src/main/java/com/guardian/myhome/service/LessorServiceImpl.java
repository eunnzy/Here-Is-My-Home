package com.guardian.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.dao.LessorDAO;
import com.guardian.myhome.mapper.LessorMapper;
import com.guardian.myhome.vo.LessorVO;


@Service
public class LessorServiceImpl implements LessorService {

	@Autowired
	LessorMapper lessormapper;
	
	@Autowired
	LessorDAO dao;
	
	@Override
	public void lessorJoin(LessorVO lessor) throws Exception {

		lessormapper.lessorJoin(lessor);

	}
	
	// 아이디 중복체크
	@Override
	public int idCheck(String lessorId) throws Exception {
		
		return lessormapper.idCheck(lessorId);
	}
	
	// 닉네임 중복체크
	@Override
	public int lessorNickNameCheck(String lessorNickName) throws Exception {
		return lessormapper.lessorNickNameCheck(lessorNickName);
	}
	
	@Override
	public LessorVO lessorLogin(LessorVO lessor) throws Exception {
		
		return lessormapper.lessorLogin(lessor);
	}
	
	// 아이디찾기
//	@Override
//	public LessorVO findLessorId(LessorVO lessor) throws Exception {
//			
//		return dao.findLessorId(lessor);
//	}
	
	@Override
	public String findLessorId(LessorVO lessor) throws Exception {
			
		return dao.findLessorId(lessor);
	}
		
	// 비밀번호 찾기
	@Override
	public LessorVO findLessorPw(LessorVO lessor) throws Exception {
			
		return dao.findLessorPw(lessor);
	}
		
	// 비밀번호 변경
	@Override
	public LessorVO updateLessorPw(LessorVO lessor) throws Exception {
			
		return dao.updateLessorPw(lessor);
	}
	
	@Override
	public LessorVO getLessor(LessorVO lessor) throws Exception {
		return lessormapper.getLessor(lessor);
	}
	
	@Override
	public void updateLessor(LessorVO lessor) throws Exception {
		lessormapper.updateLessor(lessor);
	}
	
	// 중개인 목록
	@Override
	public List<LessorVO> lessorList() {
		return dao.lessorList();
	}

	@Override
	public int successId(String lessorId) throws Exception {
		return lessormapper.successId(lessorId);
		
	}

	@Override
	public int failed(String lessorId) throws Exception {
		return lessormapper.failed(lessorId);
		
	}
	
	
}
