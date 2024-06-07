package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.ReturnMapper;
import team1.project.vo.Return;

@Service
@Transactional
public class ReturnService {
	@Autowired private ReturnMapper returnMapper;
	
	//반납관리 - 반납도서리스트 검색
	public List<Return> officeReturnListSearch(String sk, String sv){
		return returnMapper.officeReturnListSearch(sk, sv);
	}
	
	//반납관리 - 반납도서리스트 조회
	public List<Return> officeReturnList(){
		return returnMapper.officeReturnList();
	}
	
}
