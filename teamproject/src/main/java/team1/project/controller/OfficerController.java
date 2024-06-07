package team1.project.controller;

import java.util.List;

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

import team1.project.service.LibraryService;
import team1.project.service.OfficerService;
import team1.project.vo.Library;
import team1.project.vo.License;
import team1.project.vo.Officer;

@Controller
public class OfficerController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	@Autowired OfficerService officerService;
	@Autowired LibraryService libraryService;
	
	
	//나의정보 수정처리
	@PostMapping("/myOfficeModify")
	public String myOfficeModify(Officer officer) {
		logger.info("==== 직원 나의정보 수정 처리 ====");		
		logger.info("officer -->" + officer.toString());
		int i = officerService.myOfficeModify(officer);
		logger.info("실행결과 : " + i);
		return "redirect:/myOffice";
	}
	//나의정보 수정화면
	@GetMapping("/myOfficeModify")
	public String myOfficeModify(Officer officer, Model model ) {
		logger.info("==== 직원 나의정보 수정화면 ====");
		logger.info("officer -> " + officer.toString());				  
		
		List<Officer> officerList = officerService.getMyOffice(officer.getOfficerId());
		logger.info("==== 나의 정보 getMyOffice() ====");
		logger.info("officerList --> " + officerList);
		model.addAttribute("officerList", officerList.get(0));
		
		List<License> licenseList = officerService.getOfficerLicense(officer.getOfficerId());
		logger.info("==== 자격증조회 getOfficerLicense() ====");
		logger.info("licenseList --> " + licenseList);
		model.addAttribute("licenseList", licenseList);
		 		
		return "office/myOfficeModify";
	}
	
	//도서관이름으로 코드검색
	@PostMapping(value="/libraryCodeSearch")
	@ResponseBody
	public Library getLibraryCodeSearch(@RequestParam("libraryNameSk") String libraryNameSk) {
		logger.info("==== 도서관 코드검색 ====");
		logger.info("libraryNameSk --> " + libraryNameSk);
		Library library = libraryService.getLibraryCodeSearch(libraryNameSk);
		return library;
	}
	
	//나의정보조회
	@GetMapping("/myOffice")
	public String getMyOffice(Model model, HttpSession session) {
		logger.info("==== 직원 나의정보 조회 ====");
		String SID = (String) session.getAttribute("SID");
		logger.info(SID + " <-- SID");
		
		List<Officer> list2 = officerService.getMyOffice(SID);
		logger.info("==== 나의 정보 getMyOffice() ====");
		logger.info("list2 --> " + list2);
		model.addAttribute("getMyOffice", list2.get(0));
		
		
		  List<License> license = officerService.getOfficerLicense(SID);
		  logger.info("==== 자격증조회 getOfficerLicense() ====");
		  logger.info("license --> " + license); 
		  model.addAttribute("license", license);
		 
		return "office/myOffice";		
	}
	
	//직원리스트검색
	@GetMapping("/getSerchOfficer")
	public String getSerchOfficer(Model model, 
								@RequestParam(name = "sk") String sk,
								@RequestParam(name = "sv") String sv) {
		  logger.info("==== 직원리스트검색 getOfficerLicense() ====");
		  logger.info("sk = " + sk + " sv = " + sv);
		  List<Officer> officerList = officerService.getSerchOfficer(sk, sv);
		  logger.info("officerList --> "+officerList);
		  model.addAttribute("officerList", officerList);

		return "office/officerList";
	}
	
	//직원리스트조회
	@GetMapping("/officerList")
	public String getOfficerList(Model model) {
		logger.info("==== 직원리스트 조회 ====");
		List<Officer> list = officerService.getOfficerList();
		logger.info("list --> "+ list);
		model.addAttribute("officerList", list);
		return "office/officerList";
	}
	
	//직원등록처리
	@PostMapping("/addOfficer")
	public String addOfficer(Officer officer) {
		logger.info("==== 직원등록처리 ====");
		logger.info("officer -> " + officer);
		officerService.addOfficer(officer);
		return "redirect:/addOfficer";
	}
	
	//직원등록화면
	@GetMapping("/addOfficer")
	public String addOfficer(Model model) {
		logger.info("==== 직원등록화면 ====");
		Officer officer = officerService.getOfficerId();
		logger.info("officer OfficerController.java --> " + officer);
		model.addAttribute("officerId", officer);
		return "office/addOfficer";
	}
}
