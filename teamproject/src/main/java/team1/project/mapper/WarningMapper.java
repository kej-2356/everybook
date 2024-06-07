package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Warning;

@Mapper
public interface WarningMapper {
	
	//도서평신고 삭제
	public int deleteWarning(String warningCode);
	
	//같은 도서관 코드를 가진 회원의 도서평 신고 내역(직원)
	public List<Warning> officeWarningList(String libraryCode);
	
	//도서평 신고 등록처리
	public int addWarning(Warning Warning);
}
