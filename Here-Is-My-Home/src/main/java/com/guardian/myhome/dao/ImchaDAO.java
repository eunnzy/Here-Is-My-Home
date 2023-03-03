package com.guardian.myhome.dao;

import com.guardian.myhome.vo.ImchaVO;

public interface ImchaDAO {

//	 ImchaVO findId(ImchaVO imcha) throws Exception;
	
	 String findId(ImchaVO imcha) throws Exception;
	 
	 ImchaVO findPw(ImchaVO imcha) throws Exception;
	 
	 ImchaVO updatePw(ImchaVO imcha) throws Exception;
}
