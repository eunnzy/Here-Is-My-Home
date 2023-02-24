package com.guardian.myhome.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.guardian.myhome.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private static final String NAMESPACE = "com.guardian.myhome.mapper.MemberMapper";
	
	private final SqlSession sqlSession;
	
	@Inject
	public MemberDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 아이디 찾기
	@Override
	public MemberVO findId(MemberVO member) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".findId", member);
	}
	
	// 비밀번호 찾기
	@Override
	public MemberVO findPw(MemberVO member) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".findPw", member);
	}
	
	// 비밀번호 변경
	@Override
	public MemberVO updatePw(MemberVO member) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".updatePw", member);
	}
	

}

