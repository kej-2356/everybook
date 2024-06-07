package team1.project.vo;

public class RtcanReserve {
	private String rtcanCode;
	private String libraryCode;
	private String memberId;
	private Book book;
	private String rtcanDate;
	private String rtcanSituation;
	private String rtcanRegDate;
	private String officerId;
	private String officerPw;
	private String noReason;
	public String getRtcanCode() {
		return rtcanCode;
	}
	public void setRtcanCode(String rtcanCode) {
		this.rtcanCode = rtcanCode;
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
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getRtcanDate() {
		return rtcanDate;
	}
	public void setRtcanDate(String rtcanDate) {
		this.rtcanDate = rtcanDate;
	}
	public String getRtcanRegDate() {
		return rtcanRegDate;
	}
	public void setRtcanRegDate(String rtcanRegDate) {
		this.rtcanRegDate = rtcanRegDate;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	public String getRtcanSituation() {
		return rtcanSituation;
	}
	public void setRtcanSituation(String rtcanSituation) {
		this.rtcanSituation = rtcanSituation;
	}
	public String getNoReason() {
		return noReason;
	}
	public void setNoReason(String noReason) {
		this.noReason = noReason;
	}
	public String getOfficerPw() {
		return officerPw;
	}
	public void setOfficerPw(String officerPw) {
		this.officerPw = officerPw;
	}
	@Override
	public String toString() {
		return "RtcanReserve [rtcanCode=" + rtcanCode + ", libraryCode=" + libraryCode + ", memberId=" + memberId
				+ ", book=" + book + ", rtcanDate=" + rtcanDate + ", rtcanSituation=" + rtcanSituation
				+ ", rtcanRegDate=" + rtcanRegDate + ", officerId=" + officerId + ", officerPw=" + officerPw
				+ ", noReason=" + noReason + "]";
	}
	
	

}
