package com.airchina.xn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.common.PageParam;
import com.airchina.xn.dao.ParametersMapper;
import com.airchina.xn.model.Parameters;
import com.airchina.xn.service.ParameterService;

@Service("parameterService")
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private ParametersMapper parametersmapper;
	
	public ParametersMapper getParametersmapper() {
		return parametersmapper;
	}

	public void setParametersmapper(ParametersMapper parametersmapper) {
		this.parametersmapper = parametersmapper;
	}

	@Override
	public List<Parameters> getAllParameters() {
		return parametersmapper.selectAll();
	}

	@Override
	public List<Parameters> getParametersByType(String parameterType) {
		return parametersmapper.selectByType(parameterType);
	}

	@Override
	public List<Parameters> getParametersByName(String parameterName) {
		return parametersmapper.selectByName(parameterName);
	}

	@Override
	public Parameters newParameter(Parameters p) {
		Integer res = parametersmapper.insertWithoutID(p);
		return res>0?p:new Parameters();
	}

	@Override
	public Parameters updateParameter(Parameters p) {
		Integer res = parametersmapper.updateByPrimaryKey(p);
		return res>0?p:new Parameters();
	}

	@Override
	public Boolean deleteParameter(Parameters p) {
		Integer res = parametersmapper.deleteByPrimaryKey(p.getId());
		return res>0?true:false;
	}

	@Override
	public List<Parameters> getAllParameters(PageParam pp) {
		return parametersmapper.selectAllPaged(pp.getOffsetStart(), pp.getCountPerPage(), pp.getCurrentPage());
	}

	@Override
	public List<Parameters> getParametersByType(String parameterType, PageParam pp) {
		return parametersmapper.selectByTypePaged(parameterType, pp.getOffsetStart(), pp.getCountPerPage(), pp.getCurrentPage());
	}

	@Override
	public List<Parameters> getParametersByName(String parameterName, PageParam pp) {
		return parametersmapper.selectByNamePaged(parameterName, pp.getOffsetStart(), pp.getCountPerPage(), pp.getCurrentPage());
	}

}
