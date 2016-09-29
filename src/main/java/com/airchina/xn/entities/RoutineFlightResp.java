package com.airchina.xn.entities;

import java.io.Serializable;
import java.util.List;

import com.airchina.xn.model.Routineflight;

public class RoutineFlightResp extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2844949120766646662L;

	private List<Routineflight> routineflights;

	public List<Routineflight> getRoutineflights() {
		return routineflights;
	}

	public void setRoutineflights(List<Routineflight> routineflights) {
		this.routineflights = routineflights;
	}
	
}
