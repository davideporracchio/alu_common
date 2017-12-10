package com.holonomix.hsqldb.model;

import org.joda.time.DateTime;

public class Timestamp {

	private DateTime dateTimeAlarm = new DateTime();
	private DateTime dataTimeHeartbeat = new DateTime();
	public DateTime getDateTimeAlarm() {
		return dateTimeAlarm;
	}
	public void setDateTimeAlarm(DateTime dateTimeAlarm) {
		this.dateTimeAlarm = dateTimeAlarm;
	}
	public DateTime getDataTimeHeartbeat() {
		return dataTimeHeartbeat;
	}
	public void setDataTimeHeartbeat(DateTime dataTimeHeartbeat) {
		this.dataTimeHeartbeat = dataTimeHeartbeat;
	}

	
}
