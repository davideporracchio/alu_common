package com.holonomix.commoninterface;

import com.holonomix.hsqldb.model.Alarm;


public interface AlarmMappingFileInterface {

	
	public void update(); 
	public String[] findInstructionForAlarm(Alarm alarm);
	
	

	

}
