package com.guardian.myhome.mapper;

import java.util.List;

import com.guardian.myhome.vo.BoardVO;
import com.guardian.myhome.vo.Criteria;

public interface BoardMapper {
	// 전국 목록 리스트
	public List<BoardVO> getListWithPaging(Criteria cri);
		
	// 전체 게시물 갯수
	public int getTotalCount(Criteria cri);
			
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
		
	// 좋아요 감소
	public int likesDown(Long bno);
		
	// 내가 쓴 글 목록 리스트 
	public List<BoardVO> getMyboard(String imchaid);
		
	// 내가 쓴 글 갯수 
//	public int getMyboardCount(String imchaid);

}
