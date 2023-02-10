package com.guardian.myhome.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guardian.myhome.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={ 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class MemberMapperTest {

	@Autowired
	private MemberMapper membermapper;
	
	@Test
	public void memberJoin() throws Exception{
		MemberVO member = new MemberVO();
		
		member.setImchaId("test");
		member.setImchaPw("test");
		member.setNickname("test");
		member.setPhone("010-1111-1111");
		member.setUserRoll("test");
		member.setSido1("서울시");
		member.setGugun1("강남구");
		
		membermapper.memberJoin(member);
	}
	
	// @Test
	public void memberLogin() throws Exception {
		MemberVO member = new MemberVO();
		
		member.setImchaId("hong");
		member.setImchaPw("1234");
		
		membermapper.memberLogin(member);
		System.out.println("결과 값 : " + membermapper.memberLogin(member));
	}
}
