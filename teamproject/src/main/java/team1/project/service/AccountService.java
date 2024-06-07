package team1.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.controller.ReserveController;
import team1.project.mapper.AccountMapper;
import team1.project.vo.Account;

@Service
@Transactional
public class AccountService {
	
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	@Autowired private AccountMapper accountMapper;
	
	public int addAccount(Account account) {
		return accountMapper.addAccount(account);
	}
	
	public Account selectAccount(String accountCode) {
		logger.info("계정과목 코드 : {}", accountCode);
		return accountMapper.selectAccount(accountCode);
	}
	
	public List<Account> getAccountList(){
		return accountMapper.getAccountList();
	}
}
