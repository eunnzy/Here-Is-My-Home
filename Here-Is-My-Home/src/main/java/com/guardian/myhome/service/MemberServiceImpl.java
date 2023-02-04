package com.guardian.myhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.mapper.MemberMapper;
import com.guardian.myhome.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper membermapper;
	
	@Override
	public void memberJoin(MemberVO member) throws Exception {

		membermapper.memberJoin(member);
	}
	
	@Override
	public int idCheck(String imchaId) throws Exception {
		return membermapper.idCheck(imchaId);
	}

}
