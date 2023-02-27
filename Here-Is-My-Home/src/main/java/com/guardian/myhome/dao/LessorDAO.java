package com.guardian.myhome.dao;

import java.util.List;

import com.guardian.myhome.vo.LessorVO;

public interface LessorDAO {

//	 LessorVO findLessorId(LessorVO lessor) throws Exception;
	 String findLessorId(LessorVO lessor) throws Exception;
	 LessorVO findLessorPw(LessorVO lessor) throws Exception;
	 
	 LessorVO updateLessorPw(LessorVO lessor) throws Exception;
	 
	 List<LessorVO> lessorList();
	 
	 LessorVO successId(LessorVO lessor) throws Exception;
}
