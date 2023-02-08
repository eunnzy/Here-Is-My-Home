package com.guardian.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.mapper.BoardMapper;
import com.guardian.myhome.vo.BoardVO;
import com.guardian.myhome.vo.Criteria;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	// 전국 목록
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List With Paging......" + cri);
		return mapper.getListWithPaging(cri);
	}
	
	// 게시물 전체 갯수
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

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
		log.info("remove........" + board);
		return mapper.update(board) == 1;
	}
	
	// 삭제 
	@Override
	public boolean remove(Long bno) {
		log.info("remove........" + bno);
		return mapper.delete(bno) == 1;
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
