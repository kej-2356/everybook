package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.WarningMapper;
import team1.project.vo.Warning;

@Service
@Transactional
public class WarningService {

	@Autowired WarningMapper warningMapper;
	
	//도서평신고 삭제
	public int deleteWarning(String warningCode) {
		return warningMapper.deleteWarning(warningCode);
	};
	
	//같은 도서관 코드를 가진 회원의 도서평 신고 내역(직원)
	public List<Warning> officeWarningList(String libraryCode){
		return warningMapper.officeWarningList(libraryCode);
	};
	
	//도서평 신고 등록처리
	public int addWarning(Warning Warning) {
		return warningMapper.addWarning(Warning);
	};
	
}
