package team1.project.vo;

import java.util.Date;

public class Writer {

	private String writerCode;
	private String writerName;
	private Date writerRegDate;
	private String officer;
	public String getWriterCode() {
		return writerCode;
	}
	public void setWriterCode(String writerCode) {
		this.writerCode = writerCode;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public Date getWriterRegDate() {
		return writerRegDate;
	}
	public void setWriterRegDate(Date writerRegDate) {
		this.writerRegDate = writerRegDate;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	@Override
	public String toString() {
		return "Writer [writerCode=" + writerCode + ", writerName=" + writerName + ", writerRegDate=" + writerRegDate
				+ ", officer=" + officer + "]";
	}
	
	
}
