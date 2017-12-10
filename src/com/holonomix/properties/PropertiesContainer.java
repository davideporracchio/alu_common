package com.holonomix.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesContainer {

	
	private static PropertiesContainer propertiesContainer;
	private Properties properties;
	private static final  Logger log = Logger.getLogger(PropertiesContainer.class);
	private PropertiesContainer(){
		
		config();
		
	}
	
	public static PropertiesContainer getInstance(){
		
		if (propertiesContainer==null)
			propertiesContainer = new PropertiesContainer();
		
		return propertiesContainer;
	}
	
	public String getProperty(String name){
		
		
		return properties.getProperty(name);
	}
	
public void setProperty(String name,String value){
		
		
		 properties.setProperty(name,value);
	}
	
	private void config() {

		properties = new Properties();
		try{
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("hidden.properties");
		properties.load(in);
		} catch (Exception e) {
		}
		
		String locationFile= System.getProperty("property.file.path");
		
		try {
		
			
			log.info("property file used "+locationFile);
			FileInputStream fis = new FileInputStream(locationFile);
			properties.load(fis);
		} catch (IOException e) {
			log.error("property file "+locationFile+"not found  ");
		}
	}
}
