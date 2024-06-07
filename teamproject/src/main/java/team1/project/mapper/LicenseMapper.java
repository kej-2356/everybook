package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.OfficerLicense;

@Mapper
public interface LicenseMapper {
	
	//자격증 신규 등록
	public int addNewLicense(OfficerLicense officerLicense);
	
	//자격증 이름으로 코드검색
	public OfficerLicense getLicenseCodeSearch(String licenseNameSK);
	
	//자격증 등록
	public int addLicense(OfficerLicense officerLicense);
}
