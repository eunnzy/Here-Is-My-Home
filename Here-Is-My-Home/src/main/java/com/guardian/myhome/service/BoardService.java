package com.guardian.myhome.service;

import java.util.List;

import com.guardian.myhome.vo.BoardVO;
import com.guardian.myhome.vo.Criteria;


public interface BoardService {
	
	// 전국 목록
	public List<BoardVO> getList(Criteria cri);
	
	// 게시물 전체 갯수
	public int getTotal(Criteria cri);
	
	// 등록 
	public void register(BoardVO board);
		
	// 조회
	public BoardVO get(Long bno);
		
	// 수정 
	public boolean modify(BoardVO board);
		
	// 삭제
	public boolean remove(Long bno);
	
	// 조회수 
	public boolean viewsUp(Long bno);
	
	// 좋아요
	public boolean likesUp(Long bno);

}
