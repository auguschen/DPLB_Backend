package com.airchina.xn.entities;

import java.io.Serializable;
import java.util.List;

import com.airchina.xn.model.Summaryoflogbooks;

public class SummaryoflogbooksResp extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4940117366903703008L;

	private List<Summaryoflogbooks> summaryoflogbooks;

	public List<Summaryoflogbooks> getSummaryoflogbooks() {
		return summaryoflogbooks;
	}

	public void setSummaryoflogbooks(List<Summaryoflogbooks> summaryoflogbooks) {
		this.summaryoflogbooks = summaryoflogbooks;
	}
}
