package com.sbg.hrmsportal.classMobile;

import java.io.Serializable;


public class DocParse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int docId;
	private int claimId;
	private String docDesc;
	private String docOriName;
	private String docCurrName;
	
	public DocParse(int docId, int claimId, String docDesc, String docOriName,
			String docCurrName) {
		super();
		this.docId = docId;
		this.claimId = claimId;
		this.docDesc = docDesc;
		this.docOriName = docOriName;
		this.docCurrName = docCurrName;
	}
	
	public DocParse(int docId, String docDesc, String docOriName,
			String docCurrName) {
		super();
		this.docId = docId;
		this.docDesc = docDesc;
		this.docOriName = docOriName;
		this.docCurrName = docCurrName;
	}
	
	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocDesc() {
		return docDesc;
	}
	public void setDocDesc(String docDesc) {
		this.docDesc = docDesc;
	}
	public String getDocOriName() {
		return docOriName;
	}
	public void setDocOriName(String docOriName) {
		this.docOriName = docOriName;
	}
	public String getDocCurrName() {
		return docCurrName;
	}
	public void setDocCurrName(String docCurrName) {
		this.docCurrName = docCurrName;
	}
}
