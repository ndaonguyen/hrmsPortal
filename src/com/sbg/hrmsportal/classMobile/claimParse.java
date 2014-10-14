package com.sbg.hrmsportal.classMobile;


public class claimParse {
	private int claimId;
	private String claimDesc;
	private String claimDate;
	private String claimStatus;
	private boolean isMessage;
	
	public claimParse(int claimId, String claimDesc, String claimDate,
			String claimStatus, boolean isMessage) {
		super();
		this.claimId = claimId;
		this.claimDesc = claimDesc;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.isMessage = isMessage;
	}
	
	public boolean isMessage() {
		return isMessage;
	}
	public void setMessage(boolean isMessage) {
		this.isMessage = isMessage;
	}
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public String getClaimDesc() {
		return claimDesc;
	}
	public void setClaimDesc(String claimDesc) {
		this.claimDesc = claimDesc;
	}
	public String getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

}
