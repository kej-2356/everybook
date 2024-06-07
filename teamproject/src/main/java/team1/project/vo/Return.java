package team1.project.vo;

import java.util.Date;

public class Return {

	private String returnCode;
	private String library;
	private String member;
	private Book book;
	private String rent;
	private String returnDate;
	private Date returnRegDate;
	private String officer;
	private String writer;
	private String category;
	private String publisher;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
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
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public Date getReturnRegDate() {
		return returnRegDate;
	}
	public void setReturnRegDate(Date returnRegDate) {
		this.returnRegDate = returnRegDate;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	@Override
	public String toString() {
		return "Return [returnCode=" + returnCode + ", library=" + library + ", member=" + member + ", book=" + book
				+ ", rent=" + rent + ", returnDate=" + returnDate + ", returnRegDate=" + returnRegDate + ", officer="
				+ officer + ", writer=" + writer + ", category=" + category + ", publisher=" + publisher + "]";
	}
	
	
}
