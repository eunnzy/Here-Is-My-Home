package com.guardian.myhome.service;

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
	
	@Override
	public int idCheck(String lessorId) throws Exception {
		
		return lessormapper.idCheck(lessorId);
	}
	
//	@Override
//	public int nicknameCheck(String lessorNickName) throws Exception {
//		
//		return lessormapper.nicknameCheck(lessorNickName);
//	}
	
	@Override
	public LessorVO lessorLogin(LessorVO lessor) throws Exception {
		
		return lessormapper.lessorLogin(lessor);
	}
	
	// 아이디찾기
		@Override
		public LessorVO findLessorId(LessorVO lessor) throws Exception {
			
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

}
