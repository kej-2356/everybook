package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.RentMapper;
import team1.project.vo.Book;
import team1.project.vo.Rent;

@Service
@Transactional
public class RentService {
	@Autowired private RentMapper rentMapper;
	
	//대여처리
	public int addBookRent(Rent rent) {
		return rentMapper.addBookRent(rent);
	}
	
	//코드 검색
	public Rent getRentCode(String rentCode) {
		return rentMapper.getRentCode(rentCode);
	}
	
	//대여관리 대여리스트 -삭제
	public int officeRentDelete(Rent rent) {
		return rentMapper.officeRentDelete(rent);
	}
	
	//대여관리 대여리스트 - 검색
	public List<Rent> OfficeRentListSerch(String sk, String sv){
		return rentMapper.OfficeRentListSerch(sk, sv);
	}
	
	//대여관리 대여리스트
	public List<Rent> officeRentList(){
		return rentMapper.officeRentList();
	}
	
	//나의 대여 이력 - 검색
	public List<Rent> myRentHistorySearch(String sk, String sv, String SID){
		return rentMapper.myRentHistorySearch(sk, sv, SID);
	}
	
	//나의 대여 이력
	public List<Rent> myRentHistoryList(String SID){
		return rentMapper.myRentHistoryList(SID);
	}
}
