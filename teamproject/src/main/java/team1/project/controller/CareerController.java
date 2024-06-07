package team1.project.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team1.project.service.CareerService;
import team1.project.vo.Career;

@Controller
public class CareerController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	@Autowired private CareerService careerService;
	
	//경력 등록처리
	@PostMapping("/addOfficerCareer")
	public String addOfficerCareer(Career career) {
		logger.info("==== 경력 등록처리 ===="); 
		logger.info("career --> " + career.toString());
		int i = careerService.addOfficerCareer(career); 
		logger.info("실행결과 : " + i); 
		return "admin/indexAdmin";
	}
	
	//경력 등록화면
	@GetMapping("/addOfficerCareer")
	public String addOfficerCareer(Model model, HttpSession session) {
		logger.info("==== 경력 등록화면 ====");
		String SID = (String) session.getAttribute("SID");
		logger.info("SID --> " + SID);
		model.addAttribute("SID", SID);			
		return "career/addOfficerCareer";
	}
}
