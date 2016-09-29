package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.SummaryoflogbooksResp;
import com.airchina.xn.model.Summaryoflogbooks;

public interface SummaryOfLogBooksService {

	List<Summaryoflogbooks> getSummaryofLogBooksByPilotID(Integer pilot_id);
	
	SummaryoflogbooksResp newSummaryofLogBooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);
	
	SummaryoflogbooksResp updateSummaryofLogBooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);

	SummaryoflogbooksResp deleteSummaryofLogBooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList);
}
