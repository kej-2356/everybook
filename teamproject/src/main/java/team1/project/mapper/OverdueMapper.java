package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Overdue;

@Mapper
public interface OverdueMapper {
	
	//연체도서리스트 수정처리
	public int officeOverdueModify(String overdueCode, String rentReturnDate);
	
	//연체도서리스트 수정화면 - 선택한 도서 정보 조회
	public Overdue getOverdueModify(String overdueCodeModify);
	
	//연체도서리스트 삭제
	public int deleteOfficeOverdue(String overdueCodeDelete);
	
	//연체도서리스트
	public List<Overdue> officeOverdueList();
}
