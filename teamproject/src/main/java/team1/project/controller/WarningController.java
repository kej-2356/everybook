package team1.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.WarningService;
import team1.project.vo.Warning;

@Controller
public class WarningController {
	
	@Autowired WarningService warningService;
	
	//도서평신고 삭제
	@GetMapping(value="/deleteWarning")
	@ResponseBody
	public int deleteWarning(@RequestParam("warningCode") String warningCode) {
		
		return warningService.deleteWarning(warningCode);
	}
	
	//같은 도서관 코드를 가진 회원의 도서평 신고 내역(직원)
	@GetMapping("/officeWarningList")
	public String officeWarningList(HttpSession session,Model model) {
		String libraryCode = (String)session.getAttribute("SLIBRARY");
		
		model.addAttribute("warningList", warningService.officeWarningList(libraryCode));
		return "review/officeWarningList";
	}
	
	//도서평 신고 등록처리
	@PostMapping("/addWarning")
	public String addWarning(Warning warning) {

		warningService.addWarning(warning);
		return "redirect:/bookList";
	}
	
}
