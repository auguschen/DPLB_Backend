package com.airchina.xn.entities;

import java.io.Serializable;

public class PilotsResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1965413388059758547L;

	private Pilots pilots;

	public Pilots getPilots() {
		return pilots;
	}

	public void setPilots(Pilots pilots) {
		this.pilots = pilots;
	}
	
}
