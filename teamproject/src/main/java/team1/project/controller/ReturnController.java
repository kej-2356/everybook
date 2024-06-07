package team1.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team1.project.service.ReturnService;
import team1.project.vo.Return;

@Controller
public class ReturnController {
	private final static Logger logger = LoggerFactory.getLogger(OfficerController.class);
	@Autowired private ReturnService returnService;
	
	//반납관리 - 반납도서리스트 검색
	@GetMapping("/officeReturnListSearch")
	public String officeReturnListSearch(Model model,
					@RequestParam(name = "sk") String sk,
					@RequestParam(name = "sv") String sv) {
		logger.info("sk : " + sk + " sv : " + sv);
		List<Return> officeReturnList = returnService.officeReturnListSearch(sk, sv);
		model.addAttribute("officeReturnList", officeReturnList);
		
		return "return/officeBookReturn";
	}
	
	//반납관리 - 반납도서리스트 조회
	@GetMapping("/officeBookReturn")
	public String officeReturnList(Model model) {
		List<Return> officeReturnList = returnService.officeReturnList();
		System.out.println(officeReturnList + " <-- officeReturnList");
		model.addAttribute("officeReturnList", officeReturnList);
		
		return "return/officeBookReturn";
	}
}
