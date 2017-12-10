package com.holonomix.commoninterface;

import com.holonomix.exception.AdapterException;
import com.holonomix.hsqldb.model.Alarm;
import com.holonomix.list.ActiveList;

public interface ActiveAlarmInterface {

	public void connect(ActiveList<Alarm> activeList) throws AdapterException; 
	public void disconnect();	
}
