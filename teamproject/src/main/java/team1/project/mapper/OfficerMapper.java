package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.License;
import team1.project.vo.Officer;

@Mapper
public interface OfficerMapper {
	
	//나의정보 수정
	public int myOfficeModify(Officer officer);
	
	//직원등록 - 직원아이디 자동생성
	public Officer getOfficerId();
	
	//나의직원정보 - 자격증조회
	public List<License> getOfficerLicense(String SID);
	
	//나의직원정보
	public List<Officer> getMyOffice(String SID);
	 
	//직원리스트 검색
	public List<Officer> getSerchOfficer(String sk, String sv);
	
	//직원리스트
	public List<Officer> getOfficerList();
	
	//직원등록
	public int addOfficer(Officer officer); 
}
