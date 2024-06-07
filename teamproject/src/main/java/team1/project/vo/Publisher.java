package team1.project.vo;

import java.util.Date;

public class Publisher {

	private String publisherCode;
	private String publisherName;
	private String publisherPage;
	private Date publisherRegDate;
	private String officer;
	public String getPublisherCode() {
		return publisherCode;
	}
	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherPage() {
		return publisherPage;
	}
	public void setPublisherPage(String publisherPage) {
		this.publisherPage = publisherPage;
	}
	public Date getPublisherRegDate() {
		return publisherRegDate;
	}
	public void setPublisherRegDate(Date publisherRegDate) {
		this.publisherRegDate = publisherRegDate;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	@Override
	public String toString() {
		return "Publisher [publisherCode=" + publisherCode + ", publisherName=" + publisherName + ", publisherPage="
				+ publisherPage + ", officer=" + officer + "]";
	}
	
	
}
