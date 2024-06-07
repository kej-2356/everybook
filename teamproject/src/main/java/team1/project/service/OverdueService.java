package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.OverdueMapper;
import team1.project.vo.Overdue;

@Service
@Transactional
public class OverdueService {
	@Autowired private OverdueMapper overdueMapper;
	
	//연체도서리스트 - 수정처리
	public int officeOverdueModify(String overdueCode, String rentReturnDate) {
		return overdueMapper.officeOverdueModify(overdueCode, rentReturnDate);
	}
	
	//연체도서리스트 - 수정 - 선택한 정보
	public Overdue getOverdueModify(String overdueCodeModify) {
		Overdue overdue = overdueMapper.getOverdueModify(overdueCodeModify);
		return overdue;
	}
	
	//연체도서리스트 - 삭제
	public int deleteOfficeOverdue(String overdueCodeDelete) {
		return overdueMapper.deleteOfficeOverdue(overdueCodeDelete);
	}
	
	//연체도서리스트
	public List<Overdue> officeOverdueList(){
		List<Overdue> list = overdueMapper.officeOverdueList();
		return list;
	}
	
}
