package team1.project.vo;

public class Book {
	private String bookCode;
	private String libraryName;
	private String libraryCode;
	private String bookLibraryCode;
	private String bookName;
	private String categoryName;
	private String categoryNumber;
	private String categoryCode;
	private String writerName;
	private String writerCode;
	private String publisherName;
	private String publisherCode;
	private String bookPublishDate;
	private String bookPrice;
	private String bookIsbn;
	private String bookSituation;
	private String bookRegDate;
	private String group;
	private String budget;
	private String officerId;
	private int reserveCount;
	private String bookImageURL;
	private String bookDescription;
	private String seriesNo;
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookLibraryCode() {
		return bookLibraryCode;
	}
	public void setBookLibraryCode(String bookLibraryCode) {
		this.bookLibraryCode = bookLibraryCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(String categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getWriterCode() {
		return writerCode;
	}
	public void setWriterCode(String writerCode) {
		this.writerCode = writerCode;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherCode() {
		return publisherCode;
	}
	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}
	public String getBookPublishDate() {
		return bookPublishDate;
	}
	public void setBookPublishDate(String bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public String getBookSituation() {
		return bookSituation;
	}
	public void setBookSituation(String bookSituation) {
		this.bookSituation = bookSituation;
	}
	public String getBookRegDate() {
		return bookRegDate;
	}
	public void setBookRegDate(String bookRegDate) {
		this.bookRegDate = bookRegDate;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	public int getReserveCount() {
		return reserveCount;
	}
	public void setReserveCount(int reserveCount) {
		this.reserveCount = reserveCount;
	}
	public String getBookImageURL() {
		return bookImageURL;
	}
	public void setBookImageURL(String bookImageURL) {
		this.bookImageURL = bookImageURL;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getSeriesNo() {
		return seriesNo;
	}
	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", libraryName=" + libraryName + ", libraryCode=" + libraryCode
				+ ", bookLibraryCode=" + bookLibraryCode + ", bookName=" + bookName + ", categoryName=" + categoryName
				+ ", categoryNumber=" + categoryNumber + ", categoryCode=" + categoryCode + ", writerName=" + writerName
				+ ", writerCode=" + writerCode + ", publisherName=" + publisherName + ", publisherCode=" + publisherCode
				+ ", bookPublishDate=" + bookPublishDate + ", bookPrice=" + bookPrice + ", bookIsbn=" + bookIsbn
				+ ", bookSituation=" + bookSituation + ", bookRegDate=" + bookRegDate + ", group=" + group + ", budget="
				+ budget + ", officerId=" + officerId + ", reserveCount=" + reserveCount + ", bookImageURL="
				+ bookImageURL + ", bookDescription=" + bookDescription + ", seriesNo=" + seriesNo + "]";
	}
			
	
}
