package team1.project.vo;

public class Rent {
	private String rentCode;
	private String libraryCode;
	private String libraryName;
	private String memberId;
	private String bookCode;
	private String rentDate;
	private String rentReturnDate;
	private String rentRegDate;
	private String publisher;
	private String writer;
	private String category;	
	private String officerId;
	private Book book;
	public String getRentCode() {
		return rentCode;
	}
	public void setRentCode(String rentCode) {
		this.rentCode = rentCode;
	}
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getRentReturnDate() {
		return rentReturnDate;
	}
	public void setRentReturnDate(String rentReturnDate) {
		this.rentReturnDate = rentReturnDate;
	}
	public String getRentRegDate() {
		return rentRegDate;
	}
	public void setRentRegDate(String rentRegDate) {
		this.rentRegDate = rentRegDate;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Rent [rentCode=" + rentCode + ", libraryCode=" + libraryCode + ", libraryName=" + libraryName
				+ ", memberId=" + memberId + ", bookCode=" + bookCode + ", rentDate=" + rentDate + ", rentReturnDate="
				+ rentReturnDate + ", rentRegDate=" + rentRegDate + ", publisher=" + publisher + ", writer=" + writer
				+ ", category=" + category + ", officerId=" + officerId + ", book=" + book + "]";
	}
	
	
}

