package com.holonomix.hsqldb.model.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

public class EMSDeviceService {

	private static Logger log = Logger.getLogger(EMSDeviceService.class);
	private static EMSDeviceService emsDeviceService = null;

	private String fileName = "";

	private EMSDeviceService(String fileName) {
		this.fileName = fileName;

	}

	public void writeFile(List<String> listName) {
	
		
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(fileName, false));

			for (String name : listName) {
				out.write(name);
				out.write("\n");
			}
			out.close();
			if (listName.size()>0)
			log.info(" device list wrote on "+fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("error creating file "+fileName);
		}
	}

	public static EMSDeviceService getInstance(String fileName) {

		if (emsDeviceService == null || !emsDeviceService.fileName.equalsIgnoreCase(fileName))
			emsDeviceService = new EMSDeviceService(fileName);

		return emsDeviceService;
	}

}
