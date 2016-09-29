package com.airchina.xn.rest.webservice.impl;

import java.util.Calendar;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import com.airchina.xn.rest.webservice.TimeService;

@Service("timeService")
@Path("/")
public class TimeServiceImpl implements TimeService {

	@Override
	@GET
	@Produces("text/plain")
	public String getDateTime() {
		DateFormatter formatter = new DateFormatter("dd/MM/yyyy hh:mm:ss"); 
        return formatter.print(Calendar.getInstance().getTime(), Locale.getDefault()); 
//		return "Get Time Here. this is jus a demo.";
	}

}
