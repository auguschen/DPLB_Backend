package com.airchina.xn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.LicensesratingsrecordMapper;
import com.airchina.xn.entities.LicensesRatingResp;
import com.airchina.xn.entities.Messages;
import com.airchina.xn.model.Licensesratingsrecord;
import com.airchina.xn.service.LicensesRatingService;

@Service("licensesratingService")
public class LicensesRatingServiceImpl implements LicensesRatingService {
	
	@Autowired
	private LicensesratingsrecordMapper licensesratingsrecordmapper;

	public LicensesratingsrecordMapper getLicensesratingsrecordmapper() {
		return licensesratingsrecordmapper;
	}

	public void setLicensesratingsrecordmapper(LicensesratingsrecordMapper licensesratingsrecordmapper) {
		this.licensesratingsrecordmapper = licensesratingsrecordmapper;
	}

	@Override
	public LicensesRatingResp getLicensesRatingByPilotId(Integer pilot_id) {
		LicensesRatingResp res = new LicensesRatingResp();
		List<Licensesratingsrecord> liclist = licensesratingsrecordmapper.selectAllByPilotID(pilot_id);
		if (liclist!=null && !liclist.isEmpty()){
			res.setIsSuccessful(true);
			res.setReturnCode(0);
			res.setLicensesRatingsRecords(liclist);
		}
		return res;
	}

	@Override
	public LicensesRatingResp newLicensesRating(Integer pilot_id,
			List<Licensesratingsrecord> licenseratingsrecordList) {
		LicensesRatingResp res = new LicensesRatingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Licensesratingsrecord lrr:licenseratingsrecordList){
			lrr.setPilotId(pilot_id);
			try {
				Integer re = licensesratingsrecordmapper.insertWithoutID(lrr);
				messages.add("effcet record " + re.toString());		
				iserror.add(false);
			} catch (Exception e) {
				iserror.add(true);
				messages.add(e.getMessage());			
			}
		}
		returnMessage.setMessages(messages);
		returnMessage.setIsError(iserror);
		res.setReturnMessage(returnMessage);
		res.setIsSuccessful(true);
		res.setLicensesRatingsRecords(licenseratingsrecordList);
		return res;
	}

	@Override
	public LicensesRatingResp updateLicensesRating(Integer pilot_id,
			List<Licensesratingsrecord> licenseratingsrecordList) {
		LicensesRatingResp res = new LicensesRatingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Licensesratingsrecord lrr:licenseratingsrecordList){
			if(pilot_id.equals(lrr.getPilotId())){
				try {
					Integer re = licensesratingsrecordmapper.updateByPrimaryKey(lrr);
					messages.add("effcet record " + re.toString());	
					iserror.add(false);
				} catch (Exception e) {
					iserror.add(true);
					messages.add(e.getMessage());			
				}
			}else{
				iserror.add(true);
				messages.add("pilot_id not equal");			
			}
		}
		returnMessage.setMessages(messages);
		res.setReturnMessage(returnMessage);
		returnMessage.setIsError(iserror);
		res.setIsSuccessful(true);
		res.setLicensesRatingsRecords(licenseratingsrecordList);
		return res;
	}

	@Override
	public LicensesRatingResp deleteLicensesRating(Integer pilot_id,
			List<Licensesratingsrecord> licenseratingsrecordList) {
		LicensesRatingResp res = new LicensesRatingResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<Boolean> iserror = new ArrayList<Boolean>();
		List<String> messages = new ArrayList<String>();
		for(Licensesratingsrecord lrr:licenseratingsrecordList){
			if(pilot_id.equals(lrr.getPilotId())){
				try {
					Integer re = licensesratingsrecordmapper.deleteByPrimaryKey(lrr.getId());
					messages.add("effcet record " + re.toString());
					iserror.add(false);
				} catch (Exception e) {
					iserror.add(true);
					messages.add(e.getMessage());			
				}
			}else{
				iserror.add(true);
				messages.add("pilot_id not equal");			
			}
		}
		returnMessage.setMessages(messages);
		res.setReturnMessage(returnMessage);
		returnMessage.setIsError(iserror);
		res.setIsSuccessful(true);
		res.setLicensesRatingsRecords(licenseratingsrecordList);
		return res;
	}

}
