package team1.project.vo;

public class Region {
	private String regionCode;
	private String regionMajor;
	private String regionMinor;
	private String regionRegDate;
	private Officer officer;
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionMajor() {
		return regionMajor;
	}
	public void setRegionMajor(String regionMajor) {
		this.regionMajor = regionMajor;
	}
	public String getRegionMinor() {
		return regionMinor;
	}
	public void setRegionMinor(String regionMinor) {
		this.regionMinor = regionMinor;
	}
	public String getRegionRegDate() {
		return regionRegDate;
	}
	public void setRegionRegDate(String regionRegDate) {
		this.regionRegDate = regionRegDate;
	}
	public Officer getOfficer() {
		return officer;
	}
	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	@Override
	public String toString() {
		return "Region [regionCode=" + regionCode + ", regionMajor=" + regionMajor + ", regionMinor=" + regionMinor
				+ ", regionRegDate=" + regionRegDate + ", officer=" + officer + "]";
	}
	
	
}
