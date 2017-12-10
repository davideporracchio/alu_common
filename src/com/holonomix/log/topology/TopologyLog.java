package com.holonomix.log.topology;

import org.apache.log4j.Logger;

import com.holonomix.hsqldb.model.Device;
import com.holonomix.hsqldb.model.Ipam;
import com.holonomix.hsqldb.model.Item.Status;

public class TopologyLog {

	private static final Logger log = Logger.getLogger(TopologyLog.class);

	public static synchronized void printIpamStatus(Ipam ipam) {
		String ipamName = ipam.getName();
		for (Device device : ipam.getDeviceList()) {
			if (device.getFlagStatus() == Status.ADDED
					|| device.getFlagStatus() == Status.UPDATED) {
				log.info("Unable to instantiate device: " +device.getName()+ ", in ipam: " + ipamName);
			}
	
		}
	}
	
	public static synchronized void printDeviceStatus(Device device) {
		
			if (device.getFlagStatus()!=null && device.getFlagStatus()==Status.ERROR)
				log.info("Unable to instantiate device: " +device.getName()+ ", error in EMS ");
			else
				log.info("Unable to instantiate device: " +device.getName()+ ", it is not present in MULTI_DOMAIN_MAPPING_FILE ");
			
	}

}
