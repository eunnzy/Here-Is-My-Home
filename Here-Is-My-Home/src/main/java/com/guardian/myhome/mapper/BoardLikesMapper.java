package com.guardian.myhome.mapper;

public interface BoardLikesMapper {
	
	// 좋아요 눌렀는지 체크
	public int likeCheck(Long bno, String userid);
	
	// 좋아요 ON
	public void likesOn(Long bno, String userid);
	
	// 좋아요 OFF
	public void likesOff(Long bno, String userid);

}
