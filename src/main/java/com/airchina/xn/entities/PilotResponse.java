package com.airchina.xn.entities;

import java.io.Serializable;

import com.airchina.xn.model.Pilot;

public class PilotResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1965413388059758547L;

	private Pilot pilot;

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
}
