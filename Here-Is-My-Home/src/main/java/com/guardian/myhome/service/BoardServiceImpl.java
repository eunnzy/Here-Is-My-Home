package com.guardian.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.mapper.BoardMapper;
import com.guardian.myhome.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	// 등록 
	@Override
	public void register(BoardVO board) {
		log.info("register........" + board);
		mapper.insertSelectKey(board);
	}

	// 조회
	@Override
	public BoardVO get(Long bno) {
		log.info("get........" + bno);
		return mapper.read(bno);
	}

	// 수정
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify........" + board);
		return mapper.update(board) == 1;
	}

	// 삭제
	@Override
	public boolean remove(Long bno) {
		log.info("remove........" + bno);
		return mapper.delete(bno) == 1;
	}

//	// 같은 동네 목록
//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList........");
//		return mapper.getList();
//	}

	// 전국 목록
	@Override
	public List<BoardVO> getAllList() {
		log.info("getList........");
		return mapper.getAllList();
	}

	// 카테고리별 목록 
	@Override
	public List<BoardVO> getCategoryList(String category) {
		log.info("getList........");
		return mapper.getCategoryList(category);
	}
	
	// 조회수 
	@Override
	public boolean viewsUp(Long bno) {
		log.info("viewsUp........" + bno);
		return mapper.viewsUp(bno) == 1;
	}

	// 좋아요 
	@Override
	public boolean likesUp(Long bno) {
		log.info("likesUp........" + bno);
		return mapper.likesUp(bno) == 1;
	}

}
