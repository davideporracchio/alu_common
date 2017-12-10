package com.holonomix.log.alarm;

import org.apache.log4j.Logger;

import com.holonomix.hsqldb.model.Alarm;
import com.holonomix.hsqldb.model.utility.Utility;

public class AlarmLog {

	private static final Logger log = Logger.getLogger(AlarmLog.class);

	public static synchronized void printAlarmStatus(Alarm alarm) {

		if (alarm.getDeviceName() == null
				|| alarm.getDeviceName().equalsIgnoreCase("")) {
			log.info("alarm incomplete nativeEMSName  is empty (device name not present) "
					+ Utility.toString(alarm));
		}

		else if ((alarm.getCondition() == null || alarm.getCondition()
				.equalsIgnoreCase(""))) {

			log.info("alarm incomplete nativeProbableCause  is empty "
					+ Utility.toString(alarm));

		} else if ((alarm.getProbableCauseQualifier() == null || alarm
				.getProbableCauseQualifier().equalsIgnoreCase(""))) {

			log.info("alarm incomplete getProbableCauseQualifier  is empty "
					+ Utility.toString(alarm));

		}

	}

	public static synchronized void printNoDeviceFound(Alarm alarm,String alarmId) {

		log.info("Alarm not sent to OI or IPAM because no device found "
				+ Utility.toString(alarm)+", "+alarmId);

	}

}
