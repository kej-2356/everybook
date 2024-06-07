package team1.project.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.LicenseService;
import team1.project.vo.OfficerLicense;

@Controller
public class LicenseController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);

	@Autowired private LicenseService licenseService; 
	
	//자격증 신규등록처리
	@PostMapping("/addOfficerNewLicense")
	public String addOfficerNewLicense(OfficerLicense officerLicense) {
		logger.info("==== 자격증 신규 등록처리 ===="); 
		logger.info("officerLicense --> " + officerLicense.toString());
		int i = licenseService.addNewLicense(officerLicense);
		return "admin/indexAdmin";
	}
	
	//자격증 신규등록화면
	@GetMapping("/addOfficerNewLicense")
	public String addOfficerNewLicense(Model model, HttpSession session) {
		logger.info("==== 자격증 신규 등록화면 ====");
		String SID = (String) session.getAttribute("SID");
		logger.info("SID --> " + SID);
		model.addAttribute("SID", SID);
		return "license/addOfficerNewLicense";
	}
	
	//자격증이름으로 코드검색
	@PostMapping(value="/licenseSearch")
	@ResponseBody
	public OfficerLicense getLicenseCodeSearch(@RequestParam("licenseNameSk") String licenseNameSk) {
		logger.info("==== 자격증 코드검색 ====");
		logger.info("licenseNameSk --> " + licenseNameSk);
		OfficerLicense officerLicense = licenseService.getLicenseCodeSearch(licenseNameSk);
		return officerLicense;
	}
	
	//자격증 등록처리
	@PostMapping("/addOfficerLicense")
	public String addLicense(OfficerLicense officerLicense) {
	logger.info("==== 자격증 등록처리 ===="); 
	logger.info("officerLicense --> " + officerLicense.toString());
	int i = licenseService.addLicense(officerLicense); 
	logger.info("실행결과 : " + i); 
	return "admin/indexAdmin"; 
	}
	 
	
	//자격증 등록화면
	@GetMapping("/addOfficerLicense")
	public String addOfficerLicense(Model model, HttpSession session) {
	logger.info("==== 자격증 등록화면 ====");
	String SID = (String) session.getAttribute("SID");
	logger.info("SID --> " + SID);
	model.addAttribute("SID", SID);
	return "license/addOfficerLicense";
	}
}
