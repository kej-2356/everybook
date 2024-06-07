package team1.project.vo;

public class OfficerLicense {
	private String officerLicenseCode;
	private String officerId;
	private String licenseCode;
	private String licenseName;
	private String officerLicenseDate;
	private String officerLicenseRegDate;
	
	public String getOfficerLicenseCode() {
		return officerLicenseCode;
	}
	public void setOfficerLicenseCode(String officerLicenseCode) {
		this.officerLicenseCode = officerLicenseCode;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
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
	public String getOfficerLicenseDate() {
		return officerLicenseDate;
	}
	public void setOfficerLicenseDate(String officerLicenseDate) {
		this.officerLicenseDate = officerLicenseDate;
	}
	public String getOfficerLicenseRegDate() {
		return officerLicenseRegDate;
	}
	public void setOfficerLicenseRegDate(String officerLicenseRegDate) {
		this.officerLicenseRegDate = officerLicenseRegDate;
	}
	@Override
	public String toString() {
		return "OfficerLicense [officerLicenseCode=" + officerLicenseCode + ", officerId=" + officerId
				+ ", licenseCode=" + licenseCode + ", licenseName=" + licenseName + ", officerLicenseDate="
				+ officerLicenseDate + ", officerLicenseRegDate=" + officerLicenseRegDate + "]";
	}
	
	
}
