package team1.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.controller.LibraryController;
import team1.project.mapper.LicenseMapper;
import team1.project.vo.OfficerLicense;

@Service
@Transactional
public class LicenseService {
	private final static Logger logger = LoggerFactory.getLogger(LibraryController.class);
	@Autowired private LicenseMapper licenseMapper;
	
	//자격증 신규등록
	public int addNewLicense(OfficerLicense officerLicense) {
		return licenseMapper.addNewLicense(officerLicense);
	}
	
	//자격증 이름으로 코드검색
	public OfficerLicense getLicenseCodeSearch(String licenseNameSK) {
		logger.info("getLicenseCodeSearch() LicenseService.java");
		logger.info("licenseNameSK --> " + licenseNameSK);
		return licenseMapper.getLicenseCodeSearch(licenseNameSK);
	}
	
	//자격증 등록
	public int addLicense(OfficerLicense officerLicense) {
		return licenseMapper.addLicense(officerLicense);
	}
}
