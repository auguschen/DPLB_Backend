package com.airchina.xn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.common.PageParam;
import com.airchina.xn.dao.LogsMapper;
import com.airchina.xn.model.Logs;
import com.airchina.xn.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {

	@Autowired
	private LogsMapper logsmapper;
	
	
	public LogsMapper getLogsmapper() {
		return logsmapper;
	}

	public void setLogsmapper(LogsMapper logsmapper) {
		this.logsmapper = logsmapper;
	}

	@Override
	public Boolean newLog(Logs l) {
		Integer res = logsmapper.insertWithoutID(l);
		return res>0?true:false;
	}

	@Override
	public List<Logs> getLogs(String objectType, Integer objectId, String operation, Integer operatorId) {
		
		Logs record = new Logs();
		
		record.setObjecttype(objectType);
		record.setObjectid(objectId);
		record.setOperation(operation);
		record.setOperatorid(operatorId);

		return logsmapper.selectByCondi(record);
	}

	@Override
	public List<Logs> getAllLogs() {
		return logsmapper.selectAll();
	}

	@Override
	public List<Logs> getLogs(String objectType, Integer objectId, String operation, Integer operatorId,
			PageParam pp) {
		return logsmapper.selectByCondiPaged(objectType, objectId, operation, operatorId, pp.getOffsetStart(), pp.getCountPerPage(), pp.getCurrentPage());
	}

	@Override
	public List<Logs> getAllLogs(PageParam pp) {
		return logsmapper.selectAllPaged(pp.getOffsetStart(), pp.getCountPerPage(), pp.getCurrentPage());
	}

}
