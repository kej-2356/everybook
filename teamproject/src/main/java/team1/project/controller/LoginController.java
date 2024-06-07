package team1.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import team1.project.service.LoginService;
import team1.project.vo.Login;
import team1.project.vo.Member;
import team1.project.vo.Officer;

@Controller
public class LoginController {
	
	@Autowired private LoginService loginService;
	
	//회원로그인내역(직원)
	@GetMapping("/officeMemberLogin")
	public String officeMemberLogin(Model model) {
		List<Login> loginList = new ArrayList<Login>();
		loginList = loginService.allLoginMember();
		System.out.println("회원로그인내역 >>>"+loginList);
		
		model.addAttribute("memberlogin", loginList);
		return "member/officeMemberLogin";
	}
	
	//로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpSession session,Login login) {
		String loginCode = (String) session.getAttribute("SCODE");
		login.setLoginCode(loginCode);
		if("member_login".equals(loginCode.substring(0, 12))) {
			loginService.updateLoginMember(login);
		}else if("officer_login".equals(loginCode.substring(0, 13))) {
			loginService.updateLoginOfficer(login);
		}
		session.invalidate();
		
		return "redirect:/";
	}
	
	//직원 로그인처리
	//@PostMapping("/loginOfficer")
	@RequestMapping("/loginOfficer")
	public String loginOfficer(Officer officer
								,HttpSession session) {
		
		System.out.println(officer.getOfficerId());
		System.out.println(officer.getOfficerPw());
				
		if(officer.getOfficerId() != null && !"".equals(officer.getOfficerId())
				&& officer.getOfficerPw() != null && !"".equals(officer.getOfficerPw())) {
			
			Officer o = loginService.getOfficerSelect(officer.getOfficerId());
			System.out.println(o);
			
			if(o !=null
					&& officer.getOfficerPw().equals(o.getOfficerPw())) {
				
				session.setAttribute("SID", o.getOfficerId());
				session.setAttribute("SLEVEL", o.getLevel());
				session.setAttribute("SLIBRARY", o.getLibrary());
				System.out.println("SID >>"+session.getAttribute("SID"));
				System.out.println("SLEVEL >>"+session.getAttribute("SLEVEL"));
				System.out.println("SLIBRARY >>"+session.getAttribute("SLIBRARY"));
				System.out.println("로그인완료");
				
				Login login = new Login();
				login.setOfficerId(o.getOfficerId());
				loginService.addLoginOfficer(login);
				session.setAttribute("SCODE", login.getLoginCode());
				System.out.println("SCODE>>"+session.getAttribute("SCODE"));
				
				return "redirect:/office";
			}
		}
		return "redirect:/";
	}
	
	
	//회원로그인 처리
	//@PostMapping("/loginMember")
	@RequestMapping("/loginMember")
	public String loginMember(Member member
								,HttpSession session) {
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPw());
		
		if(member.getMemberId() != null && !"".equals(member.getMemberId())
				&& member.getMemberPw() != null && !"".equals(member.getMemberPw())) {
			
			Member m = loginService.getMemberSelect(member.getMemberId());
			
			if(m !=null
					&& member.getMemberPw().equals(m.getMemberPw())) {
				
				session.setAttribute("SID", m.getMemberId());
				session.setAttribute("SLEVEL", m.getLevelCode());
				session.setAttribute("SLIBRARY", m.getLibraryCode());
				System.out.println("SID >>"+session.getAttribute("SID"));
				System.out.println("SLEVEL >>"+session.getAttribute("SLEVEL"));
				System.out.println("SLIBRARY >>"+session.getAttribute("SLIBRARY"));
				System.out.println("로그인완료");
				
				Login login = new Login();
				login.setMemberId(m.getMemberId());
				System.out.println("log.getMemberId() >>>>"+login.getMemberId());
				loginService.addLoginMember(login);
				System.out.println("로그인코드>>"+login.getLoginCode());
				session.setAttribute("SCODE", login.getLoginCode());
				System.out.println("SCODE>>"+session.getAttribute("SCODE"));
			
				return "redirect:/index";
			}
		}
		return "redirect:/";
	}
}
