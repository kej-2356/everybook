package team1.project.vo;

import java.sql.Date;

public class Review {
	private String reviewCode;
	private String bookCode;
	private String memberId;
	private String reviewContent;
	private Date reviewRegDate;
	
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewRegDate() {
		return reviewRegDate;
	}
	public void setReviewRegDate(Date reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}
	@Override
	public String toString() {
		return "Review [reviewCode=" + reviewCode + ", bookCode=" + bookCode + ", memberId=" + memberId
				+ ", reviewContent=" + reviewContent + ", reviewRegDate=" + reviewRegDate + "]";
	}
	
	
}
