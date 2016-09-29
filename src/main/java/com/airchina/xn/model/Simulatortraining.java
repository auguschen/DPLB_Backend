package com.airchina.xn.model;

import java.util.Date;

public class Simulatortraining {
    private Integer id;

    private Integer pilotId;

    private Date flightDate;

    private String typeOfAircraft;

    private String certNo;

    private String levelOfSimulator;

    private String fto;

    private String typeOfTrainingOrCheck;

    private String trainingTimeFrom;

    private String trainingTimeTo;

    private String trainingTimeTime;

    private Integer landingsDay;

    private Integer landingsNight;

    private Integer takeoffsDay;

    private Integer takeoffsNight;

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

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    public void setTypeOfAircraft(String typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getLevelOfSimulator() {
        return levelOfSimulator;
    }

    public void setLevelOfSimulator(String levelOfSimulator) {
        this.levelOfSimulator = levelOfSimulator;
    }

    public String getFto() {
        return fto;
    }

    public void setFto(String fto) {
        this.fto = fto;
    }

    public String getTypeOfTrainingOrCheck() {
        return typeOfTrainingOrCheck;
    }

    public void setTypeOfTrainingOrCheck(String typeOfTrainingOrCheck) {
        this.typeOfTrainingOrCheck = typeOfTrainingOrCheck;
    }

    public String getTrainingTimeFrom() {
        return trainingTimeFrom;
    }

    public void setTrainingTimeFrom(String trainingTimeFrom) {
        this.trainingTimeFrom = trainingTimeFrom;
    }

    public String getTrainingTimeTo() {
        return trainingTimeTo;
    }

    public void setTrainingTimeTo(String trainingTimeTo) {
        this.trainingTimeTo = trainingTimeTo;
    }

    public String getTrainingTimeTime() {
        return trainingTimeTime;
    }

    public void setTrainingTimeTime(String trainingTimeTime) {
        this.trainingTimeTime = trainingTimeTime;
    }

    public Integer getLandingsDay() {
        return landingsDay;
    }

    public void setLandingsDay(Integer landingsDay) {
        this.landingsDay = landingsDay;
    }

    public Integer getLandingsNight() {
        return landingsNight;
    }

    public void setLandingsNight(Integer landingsNight) {
        this.landingsNight = landingsNight;
    }

    public Integer getTakeoffsDay() {
        return takeoffsDay;
    }

    public void setTakeoffsDay(Integer takeoffsDay) {
        this.takeoffsDay = takeoffsDay;
    }

    public Integer getTakeoffsNight() {
        return takeoffsNight;
    }

    public void setTakeoffsNight(Integer takeoffsNight) {
        this.takeoffsNight = takeoffsNight;
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