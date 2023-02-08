package com.guardian.myhome.service;

import java.util.List;

import com.guardian.myhome.vo.BoardVO;


public interface BoardService {
	
	// 등록 
	public void register(BoardVO board);
		
	// 조회
	public BoardVO get(Long bno);
		
	// 수정 
	public boolean modify(BoardVO board);
		
	// 삭제
	public boolean remove(Long bno);
		
//	// 동네별 목록
//	public List<BoardVO> getList();
	
	// 전국 목록
	public List<BoardVO> getAllList();
	
	// 카테고리별 목록 
	public List<BoardVO> getCategoryList(String category);
	
	// 조회수 
	public boolean viewsUp(Long bno);
	
	// 좋아요
	public boolean likesUp(Long bno);

}
