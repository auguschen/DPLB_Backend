package com.airchina.xn.model;

import java.util.Date;

public class Flightcheck {
    private Integer id;

    private Integer pilotId;

    private Date flightcheckDate;

    private String typeOfAircraft;

    private String typeOfCheck;

    private String conclusion;

    private String examiner;

    private String signature;

    private String remarks;

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

    public Date getFlightcheckDate() {
        return flightcheckDate;
    }

    public void setFlightcheckDate(Date flightcheckDate) {
        this.flightcheckDate = flightcheckDate;
    }

    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    public void setTypeOfAircraft(String typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }

    public String getTypeOfCheck() {
        return typeOfCheck;
    }

    public void setTypeOfCheck(String typeOfCheck) {
        this.typeOfCheck = typeOfCheck;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getExaminer() {
        return examiner;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}