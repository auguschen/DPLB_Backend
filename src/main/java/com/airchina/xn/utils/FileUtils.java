package com.airchina.xn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.core.MultivaluedMap;

public final class FileUtils {
	

	public static String getFileName(MultivaluedMap<String, String> header) {
		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {
				String[] name = filename.split("=");
				String exactFileName = name[1].trim().replaceAll("\"", "");
				return exactFileName;
			}
		}
		return "unknown";
	}

	
	public static String getFileExtName(String exactFileName){
		String[] p = exactFileName.split("\\.");
		if (p.length>0){
			return p[p.length-1];
		}
		return "";
		
	}
	
	public static String getProperties(String key){
		Properties prop = new Properties();
		InputStream in = FileUtils.class.getResourceAsStream("/upload.location.properties");
		try {
			prop.load(in);
			String value = prop.getProperty(key).trim();
			return value;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
