package com.guardian.myhome.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guardian.myhome.vo.OptionVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={ 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class HomeOptionTest {
	@Autowired
	private HomeMapper homeMapper;
	
	@Test
	public void addOption() throws Exception {
		int homeNum = 1;
		String[] optionList = {"냉장고", "TV", "세탁기"};
		
//		List<OptionVO> option = new ArrayList<>();
		for(String op: optionList) {
			OptionVO option = new OptionVO();
			option.setHomeNum(homeNum);
			option.setOptionName(op);
			homeMapper.insertOption(option);
		}
		
//		System.out.println(option);

		
			
	}
}