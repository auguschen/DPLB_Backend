package com.airchina.xn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.PhotosMapper;
import com.airchina.xn.dao.PilotMapper;
import com.airchina.xn.entities.UploadFileEntity;
import com.airchina.xn.model.Photos;
import com.airchina.xn.model.Pilot;
import com.airchina.xn.service.PilotService;

@Service("pilotService")
public class PilotServiceImpl implements PilotService {

	@Autowired
	private PilotMapper pilotmapper;
	
	@Autowired
	private PhotosMapper photosmapper;
	
	public PhotosMapper getPhotosmapper() {
		return photosmapper;
	}


	public void setPhotosmapper(PhotosMapper photosmapper) {
		this.photosmapper = photosmapper;
	}


	public PilotMapper getPilotmapper() {
		return pilotmapper;
	}


	public void setPilotmapper(PilotMapper pilotmapper) {
		this.pilotmapper = pilotmapper;
	}


	@Override
	public Pilot getPilotById(Integer pilot_id) {
		return pilotmapper.selectByPrimaryKey(pilot_id);
	}


	@Override
	public List<Pilot> getPilotsByName(String name) {
		return pilotmapper.selectByName(name);
	}


	@Override
	public List<Pilot> getPilotsByLicenseNo(String licenseNo) {
		return pilotmapper.selectByLicenseNo(licenseNo);
	}


	@Override
	public Pilot newPilot(Pilot p) {
		try {
			Integer res = pilotmapper.insertWithoutID(p);
			return res>0?p:new Pilot();
		} catch (Exception e) {
			return new Pilot();
		}
	}


	@Override
	public Pilot updatePilot(Pilot p) {
		Integer res = pilotmapper.updateByPrimaryKey(p);
		return res>0?p:new Pilot();
	}


	@Override
	public Boolean deletePilot(Pilot p) {
		Integer res = pilotmapper.deleteByPrimaryKey(p.getId());
		return res>0?true:false;
	}


	@Override
	public Pilot getPilotsByStaffNumber(String staffNumber) {
		return pilotmapper.selectByStaffNumber(staffNumber);
	}


	@Override
	public List<Pilot> getPilots() {
		return pilotmapper.selectAll();
	}


	@Override
	public Photos getPilotPhoto(Integer pilot_id) {
		return photosmapper.selectByPilotID(pilot_id);
	}


	@Override
	public Photos newPilotPhoto(Integer pilot_id, UploadFileEntity ufn) {
		try {
			Photos record = new Photos(pilot_id,ufn.getFilePathOnServer(),ufn.getFileNameOnServer(),ufn.getFileType(),ufn.getFileSize());
			Integer res = photosmapper.insertWithoutID(record);
			return res>0?record:new Photos();
		} catch (Exception e) {
			return new Photos();
		}
	}


	@Override
	public Photos updatePilotPhoto(Integer pilot_id,  UploadFileEntity ufn) {
		Photos photo = new Photos(pilot_id,ufn.getFilePathOnServer(),ufn.getFileNameOnServer(),ufn.getFileType(),ufn.getFileSize());
		if (null==getPilotPhoto(pilot_id)){
			//无照片，新增
			return newPilotPhoto(pilot_id, ufn);
		}else{
			//有照片，更新
			Integer res = photosmapper.updateByPrimaryKey(photo);		
			return res>0?photo:new Photos();
		}
	}


	@Override
	public Boolean deletePilotPhoto(Photos photo) {
		Integer res = photosmapper.deleteByPrimaryKey(photo.getId());
		return res>0?true:false;
	}

}
