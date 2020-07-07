package com.javante.expense.demouser.exception;

import java.io.Serializable;
import java.util.Date;

public class ErrorDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3898277581172498977L;
	private Date date;
	private String errMessage;
	private String errCode;
	private String errPath;

	public ErrorDetail() {

	}

	public ErrorDetail(Date date, String errMessage, String errCode, String errPath) {
		this.date = date;
		this.errMessage = errMessage;
		this.errCode = errCode;
		this.errPath = errPath;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrPath() {
		return errPath;
	}

	public void setErrPath(String errPath) {
		this.errPath = errPath;
	}

}
