package com.guardian.myhome.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guardian.myhome.vo.HomeImgVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={ 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class HomeImgMapperTest {
	@Autowired
	private HomeImgMapper homeImgMapper;
	
	
	@Test
	public void homeImg() throws Exception {
		HomeImgVO homeImg = homeImgMapper.previewHomeImg(1);
		System.out.println(homeImg);
	}

	
	
}
