package com.guardian.myhome.mapper;

import java.util.List;

import com.guardian.myhome.vo.BoardAttachVO;

public interface BoardAttachMapper {
	// 등록
	public void insert(BoardAttachVO vo);
		
	// 삭제
	public void delete(String uuid);
		
	// 특정 게시물의 번호로 첨부파일을 찾는 작업 
	public List<BoardAttachVO> findByBno(Long bno);
}