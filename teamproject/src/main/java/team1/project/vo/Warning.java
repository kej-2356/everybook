package team1.project.vo;

import java.util.Date;

public class Warning {
	private String warningCode;
	private String bookCode;
	private String reviewCode;
	private String warningSuspect;
	private String warningBlower;
	private String warningContent;
	private Date warningRegDate;
	public String getWarningCode() {
		return warningCode;
	}
	public void setWarningCode(String warningCode) {
		this.warningCode = warningCode;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getWarningSuspect() {
		return warningSuspect;
	}
	public void setWarningSuspect(String warningSuspect) {
		this.warningSuspect = warningSuspect;
	}
	public String getWarningBlower() {
		return warningBlower;
	}
	public void setWarningBlower(String warningBlower) {
		this.warningBlower = warningBlower;
	}
	public String getWarningContent() {
		return warningContent;
	}
	public void setWarningContent(String warningContent) {
		this.warningContent = warningContent;
	}
	public Date getWarningRegDate() {
		return warningRegDate;
	}
	public void setWarningRegDate(Date warningRegDate) {
		this.warningRegDate = warningRegDate;
	}
	@Override
	public String toString() {
		return "Warning [warningCode=" + warningCode + ", bookCode=" + bookCode + ", reviewCode=" + reviewCode
				+ ", warningSuspect=" + warningSuspect + ", warningBlower=" + warningBlower + ", warningContent="
				+ warningContent + ", warningRegDate=" + warningRegDate + "]";
	}
	
	
	
}
