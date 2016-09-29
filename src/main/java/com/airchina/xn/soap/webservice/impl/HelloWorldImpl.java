package com.airchina.xn.soap.webservice.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.airchina.xn.soap.webservice.HelloWorld;

@WebService
public class HelloWorldImpl implements HelloWorld {

	@Override
	@WebMethod
	public String sayHello(String name) {
		if (name==null || name.isEmpty()){
			return "Hello World";
		}else{
			return "Hello " + name;
		}
	}

}
