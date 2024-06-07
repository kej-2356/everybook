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
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.AccountService;
import team1.project.vo.Account;

@Controller
public class BudgetController {
	
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	@Autowired private AccountService accountService;
	
	/* 예산 */
	
	@GetMapping("/modifyBudget")
	public String modifyBudget() {
		return "budget/modifyBudget";
	}

	@GetMapping("/addBudget")
	public String addBudget() {
		return "budget/addBudget";
	}
	
	@GetMapping("/listBudget")
	public String listBudget() {
		return "budget/listBudget";
	}
	
	/* 계정과목 */ 
	
	@PostMapping("/deleteAccount")
	public String deleteAccount(Account account) {
		logger.info("account : {}", account);
		return "redirect:/listAccount";
	}
	
	/**
	 * 하나의 계정과목 코드로 계정과목 조회하기 
	 * @param accountCode
	 * @return
	 */
	@GetMapping("/selectAccount")
	@ResponseBody
	public Account selectAccount(String accountCode) {
		Account account = accountService.selectAccount(accountCode);
		return account;
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/modifyAccount")
	public String modifyAccount() {
		return "budget/modifyAccount";
	}
	
	/**
	 * 계정과목 리스트 호출
	 * @param model
	 * @return budget/listAccount
	 */
	@GetMapping("/listAccount")
	public String listAccount(Model model) {
		List<Account> accountList = accountService.getAccountList();
		model.addAttribute("accountList", accountList);
		return "budget/listAccount";
	}
	
	@PostMapping("/addAccount")
	public String addAccount(Account account, HttpSession session) {
		String officerId = (String) session.getAttribute("SID");
		account.setOfficerId(officerId);
		accountService.addAccount(account);
		return  "redirect:/listAccount"; 
	}
 
}
