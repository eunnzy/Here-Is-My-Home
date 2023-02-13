package com.guardian.myhome.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guardian.myhome.mapper.HomeMapper;
import com.guardian.myhome.vo.HomeDetailVO;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeOptionVO;
import com.guardian.myhome.vo.HomePreviewVO;
import com.guardian.myhome.vo.HomePriceVO;
import com.guardian.myhome.vo.HomeVO;

@Repository
public class HomeDAOImpl implements HomeDAO{
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int insertHome(HomeVO homeVO) {
		return sqlSession.insert("HomeMapper.insertHome", homeVO);
	}

	@Override
	public int insertHomeImgList(List<HomeImgVO> homeImgList) {
		return sqlSession.insert("HomeMapper.insertHomeImgList", homeImgList);
	}
	

	@Override
	public int insertHomePrice(HomePriceVO HomePriceVO) {
		return sqlSession.insert("HomeMapper.insertHomePrice", HomePriceVO);
	}

	@Override
	public int insertHomeOptionList(List<HomeOptionVO> homeOptionList) {
		return sqlSession.insert("HomeMapper.insertHomeOptionList", homeOptionList);
	}


	@Override
	public List<HomePreviewVO> selectHomeInBoundsList(Map<String, Object> mapBounds) {
		return sqlSession.selectList("HomeMapper.selectHomeInBoundsList", mapBounds);
	}
	
	@Override
	public HomeImgVO selectPreviewHomeImg(int homeNum) {
		return sqlSession.selectOne("HomeMapper.selectPreviewHomeImg", homeNum);
	}
	
	public HomeDetailVO selectHomeDetail(int homeNum) {
		return sqlSession.selectOne("HomeMapper.selectHomeDetail", homeNum);
	}

	@Override
	public List<HomeImgVO> selectHomeImgDetail(int homeNum) {
		return sqlSession.selectList("HomeMapper.selectHomeImgDetail", homeNum);
	}

	@Override
	public List<String> selectHomeOptionDetail(int homeNum) {
		return sqlSession.selectList("HomeMapper.selectHomeOptionDetail", homeNum);
	}
	
//	@Autowired
//	SqlSession sqlSession;
//	
//	@Override
//	public int insertHome(HomeVO homeVO) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
//		return homeMapper.insertHome(homeVO);
//	}
//
//	@Override
//	public int insertHomeImgList(List<HomeImgVO> homeImgList) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
//		return homeMapper.insertHomeImgList(homeImgList);
//	}
//
//	@Override
//	public int insertHomePrice(HomePriceVO HomePriceVO) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
//		return homeMapper.insertHomePrice(HomePriceVO);
//	}
//
//	@Override
//	public int insertHomeOptionList(List<HomeOptionVO> homeOptionList) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
//		return homeMapper.insertHomeOptionList(homeOptionList);
//	}
//
//
//	@Override
//	public List<HomePreviewVO> selectHomeInBoundsList(Map<String, Object> mapBounds) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class); 
//		return homeMapper.selectHomeInBoundsList(mapBounds);
//	}
//	
//	@Override
//	public HomeImgVO selectPreviewHomeImg(int homeNum) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
//		return homeMapper.selectPreviewHomeImg(homeNum);
//	}
//	
//	public HomeDetailVO selectHomeDetail(int homeNum) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
//		return homeMapper.selectHomeDetail(homeNum);
//	}
//
//	@Override
//	public List<HomeImgVO> selectHomeImgDetail(int homeNum) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
//		return homeMapper.selectHomeImgDetail(homeNum);
//	}
//
//	@Override
//	public List<String> selectHomeOptionDetail(int homeNum) {
//		HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
//		return homeMapper.selectHomeOptionDetail(homeNum);
//	}

}
