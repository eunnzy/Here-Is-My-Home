package com.guardian.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guardian.myhome.vo.BoardVO;
import com.guardian.myhome.vo.Criteria;

public interface BoardMapper {
	// 전국 목록 리스트
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	// 전체 게시물 갯수
	public int getTotalCount(Criteria cri);
	
	// 로그인 전 
	public List<BoardVO> beforeBoard(Criteria cri);
		
	// 로그인 후 
	public List<BoardVO> afterBoard(Criteria cri, String sido1, String gugun1);
		
	// 로그인 전 갯수
	public int beforeBoardCount(Criteria cri);
		
	// 로그인 후 갯수
	public int afterBoardCount(Criteria cri, String sido1, String gugun1);
			
	// 등록 
	public void insertSelectKey(BoardVO board);
			
	// 조회
	public BoardVO read(@Param("bno") Long bno);
			
	// 삭제
	public int delete(Long bno);
			
	// 수정
	public int update(BoardVO board);
	
	// 좋아요 증가
	public int likesUp(Long bno);
			
	// 좋아요 감소
	public int likesDown(Long bno);
		
		
		
	// 조회수 증가
	public int viewsUp(Long bno);
		
	// 내가 쓴 글 목록 리스트 
	public List<BoardVO> getMyboard(String imchaid);
		
	// 내가 쓴 글 갯수 
//	public int getMyboardCount(String imchaid);

}
