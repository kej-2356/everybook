package team1.project.vo;

import java.util.Date;

public class Login {
	private String loginCode;
	private String memberId;
	private String officerId;
	private Date loginDate;
	private Date logoutDate;
	
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public Date getLogoutDate() {
		return logoutDate;
	}
	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}
	@Override
	public String toString() {
		return "Login [loginCode=" + loginCode + ", memberId=" + memberId + ", officerId=" + officerId + ", loginDate="
				+ loginDate + ", logoutDate=" + logoutDate + "]";
	}
	
	
	
	
}
