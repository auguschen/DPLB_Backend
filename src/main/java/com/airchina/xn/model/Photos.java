package com.airchina.xn.model;

import java.util.Date;

public class Photos {
    private Integer id;

	private Integer pilotId;

	private String photoPath;

	private String photoFilename;

	private String photoExt;

	private Integer photoSize;

	private Boolean deleted;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPilotId() {
		return pilotId;
	}

	public void setPilotId(Integer pilotId) {
		this.pilotId = pilotId;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPhotoFilename() {
		return photoFilename;
	}

	public void setPhotoFilename(String photoFilename) {
		this.photoFilename = photoFilename;
	}

	public String getPhotoExt() {
		return photoExt;
	}

	public void setPhotoExt(String photoExt) {
		this.photoExt = photoExt;
	}

	public Integer getPhotoSize() {
		return photoSize;
	}

	public void setPhotoSize(Integer photoSize) {
		this.photoSize = photoSize;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Photos(){
		
	}
	
	public Photos(Integer pilot_id, String photopath, String photofilename, String photoext, Integer photosize){
		this.pilotId = pilot_id;
		this.photoPath = photopath;
		this.photoFilename = photofilename;
		this.photoExt = photoext;
		this.photoSize = photosize;
	}

}