package com.guardian.myhome.mapper;

import java.util.List;

import com.guardian.myhome.vo.BoardVO;

public interface BoardMapper {
	
	// 전국 목록 리스트
	public List<BoardVO> getAllList();
	
//	// 같은 동네 목록 리스트
//	public List<BoardVO> getList();
	
	// 카테고리별 목록 리스트
	public List<BoardVO> getCategoryList(String category);
		
	// INSERT처리만 되고 생성된 PK값을 알 필요가 없는 경우 
	public void insert(BoardVO board);
		
	// INSERT처리도 되고 생성된 PK값을 알아야 하는 경우 
	public void insertSelectKey(BoardVO board);
		
	// 조회
	public BoardVO read(Long bno);
		
	// 삭제
	public int delete(Long bno);
		
	// 수정
	public int update(BoardVO board);
	
	// 조회수 증가
	public int viewsUp(Long bno);
	
	// 좋아요 증가
	public int likesUp(Long bno);

}
