package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.ExtendMapper;
import team1.project.vo.Rent;

@Service
@Transactional
public class ExtendService {
	@Autowired private ExtendMapper extendMapper;
	
	//연장신청
	public int myRentExtend(String rentCode) {
		return extendMapper.myRentExtend(rentCode);
	}
	
	//나의 현재 대여중 도서 조회
	public List<Rent> mtRengList(String SID){
		return extendMapper.myRentList(SID);
	}
}
