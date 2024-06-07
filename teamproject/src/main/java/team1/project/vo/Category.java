package team1.project.vo;

import java.util.Date;

public class Category {

	private String categoryCode;
	private String categoryNumber;
	private String categoryName;
	private Date categoryRegDate;
	private String officer;
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(String categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getCategoryRegDate() {
		return categoryRegDate;
	}
	public void setCategoryRegDate(Date categoryRegDate) {
		this.categoryRegDate = categoryRegDate;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	@Override
	public String toString() {
		return "Category [categoryCode=" + categoryCode + ", categoryNumber=" + categoryNumber + ", categoryName="
				+ categoryName + ", categoryRegDate=" + categoryRegDate + ", officer=" + officer + "]";
	}
	
	
}
