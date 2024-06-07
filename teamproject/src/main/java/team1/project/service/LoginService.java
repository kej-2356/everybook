package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team1.project.mapper.LoginMapper;
import team1.project.vo.Login;
import team1.project.vo.Member;
import team1.project.vo.Officer;

@Service
public class LoginService {
	
	@Autowired private LoginMapper loginMapper;
	
	public List<Login> allLoginMember() {
		return loginMapper.allLoginMember();
	}
	
	public int updateLoginOfficer(Login loginCode) {
		System.out.println("LoginService.updateLoginOfficer >>>>"+loginCode.toString());
		return loginMapper.updateLoginOfficer(loginCode);
	}
	
	public int updateLoginMember(Login loginCode) {
		System.out.println("LoginService.updateLoginMember >>>>"+loginCode.toString());
		return loginMapper.updateLoginMember(loginCode);
	}
	
	public int addLoginOfficer(Login officerId) {
		System.out.println("LoginService.addLoginOfficer >>>>>"+officerId.toString());
		return loginMapper.addLoginOfficer(officerId);
	}
	
	public int addLoginMember(Login memberId) {
		System.out.println("LoginService>>>>>"+ memberId.toString());
		return loginMapper.addLoginMember(memberId);
	}
	
	public Officer getOfficerSelect(String officerId) {
		return loginMapper.getOfficerSelect(officerId);
	}
	
	public Member getMemberSelect(String memberId) {
		return  loginMapper. getMemberSelect(memberId);
	};
}
