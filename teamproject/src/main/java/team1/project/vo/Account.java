package team1.project.vo;

public class Account {
	private String accountCode;
	private String accountName;
	private String accountKind;
	private String accountDescription;
	private String accountRegDate;
	private String officerId;
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountKind() {
		return accountKind;
	}
	public void setAccountKind(String accountKind) {
		this.accountKind = accountKind;
	}
	public String getAccountDescription() {
		return accountDescription;
	}
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}
	public String getAccountRegDate() {
		return accountRegDate;
	}
	public void setAccountRegDate(String accountRegDate) {
		this.accountRegDate = accountRegDate;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	@Override
	public String toString() {
		return "Account [accountCode=" + accountCode + ", accountName=" + accountName + ", accountKind=" + accountKind
				+ ", accountDescription=" + accountDescription + ", accountRegDate=" + accountRegDate + ", officerId="
				+ officerId + "]";
	}
	
}
