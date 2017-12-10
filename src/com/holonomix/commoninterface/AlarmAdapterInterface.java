package com.holonomix.commoninterface;

import com.holonomix.exception.AdapterException;
import com.holonomix.hsqldb.model.Alarm;
import com.holonomix.list.ActiveList;

public interface AlarmAdapterInterface {

	
	//public boolean authenticate() ;
	
	public void readAlarm(ActiveList<Alarm> activeList,ActiveList<Alarm> listeningList) throws AdapterException;
	
	
}
