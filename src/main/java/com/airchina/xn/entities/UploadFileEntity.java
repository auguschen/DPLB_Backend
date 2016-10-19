package com.airchina.xn.entities;

import java.io.Serializable;

public class UploadFileEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1914094329957876366L;

	private String originalPathFileName;
	private String fileNameOnServer;
	private String filePathOnServer;
	private Integer fileSize;
	private String fileType;
	public String getOriginalPathFileName() {
		return originalPathFileName;
	}
	public void setOriginalPathFileName(String originalPathFileName) {
		this.originalPathFileName = originalPathFileName;
	}
	public String getFileNameOnServer() {
		return fileNameOnServer;
	}
	public void setFileNameOnServer(String fileNameOnServer) {
		this.fileNameOnServer = fileNameOnServer;
	}
	public String getFilePathOnServer() {
		return filePathOnServer;
	}
	public void setFilePathOnServer(String filePathOnServer) {
		this.filePathOnServer = filePathOnServer;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UploadFileEntity(String originalPathFileName, String filePathOnServer, String fileNameOnServer, Integer fileSize,  String fileType){
		this.originalPathFileName = originalPathFileName;
		this.filePathOnServer = filePathOnServer;
		this.fileNameOnServer = fileNameOnServer;
		this.fileSize = fileSize;
		this.fileType = fileType;
	}
	
	public UploadFileEntity(){
		
	}
}
