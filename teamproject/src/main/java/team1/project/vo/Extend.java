package team1.project.vo;

import java.util.Date;

public class Extend {

	private String extendCode;
	private String library;
	private String member;
	private String book;
	private String rent;
	private String extendDate;
	private String extendReturnDate;
	private Date extendRegDate;
	private String officer;
	public String getExtendCode() {
		return extendCode;
	}
	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getExtendDate() {
		return extendDate;
	}
	public void setExtendDate(String extendDate) {
		this.extendDate = extendDate;
	}
	public String getExtendReturnDate() {
		return extendReturnDate;
	}
	public void setExtendReturnDate(String extendReturnDate) {
		this.extendReturnDate = extendReturnDate;
	}
	public Date getExtendRegDate() {
		return extendRegDate;
	}
	public void setExtendRegDate(Date extendRegDate) {
		this.extendRegDate = extendRegDate;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	@Override
	public String toString() {
		return "Extend [extendCode=" + extendCode + ", library=" + library + ", member=" + member + ", book=" + book
				+ ", rent=" + rent + ", extendDate=" + extendDate + ", extendReturnDate=" + extendReturnDate
				+ ", extendRegDate=" + extendRegDate + ", officer=" + officer + "]";
	}
	
	
}
