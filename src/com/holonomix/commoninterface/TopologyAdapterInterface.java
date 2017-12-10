package com.holonomix.commoninterface;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.holonomix.exception.AdapterException;
import com.holonomix.hsqldb.model.Card;
import com.holonomix.hsqldb.model.Device;
import com.holonomix.hsqldb.model.NetworkConnection;
import com.holonomix.hsqldb.model.VLan;

public interface TopologyAdapterInterface {

	
	//public boolean authenticate() ;
	
	public void getDevicesAndVlans(Map<String,Device> outputDevices,Map<String,VLan> outputVlans,Set<String> filterDevices) throws AdapterException;
	public void checkCardStatus(Set<Card> setCard)throws AdapterException ;
	
	public void getNetworkConnection(List<NetworkConnection> networkConnections) throws AdapterException;
	
	
}
