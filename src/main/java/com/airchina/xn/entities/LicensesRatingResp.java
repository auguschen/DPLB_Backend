package com.airchina.xn.entities;

import java.io.Serializable;
import java.util.List;

import com.airchina.xn.model.Licensesratingsrecord;

public class LicensesRatingResp extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2700226177799932942L;
	
	private List<Licensesratingsrecord> licensesRatingsRecords;

	public List<Licensesratingsrecord> getLicensesRatingsRecords() {
		return licensesRatingsRecords;
	}

	public void setLicensesRatingsRecords(List<Licensesratingsrecord> licensesRatingsRecords) {
		this.licensesRatingsRecords = licensesRatingsRecords;
	}

}
