package team1.project.vo;

public class Career {

	private String careerCode;
	private String officer;
	private String careerName;
	private String careerPeriodStart;
	private String careerPeriodEnd;
	private String careerRegDate;
	public String getCareerCode() {
		return careerCode;
	}
	public void setCareerCode(String careerCode) {
		this.careerCode = careerCode;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	public String getCareerName() {
		return careerName;
	}
	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}
	public String getCareerPeriodStart() {
		return careerPeriodStart;
	}
	public void setCareerPeriodStart(String careerPeriodStart) {
		this.careerPeriodStart = careerPeriodStart;
	}
	public String getCareerPeriodEnd() {
		return careerPeriodEnd;
	}
	public void setCareerPeriodEnd(String careerPeriodEnd) {
		this.careerPeriodEnd = careerPeriodEnd;
	}
	public String getCareerRegDate() {
		return careerRegDate;
	}
	public void setCareerRegDate(String careerRegDate) {
		this.careerRegDate = careerRegDate;
	}
	@Override
	public String toString() {
		return "Career [careerCode=" + careerCode + ", officer=" + officer + ", careerName=" + careerName
				+ ", careerPeriodStart=" + careerPeriodStart + ", careerPeriodEnd=" + careerPeriodEnd
				+ ", careerRegDate=" + careerRegDate + "]";
	}
	
	
}
