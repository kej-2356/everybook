package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Login;
import team1.project.vo.Member;
import team1.project.vo.Officer;

@Mapper
public interface LoginMapper {
	
	//회원로그인내역리스트
	public List<Login> allLoginMember();
	
	//직원로그아웃업데이트
	public int updateLoginOfficer(Login loginCode);
	
	//회원로그아웃업데이트
	public int updateLoginMember(Login loginCode);
	
	//직원로그인내역등록
	public int addLoginOfficer(Login officerId);
	
	//회원로그인내역등록
	public int addLoginMember(Login memberId);
	
	//직원검색
	public Officer getOfficerSelect(String officerId);
	
	//회원검색
	public Member getMemberSelect(String memberId);
}
