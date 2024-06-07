package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Rent;

@Mapper
public interface ExtendMapper {

	//연장신청
	public int myRentExtend(String rentCode);
	
	//나의 현재 대여중 도서 조회
	public List<Rent> myRentList(String SID);
}
