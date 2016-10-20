package com.airchina.xn.entities;

import java.io.Serializable;

public class UploadFIleResp extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4395639392331069173L;
	
	private UploadFileEntity ufn;

	public UploadFileEntity getUfn() {
		return ufn;
	}

	public void setUfn(UploadFileEntity ufn) {
		this.ufn = ufn;
	}

}
