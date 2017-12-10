package com.holonomix.commoninterface;

import com.holonomix.exception.AdapterException;
import com.holonomix.hsqldb.model.Alarm;
import com.holonomix.hsqldb.model.Timestamp;
import com.holonomix.list.ActiveList;

public interface ListeningAlarmInterface {
	
	public int connect() throws AdapterException; 
	public void disconnect();
	public Timestamp getTimestamp();
	public void clearTimestamp() ; 
	public void setListeningList(ActiveList<Alarm> listeningList);
}
