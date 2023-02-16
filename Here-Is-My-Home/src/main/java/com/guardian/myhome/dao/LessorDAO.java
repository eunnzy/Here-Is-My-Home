package com.guardian.myhome.dao;

import com.guardian.myhome.vo.LessorVO;

public interface LessorDAO {

	 LessorVO findLessorId(LessorVO member) throws Exception;
	 
	 LessorVO findLessorPw(LessorVO member) throws Exception;
	 
	 LessorVO updateLessorPw(LessorVO member) throws Exception;
}
