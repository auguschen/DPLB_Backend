package com.airchina.xn.entities;

import java.io.Serializable;
import java.util.List;

import com.airchina.xn.model.Flighttraining;

public class FlightTrainingResp extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1835476938891915131L;
	
	private List<Flighttraining> flighttrainings;

	public List<Flighttraining> getFlighttrainings() {
		return flighttrainings;
	}

	public void setFlighttrainings(List<Flighttraining> flighttrainings) {
		this.flighttrainings = flighttrainings;
	}

}
