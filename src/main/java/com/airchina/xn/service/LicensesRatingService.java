package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.LicensesRatingResp;
import com.airchina.xn.model.Licensesratingsrecord;

public interface LicensesRatingService {

	public LicensesRatingResp getLicensesRatingByPilotId(Integer pilot_id);
	
	public LicensesRatingResp newLicensesRating(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
	
	public LicensesRatingResp updateLicensesRating(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
	
	public LicensesRatingResp deleteLicensesRating(Integer pilot_id, List<Licensesratingsrecord> licenseratingsrecordList);
	
}
