package com.airchina.xn.rest.webservice;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import com.airchina.xn.model.Aircraft;
import com.airchina.xn.model.Logs;
import com.airchina.xn.model.Parameters;

public interface DPLBServicesRestWebService {

//	根据飞机注册号查询航空器
	public Aircraft getAircraftByRegNo(String regno);
//	根据飞机型别机型查询航空器
	public List<Aircraft> getAircraftByType(String typecatalog, String typeofaircraft);
	public List<Aircraft> getAircraftByType(String typecatalog, String typeofaircraft, Integer pageStart, Integer countPerPage, Integer currentPage);
//	查询所有航空器
	public List<Aircraft> getAllAircraft();
	public List<Aircraft> getAllAircraft(Integer pageStart, Integer countPerPage, Integer currentPage);
//	新增一个航空器
	public Aircraft newAircraft(Aircraft ac);
//	更新一个航空器
	public Aircraft updateAircraft(Aircraft ac);
//	删除一个航空器
	public Boolean deleteAircraft(Aircraft ac);
	
//	新增一条日志记录
	public Boolean newLog(Logs l);
//	获取所有日志
	public List<Logs> getAllLogs();
	public List<Logs> getAllLogs(Integer pageStart, Integer countPerPage, Integer currentPage);
//	查询日志记录
	public List<Logs> getLogs(String objectType, Integer objectId, String operation, Integer operatorId);
	public List<Logs> getLogs(String objectType, Integer objectId, String operation, Integer operatorId, Integer pageStart, Integer countPerPage, Integer currentPage);
	
	
//	新增一条参数信息
	public Parameters newParameter(Parameters p);
//	修改一条参数信息
	public Parameters updateParameter(Parameters p);
//	删除一条参数信息
	public Boolean deleteParameter(Parameters p);
//	获取所有参数信息
	public List<Parameters> getParameters();
	public List<Parameters> getParameters(Integer pageStart, Integer countPerPage, Integer currentPage);
//	获取某一类型的参数信息
	public List<Parameters> getParametersByType(String parameterType);
	public List<Parameters> getParametersByType(String parameterType, Integer pageStart, Integer countPerPage, Integer currentPage);
//	获取某个名称的参数信息
	public List<Parameters> getParametersByName(String parameterName);
	public List<Parameters> getParametersByName(String parameterName, Integer pageStart, Integer countPerPage, Integer currentPage);
	
//	上传文件
	public Response uploadOneFile(Attachment attachment);
}
