package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.common.PageParam;
import com.airchina.xn.model.Parameters;

public interface ParameterService {

	public List<Parameters> getAllParameters();
	
	public List<Parameters> getParametersByType(String parameterType);
	
	public List<Parameters> getParametersByName(String parameterName);
	
	public Parameters newParameter(Parameters p);

	public Parameters updateParameter(Parameters p);
	
	public Boolean deleteParameter(Parameters p);
	
	public List<Parameters> getAllParameters(PageParam pp);
	
	public List<Parameters> getParametersByType(String parameterType, PageParam pp);
	
	public List<Parameters> getParametersByName(String parameterName, PageParam pp);
}
