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

import team1.project.service.PointService;
import team1.project.vo.Officer;
import team1.project.vo.PointHistory;
import team1.project.vo.PointStandard;

@Controller
public class PointController {
	
	private final static Logger logger = LoggerFactory.getLogger(PointController.class);
	@Autowired private PointService pointService;
	
	@GetMapping("/searchPsInfo")
	public String searchPsInfo(Model model, @RequestParam("sk") String sk, @RequestParam("sv") String sv) {
		logger.info("==== 상벌점 기준 검색 컨트롤러 ====");
		logger.info(sk + " <- sk;  "+sv +" <- sv;");
		List<PointStandard> psList = pointService.searchPs(sk, sv);
		model.addAttribute("psList", psList);
		return "information/pointStandardList";
	}
	
	@GetMapping("/searchPs")
	public String searchPs(Model model, @RequestParam("sk") String sk, @RequestParam("sv") String sv) {
		logger.info("==== 상벌점 기준 검색 컨트롤러 ====");
		logger.info(sk + " <- sk;  "+sv +" <- sv;");
		List<PointStandard> psList = pointService.searchPs(sk, sv);
		model.addAttribute("psList", psList);
		return "point/officePointStandard";
	}
	
	@PostMapping("/deletePs")
	public String deletePs(PointStandard point, Officer officer) {
		logger.info("==== 상벌점 기준 삭제 컨트롤러 ====");
		point.setOfficer(officer);
		logger.info(point.toString() +" deletePs PointController.java");
		int i = pointService.deletePs(point);
		logger.info("실행결과 : {}",i);
		return "redirect:/officePointStandard";
	}
	
	@PostMapping("/modifyPs")
	public String modifyPs(PointStandard point, Officer officer) {
		logger.info("==== 상벌점 기준 수정 컨트롤러 ====");
		point.setOfficer(officer);
		logger.info(point.toString() +" modifyPs PointController.java");
		int i = pointService.modifyPs(point);
		logger.info("실행결과 : " + i);
		return "redirect:/officePointStandard";
	}
	
	@GetMapping("/getSelectPs")
	@ResponseBody
	public PointStandard getSelectPs(@RequestParam("psCode") String psCode) {
		logger.info(psCode + " <- psCode pointController.java");
		PointStandard point = pointService.getSelectPs(psCode);
		return point;
	}
	
	@PostMapping("/addPs")
	public String addPs(PointStandard point, Officer officer) {
		logger.info("===== 상벌점 기준 등록 =====");
		point.setOfficer(officer);
		logger.info(point.toString() +" <- point.java pointController.java");
		int i = pointService.addPs(point);
		logger.info("실행 결과 : " + i);
		return "redirect:/officePointStandard";
	}
	
	@GetMapping("/pointStandard")
	public String getPsList(Model model) {
		logger.info("======== getPsList PointController.java ========");
		List<PointStandard> psList = pointService.getPsList();
		model.addAttribute("psList", psList);
		return "information/pointStandardList";
	}
	
	@GetMapping("/officePointHistoryList")
	public String getPhList(Model model, HttpSession session) {
		logger.info("상벌점 내역 리스트");
		String libraryCode = (String) session.getAttribute("SLIBRARY");
		List<PointHistory> phList = pointService.getPhList(libraryCode);
		model.addAttribute("phList", phList);
		return "point/officePointHistoryList";
	}
	
	@GetMapping("/officePointHistoryAdd")
	public String getOfficePhAdd(Model model, HttpSession session) {
		logger.info("대기중인 상벌점 내역");
		String libraryCode = (String) session.getAttribute("SLIBRARY");
		List<PointHistory> psStandbyPhList = pointService.getStandbyPsList(libraryCode);
		model.addAttribute("psStandbyPhList", psStandbyPhList);
		return "point/officePointHistoryAdd";
	}
	
	@GetMapping("/officePointStandard")
	public String getOfficePsList(Model model) {
		logger.info("======== getOfficePsList PointController.java ========");
		List<PointStandard> psList = pointService.getPsList();
		model.addAttribute("psList", psList);
		
		return "point/officePointStandard";
	}
	
	@GetMapping("/myPoint")
	public String myPoint() {
		return "point/myPoint";
	}
}
