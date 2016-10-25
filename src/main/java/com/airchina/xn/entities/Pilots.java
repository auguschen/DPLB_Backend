package com.airchina.xn.entities;

import java.io.Serializable;
import java.util.List;

import com.airchina.xn.model.Pilot;

public class Pilots implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433127878749245753L;

	private List<Pilot> pilotlist;

	public List<Pilot> getPilotlist() {
		return pilotlist;
	}

	public void setPilotlist(List<Pilot> pilotlist) {
		this.pilotlist = pilotlist;
	}
	
	
	public Pilots(List<Pilot> pilots){
		this.pilotlist = pilots;
	}
	
	public Pilots(){
		
	}
	
}

