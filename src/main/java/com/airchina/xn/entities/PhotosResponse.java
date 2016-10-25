package com.airchina.xn.entities;

import java.io.Serializable;

import com.airchina.xn.model.Photos;

public class PhotosResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1730928864772796512L;

	private Photos photo;

	public Photos getPhoto() {
		return photo;
	}

	public void setPhoto(Photos photo) {
		this.photo = photo;
	}
	
}
