package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.OfficerMapper;
import team1.project.vo.License;
import team1.project.vo.Officer;

@Service
@Transactional
public class OfficerService {
	
	@Autowired private OfficerMapper officerMapper;
	
		//나의정보 수정
		public int myOfficeModify(Officer officer) {
			return officerMapper.myOfficeModify(officer);
		}
	
		//직원아이디 자동생성
		public Officer getOfficerId() {
			return officerMapper.getOfficerId();
		}
		
		//나의정보 - 자격증 조회
		public List<License> getOfficerLicense(String SID){
			return officerMapper.getOfficerLicense(SID);
		}
	
		//나의 정보
		public List<Officer> getMyOffice(String SID){
			return officerMapper.getMyOffice(SID);			
		}
	
		//직원리스트 검색
		public List<Officer> getSerchOfficer(String sk, String sv){
			return officerMapper.getSerchOfficer(sk, sv);
		}
		
		//직원리스트
		public List<Officer> getOfficerList(){
			return officerMapper.getOfficerList();
		}
	
		//직원등록
		public int addOfficer(Officer officer) {
			return officerMapper.addOfficer(officer);
		}

}
