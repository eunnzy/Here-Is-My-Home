package com.guardian.myhome.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guardian.myhome.vo.LessorVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={ 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class LessorMapperTest {

	@Autowired
	private LessorMapper lessormapper;
	
	// 회원가입 테스트
	public void lessorJoin() throws Exception{
		LessorVO lessor = new LessorVO();
		
		lessor.setLessorId("test");
		lessor.setLessorPw("test");
		lessor.setLessorNickName("test");
		lessor.setPhone("010-0000-0000");
		lessor.setName("test");
		lessor.setBirthDate("1990-01-01");
		lessor.setJgsName("test");
		lessor.setJgsNum("0010011");
		lessor.setUserRoll("중개인");
		lessor.setLessorAddr1("test");
		lessor.setLessorAddr2("test");
		lessor.setLessorAddr3("test");
		
		lessormapper.lessorJoin(lessor);
	}
	
	//@Test
	public void lessorLogin() throws Exception{
		
		LessorVO lessor = new LessorVO();
		
		lessor.setLessorId("lee");
		lessor.setLessorPw("1234");
		
		lessormapper.lessorLogin(lessor);
		System.out.println("결과 값 : " + lessormapper.lessorLogin(lessor));
	}
	
	@Test
	public void successId() throws Exception{
		
		lessormapper.successId("lee");

	}
	
}
