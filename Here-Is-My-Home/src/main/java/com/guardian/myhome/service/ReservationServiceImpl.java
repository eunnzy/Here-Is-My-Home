package com.guardian.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guardian.myhome.mapper.RevMapper;
import com.guardian.myhome.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	RevMapper revMapper;
	
	
	@Override
	public void insertRev(ReservationVO vo) {
		revMapper.insertRev(vo);
	}

	@Override
	public List<ReservationVO> getRevByImchaId(String imchaId) {
		
		return revMapper.getRevByImchaId(imchaId);
	}

	@Override
	public void delete(int revNum, String imchaId) {
		revMapper.delete(revNum, imchaId);
	}
	
	
	@Override
	public List<ReservationVO> getRevByLessor(String lessorId) {
		return revMapper.getRevByLessor(lessorId);
	}
	
	@Override
	public void changeRevState(int homeNum, String imchaId) {
		revMapper.changeRevState(homeNum, imchaId);
	}
	
	
	@Override
	public void reject(int revNum, String imchaId) {
		revMapper.reject(revNum, imchaId);
	}
	
}
