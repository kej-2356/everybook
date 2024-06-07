package team1.project.vo;

public class PointHistory {
	private String phCode; 
	private String libraryCode; 
	private String memberId; 
	private String psCode; 
	private String psName;
	private int psScore;
	private String phRegDate; 
	private String phCondition; 
	private String officerId;
	public String getPhCode() {
		return phCode;
	}
	public void setPhCode(String phCode) {
		this.phCode = phCode;
	}
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPsCode() {
		return psCode;
	}
	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	public int getPsScore() {
		return psScore;
	}
	public void setPsScore(int psScore) {
		this.psScore = psScore;
	}
	public String getPhRegDate() {
		return phRegDate;
	}
	public void setPhRegDate(String phRegDate) {
		this.phRegDate = phRegDate;
	}
	public String getPhCondition() {
		return phCondition;
	}
	public void setPhCondition(String phCondition) {
		this.phCondition = phCondition;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	@Override
	public String toString() {
		return "PointHistory [phCode=" + phCode + ", libraryCode=" + libraryCode + ", memberId=" + memberId
				+ ", psCode=" + psCode + ", psName=" + psName + ", psScore=" + psScore + ", phRegDate=" + phRegDate
				+ ", phCondition=" + phCondition + ", officerId=" + officerId + "]";
	}
}
