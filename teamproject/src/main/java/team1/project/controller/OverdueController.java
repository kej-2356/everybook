package team1.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team1.project.service.OverdueService;
import team1.project.vo.Overdue;

@Controller
public class OverdueController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	@Autowired private OverdueService overdueService;
	
	//연체관리 - 연체리스트 - 수정처리
	@PostMapping("/officeOverdueModify")
	public String officeOverdueModify(@RequestParam(name = "overdueCode") String overdueCode
									,@RequestParam(name = "rentReturnDate") String rentReturnDate) {
		logger.info("overdueCode --> "+overdueCode);
		logger.info("rentReturnDate --> "+rentReturnDate);
		
		  int i = overdueService.officeOverdueModify(overdueCode, rentReturnDate);
		  logger.info("실행결과  : " + i);
		 
		return "redirect:/officeBookOverdue";
	}
	
	//연체관리 - 연체리스트 - 수정화면
	@GetMapping("/officeBookOverdueModify")
	public String officeBookOverdueModify(Model model
						, Overdue overdue
						, @RequestParam(name = "overdueCodeModify") String overdueCodeModify) {
		logger.info("overdueCodeModify --> " + overdueCodeModify);
		overdue = overdueService.getOverdueModify(overdueCodeModify);
		logger.info("officeBookOverdueModify() overdue -->" + overdue);
		model.addAttribute("selectOverdue", overdue);
		return "overdue/officeBookOverdueModify";
	}
	
	//연체관리 - 연체리스트 -삭제
	@GetMapping("/deleteOfficeOverdue")
	public String deleteOfficeOverdue(@RequestParam(name = "overdueCodeDelete") String overdueCodeDelete) {
		logger.info("overdueCode --> " + overdueCodeDelete);
		overdueService.deleteOfficeOverdue(overdueCodeDelete);
		
		return "redirect:/officeBookOverdue";
	}
	
	//연체관리 - 연체리스트
	@GetMapping("/officeBookOverdue")
	public String officeOverdueList(Model model) {
		List<Overdue> officeOverdueList = overdueService.officeOverdueList();
		logger.info("officeBookOverdue() officeOverdueList --> " + officeOverdueList);
		
		model.addAttribute("officeOverdueList", officeOverdueList);
		
		return "overdue/officeBookOverdue";
	}
}
