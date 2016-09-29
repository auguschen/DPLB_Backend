package com.airchina.xn.entities;

import java.io.Serializable;
import java.util.List;

import com.airchina.xn.model.Flightcheck;

public class FlightCheckResp extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3907426893283645727L;

	private List<Flightcheck> flightchecks;

	public List<Flightcheck> getFlightchecks() {
		return flightchecks;
	}

	public void setFlightchecks(List<Flightcheck> flightchecks) {
		this.flightchecks = flightchecks;
	}
}
