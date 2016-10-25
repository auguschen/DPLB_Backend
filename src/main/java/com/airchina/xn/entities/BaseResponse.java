package com.airchina.xn.entities;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6841193150052720698L;

	private Boolean isSuccessful;
	private Messages returnMessage;
	private Integer returnCode;
	
	public Integer getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}
	public Boolean getIsSuccessful() {
		return isSuccessful;
	}
	public void setIsSuccessful(Boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	public Messages getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(Messages returnMessage) {
		this.returnMessage = returnMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public BaseResponse(){
		this.isSuccessful = false;
		this.returnMessage = new Messages();
		this.returnCode = -1;
	}
	
	public BaseResponse(Boolean issuccessful, Messages messages, Integer returncode){
		this.isSuccessful = issuccessful;
		this.returnMessage = messages;
		this.returnCode = returncode;
	}
}
