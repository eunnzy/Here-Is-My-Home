package com.guardian.myhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.mapper.LessorMapper;
import com.guardian.myhome.vo.LessorVO;

@Service
public class LessorServiceImpl implements LessorService {

	@Autowired
	LessorMapper lessormapper;
	
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

}
