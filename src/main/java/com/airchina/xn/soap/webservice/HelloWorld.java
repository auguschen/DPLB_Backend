package com.airchina.xn.soap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorld {

	@WebMethod
	public String sayHello(@WebParam(name="name") String name);
}
