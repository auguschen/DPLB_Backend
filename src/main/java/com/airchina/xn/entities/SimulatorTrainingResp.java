package com.airchina.xn.entities;

import java.io.Serializable;
import java.util.List;

import com.airchina.xn.model.Simulatortraining;

public class SimulatorTrainingResp extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1453784965034019137L;

	private List<Simulatortraining> simulatortrainings;

	public List<Simulatortraining> getSimulatortrainings() {
		return simulatortrainings;
	}

	public void setSimulatortrainings(List<Simulatortraining> simulatortrainings) {
		this.simulatortrainings = simulatortrainings;
	}
}
