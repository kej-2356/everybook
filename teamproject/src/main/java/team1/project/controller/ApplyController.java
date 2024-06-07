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

import team1.project.service.ApplyService;
import team1.project.vo.Apply;

@Controller
public class ApplyController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	@Autowired private ApplyService applyService;
	
	//신청도서 등록!
	@PostMapping("/addBookApply")
	public String addBookApply(Apply apply) {
		logger.info("apply --> " + apply);
		 applyService.addBookApply(apply); 
		
		return "redirect:/myApply";
	}
	
	//나의 신청도서 신청취소
	@PostMapping("/deleteBookApply")
	public String deleteBookApply(Apply apply) {
		logger.info("deleteBookApply() apply --> " + apply);
		int i = applyService.deleteBookApply(apply);
		logger.info("실행결과-->" + i);
		return "redirect:/myApply"; 
	}
	
	//나의신청도서 신청취소 - (선택한 로우의 신청코드 받아오기)
		@GetMapping(value="/selectApply")
		@ResponseBody
		public Apply getApplyCode(@RequestParam(name = "applyCode") String applyCode) {
			logger.info("getRentCode() applyCode --> "+ applyCode);
			Apply apply = applyService.getApplyCode(applyCode);
			logger.info(applyCode);
			return apply;
		}
	
	//나의 신청도서 리스트
	@GetMapping("/myApply")
	public String myApplyList(Model model, HttpSession session) {
		
		String SID = (String) session.getAttribute("SID");
		logger.info("SID --> " + SID);
				
		List<Apply> list = applyService.myApplyList(SID);				
		logger.info("list --> " + list);
		model.addAttribute("myApplyList", list);
		return "apply/myApply";
	}
	
	//희망도서 신청
	@GetMapping("/addBookApply")
	public String addBookApply() {
		return "apply/addBookApply";
	}
	
	//신청도서관리 - 신청도서리스트 - 수정처리
	@PostMapping("/ModifyOfficeApply")
	public String ModifyOfficeApply(Apply apply) {
		logger.info("==== 신청도서 수정 처리 ====");
		logger.info("ModifyOfficeApply() apply -->" + apply.toString());
		int i = applyService.ModifyOfficeBookApply(apply);
		logger.info("실행결과 : " + i);
		
		return "redirect:/officeBookApply";
	}
	
	//신청도서관리 - 신청도서리스트 - 수정화면
	@GetMapping("/ModifyOfficeApply")
	public String ModifyOfficeApply(Model model,
								Apply apply,
								@RequestParam(name = "applyCodeModify", required = false) String applyCode ) {
		logger.info("applyCode --> "+ applyCode);
		apply = applyService.ModifyOfficeApply(applyCode);
		logger.info("apply --> " + apply);
		model.addAttribute("selectApply", apply);
		return "apply/officeBookApplyModify";
	}
	
	//신청도서관리 - 신청도서리스트 - 삭제
	@GetMapping("/deleteOfficeBookApply")
	public String deleteOfficeApply(@RequestParam(name = "applyCode", required = false) String applyCode) {
		logger.info("applyCode --> "+ applyCode);
		applyService.deleteOfficeApply(applyCode);
		
		return "redirect:/officeBookApply";
	}
	
	//신청도서관리 - 신청도서리스트 - 검색
	@GetMapping("/officeApplySearch")
	public String officeApplySearch(Model model,
							@RequestParam(name = "sk") String sk,
							@RequestParam(name = "sv") String sv) {
		logger.info(" sk --> " + sk);
		logger.info(" sv --> " + sv);
		List<Apply> officeApplyList = applyService.officeApplySearch(sk, sv);
		model.addAttribute("officeApplyList", officeApplyList);
		return "apply/officeBookApply";
	}
	
	//신청도서관리 - 신청도서리스트
	@GetMapping("/officeBookApply")
	public String officeApplyList(Model model) {
		List<Apply> officeApplyList = applyService.officeApplyList();
		logger.info("officeApplyList --> " + officeApplyList);
		model.addAttribute("officeApplyList", officeApplyList);
		return "apply/officeBookApply";
	}
}
