package team1.project.vo;

import java.util.Date;

public class Overdue {

	private String overdueCode;
	private String library;
	private Rent rent;
	private String member;
	private Book book;
	private String overdueStartDate;
	private String overdueDate;
	private Date overdueRegDate;
	private String officer;
	public String getOverdueCode() {
		return overdueCode;
	}
	public void setOverdueCode(String overdueCode) {
		this.overdueCode = overdueCode;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public Rent getRent() {
		return rent;
	}
	public void setRent(Rent rent) {
		this.rent = rent;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getOverdueStartDate() {
		return overdueStartDate;
	}
	public void setOverdueStartDate(String overdueStartDate) {
		this.overdueStartDate = overdueStartDate;
	}
	public String getOverdueDate() {
		return overdueDate;
	}
	public void setOverdueDate(String overdueDate) {
		this.overdueDate = overdueDate;
	}
	public Date getOverdueRegDate() {
		return overdueRegDate;
	}
	public void setOverdueRegDate(Date overdueRegDate) {
		this.overdueRegDate = overdueRegDate;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	@Override
	public String toString() {
		return "Overdue [overdueCode=" + overdueCode + ", library=" + library + ", rent=" + rent + ", member=" + member
				+ ", book=" + book + ", overdueStartDate=" + overdueStartDate + ", overdueDate=" + overdueDate
				+ ", overdueRegDate=" + overdueRegDate + ", officer=" + officer + "]";
	}
	
	
	
}
