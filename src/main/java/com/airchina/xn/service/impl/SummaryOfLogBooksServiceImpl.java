package com.airchina.xn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.SummaryoflogbooksMapper;
import com.airchina.xn.entities.Messages;
import com.airchina.xn.entities.SummaryoflogbooksResp;
import com.airchina.xn.model.Summaryoflogbooks;
import com.airchina.xn.service.SummaryOfLogBooksService;

@Service("summaryoflogbooksService")
public class SummaryOfLogBooksServiceImpl implements SummaryOfLogBooksService {
	
	@Autowired
	private SummaryoflogbooksMapper summaryoflogbooksmapper;
	

	public SummaryoflogbooksMapper getSummaryoflogbooksmapper() {
		return summaryoflogbooksmapper;
	}

	public void setSummaryoflogbooksmapper(SummaryoflogbooksMapper summaryoflogbooksmapper) {
		this.summaryoflogbooksmapper = summaryoflogbooksmapper;
	}

	@Override
	public SummaryoflogbooksResp getSummaryofLogBooksByPilotID(Integer pilot_id) {
		SummaryoflogbooksResp res = new SummaryoflogbooksResp();
		List<Summaryoflogbooks> sumlist = summaryoflogbooksmapper.selectByPilotID(pilot_id);
		if (sumlist!=null && !sumlist.isEmpty()){
			res.setIsSuccessful(true);
			res.setReturnCode(0);
			res.setSummaryoflogbooks(sumlist);
		}
		return res;
	}

	@Override
	public SummaryoflogbooksResp newSummaryofLogBooks(Integer pilot_id, List<Summaryoflogbooks> summaryoflogbooksList) {
		SummaryoflogbooksResp res = new SummaryoflogbooksResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Summaryoflogbooks solb:summaryoflogbooksList){
			solb.setPilotId(pilot_id);
			try {
				Integer re = summaryoflogbooksmapper.insertWithoutID(solb);
				messages.add("effcet record " + re.toString());		
				iserror.add(false);
			} catch (Exception e) {
				iserror.add(true);
				messages.add(e.getMessage());			
			}
		}
		returnMessage.setMessages(messages);
		returnMessage.setIsError(iserror);
		res.setReturnMessage(returnMessage);
		res.setIsSuccessful(true);
		res.setSummaryoflogbooks(summaryoflogbooksList);
		return res;
	}

	@Override
	public SummaryoflogbooksResp updateSummaryofLogBooks(Integer pilot_id,
			List<Summaryoflogbooks> summaryoflogbooksList) {
		SummaryoflogbooksResp res = new SummaryoflogbooksResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Summaryoflogbooks solb:summaryoflogbooksList){
			if(pilot_id.equals(solb.getPilotId())){
				try {
					Integer re = summaryoflogbooksmapper.updateByPrimaryKey(solb);
					messages.add("effcet record " + re.toString());		
					iserror.add(false);
				} catch (Exception e) {
					iserror.add(true);
					messages.add(e.getMessage());			
				}
			}else{
				iserror.add(true);
				messages.add("pilot_id not equal");							
			}
		}
		returnMessage.setMessages(messages);
		returnMessage.setIsError(iserror);
		res.setReturnMessage(returnMessage);
		res.setIsSuccessful(true);
		res.setSummaryoflogbooks(summaryoflogbooksList);
		return res;
	}

	@Override
	public SummaryoflogbooksResp deleteSummaryofLogBooks(Integer pilot_id,
			List<Summaryoflogbooks> summaryoflogbooksList) {
		SummaryoflogbooksResp res = new SummaryoflogbooksResp();
		res.setReturnCode(0);
		Messages returnMessage = new Messages();
		List<String> messages = new ArrayList<String>();
		List<Boolean> iserror = new ArrayList<Boolean>();
		for(Summaryoflogbooks solb:summaryoflogbooksList){
			if(pilot_id.equals(solb.getPilotId())){
				try {
					Integer re = summaryoflogbooksmapper.deleteByPrimaryKey(solb.getId());
					messages.add("effcet record " + re.toString());		
					iserror.add(false);
				} catch (Exception e) {
					iserror.add(true);
					messages.add(e.getMessage());			
				}
			}else{
				iserror.add(true);
				messages.add("pilot_id not equal");							
			}
		}
		returnMessage.setMessages(messages);
		returnMessage.setIsError(iserror);
		res.setReturnMessage(returnMessage);
		res.setIsSuccessful(true);
		res.setSummaryoflogbooks(summaryoflogbooksList);
		return res;
	}

}
