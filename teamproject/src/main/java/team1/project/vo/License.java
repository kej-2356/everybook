package team1.project.vo;

public class License {
	private String licenseCode;
	private String licenseName;
	private String licenseIssue;
	private String licenseOperationDate;
	private String licenseRegDate;
	private Officer officer;
	
	public String getLicenseCode() {
		return licenseCode;
	}
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}
	public String getLicenseName() {
		return licenseName;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	public String getLicenseIssue() {
		return licenseIssue;
	}
	public void setLicenseIssue(String licenseIssue) {
		this.licenseIssue = licenseIssue;
	}
	public String getLicenseOperationDate() {
		return licenseOperationDate;
	}
	public void setLicenseOperationDate(String licenseOperationDate) {
		this.licenseOperationDate = licenseOperationDate;
	}
	public String getLicenseRegDate() {
		return licenseRegDate;
	}
	public void setLicenseRegDate(String licenseRegDate) {
		this.licenseRegDate = licenseRegDate;
	}
	public Officer getOfficer() {
		return officer;
	}
	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	@Override
	public String toString() {
		return "License [licenseCode=" + licenseCode + ", licenseName=" + licenseName + ", licenseIssue=" + licenseIssue
				+ ", licenseOperationDate=" + licenseOperationDate + ", licenseRegDate=" + licenseRegDate + ", officer="
				+ officer + "]";
	}
	
	
}
