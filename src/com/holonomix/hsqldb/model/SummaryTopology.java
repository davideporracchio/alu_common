package com.holonomix.hsqldb.model;

public class SummaryTopology {

	
	
	String name;
	
	

	int numberDeviceCreated = 0;
	int numberDeviceChanged = 0;
	int numberDeviceError = 0;
	
	

	int numberCardChanged = 0;
	int numberCardCreated = 0;
	int numberCardDeleted = 0;
	
	int numberPortChanged = 0;
	int numberPortCreated = 0;
	int numberPortDeleted = 0;
	
	int numberChassisChanged = 0;
	int numberChassisCreated = 0;
	int numberChassisDeleted = 0;
	
	int numberIpChanged = 0;
	int numberIpCreated = 0;
	int numberIpDeleted = 0;
	
	int numberInterfaceChanged = 0;
	int numberInterfaceCreated = 0;
	int numberInterfaceDeleted = 0;
	
	int numberSnmpAgentChanged = 0;
	int numberSnmpAgentCreated = 0;
	int numberSnmpAgentDeleted = 0;
	
	int numberVlanChanged = 0;
	int numberVlanCreated = 0;
	int numberVlanDeleted = 0;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberDeviceError() {
		return numberDeviceError;
	}
	public void setNumberDeviceError(int numberDeviceError) {
		this.numberDeviceError = numberDeviceError;
	}
	
	public int getNumberDeviceCreated() {
		return numberDeviceCreated;
	}
	public void setNumberDeviceCreated(int numberDeviceCreated) {
		this.numberDeviceCreated = numberDeviceCreated;
	}
	public int getNumberDeviceChanged() {
		return numberDeviceChanged;
	}
	public void setNumberDeviceChanged(int numberDeviceChanged) {
		this.numberDeviceChanged = numberDeviceChanged;
	}
	public int getNumberCardChanged() {
		return numberCardChanged;
	}
	public void setNumberCardChanged(int numberCardChanged) {
		this.numberCardChanged = numberCardChanged;
	}
	public int getNumberCardCreated() {
		return numberCardCreated;
	}
	public void setNumberCardCreated(int numberCardCreated) {
		this.numberCardCreated = numberCardCreated;
	}
	public int getNumberCardDeleted() {
		return numberCardDeleted;
	}
	public void setNumberCardDeleted(int numberCardDeleted) {
		this.numberCardDeleted = numberCardDeleted;
	}
	public int getNumberPortChanged() {
		return numberPortChanged;
	}
	public void setNumberPortChanged(int numberPortChanged) {
		this.numberPortChanged = numberPortChanged;
	}
	public int getNumberPortCreated() {
		return numberPortCreated;
	}
	public void setNumberPortCreated(int numberPortCreated) {
		this.numberPortCreated = numberPortCreated;
	}
	public int getNumberPortDeleted() {
		return numberPortDeleted;
	}
	public void setNumberPortDeleted(int numberPortDeleted) {
		this.numberPortDeleted = numberPortDeleted;
	}
	public int getNumberChassisChanged() {
		return numberChassisChanged;
	}
	public void setNumberChassisChanged(int numberChassisChanged) {
		this.numberChassisChanged = numberChassisChanged;
	}
	public int getNumberChassisCreated() {
		return numberChassisCreated;
	}
	public void setNumberChassisCreated(int numberChassisCreated) {
		this.numberChassisCreated = numberChassisCreated;
	}
	public int getNumberChassisDeleted() {
		return numberChassisDeleted;
	}
	public void setNumberChassisDeleted(int numberChassisDeleted) {
		this.numberChassisDeleted = numberChassisDeleted;
	}
	public int getNumberIpChanged() {
		return numberIpChanged;
	}
	public void setNumberIpChanged(int numberIpChanged) {
		this.numberIpChanged = numberIpChanged;
	}
	public int getNumberIpCreated() {
		return numberIpCreated;
	}
	public void setNumberIpCreated(int numberIpCreated) {
		this.numberIpCreated = numberIpCreated;
	}
	public int getNumberIpDeleted() {
		return numberIpDeleted;
	}
	public void setNumberIpDeleted(int numberIpDeleted) {
		this.numberIpDeleted = numberIpDeleted;
	}
	public int getNumberInterfaceChanged() {
		return numberInterfaceChanged;
	}
	public void setNumberInterfaceChanged(int numberInterfaceChanged) {
		this.numberInterfaceChanged = numberInterfaceChanged;
	}
	public int getNumberInterfaceCreated() {
		return numberInterfaceCreated;
	}
	public void setNumberInterfaceCreated(int numberInterfaceCreated) {
		this.numberInterfaceCreated = numberInterfaceCreated;
	}
	public int getNumberInterfaceDeleted() {
		return numberInterfaceDeleted;
	}
	public void setNumberInterfaceDeleted(int numberInterfaceDeleted) {
		this.numberInterfaceDeleted = numberInterfaceDeleted;
	}
	public int getNumberSnmpAgentChanged() {
		return numberSnmpAgentChanged;
	}
	public void setNumberSnmpAgentChanged(int numberSnmpAgentChanged) {
		this.numberSnmpAgentChanged = numberSnmpAgentChanged;
	}
	public int getNumberSnmpAgentCreated() {
		return numberSnmpAgentCreated;
	}
	public void setNumberSnmpAgentCreated(int numberSnmpAgentCreated) {
		this.numberSnmpAgentCreated = numberSnmpAgentCreated;
	}
	public int getNumberSnmpAgentDeleted() {
		return numberSnmpAgentDeleted;
	}
	public void setNumberSnmpAgentDeleted(int numberSnmpAgentDeleted) {
		this.numberSnmpAgentDeleted = numberSnmpAgentDeleted;
	}
	public int getNumberVlanChanged() {
		return numberVlanChanged;
	}
	public void setNumberVlanChanged(int numberVlanChanged) {
		this.numberVlanChanged = numberVlanChanged;
	}
	public int getNumberVlanCreated() {
		return numberVlanCreated;
	}
	public void setNumberVlanCreated(int numberVlanCreated) {
		this.numberVlanCreated = numberVlanCreated;
	}
	public int getNumberVlanDeleted() {
		return numberVlanDeleted;
	}
	public void setNumberVlanDeleted(int numberVlanDeleted) {
		this.numberVlanDeleted = numberVlanDeleted;
	}
	
	public String toString(){
		
		StringBuffer output = new StringBuffer();
		
		output.append("SUMMARY "+name).append("\n");
		output.append(" - DEVICE").append("\n");
		output.append("      created :"+numberDeviceCreated).append("\n");
		output.append("      changed :"+numberDeviceChanged).append("\n");
		output.append("      error NBI :"+numberDeviceError).append("\n");
		output.append(" - CHASSIS").append("\n");
		output.append("      created :"+numberChassisCreated).append("\n");
		output.append("      changed :"+numberChassisChanged).append("\n");
		output.append("      deleted :"+numberChassisDeleted).append("\n");
		output.append(" - SNMPAGENT").append("\n");
		output.append("      created :"+numberSnmpAgentCreated).append("\n");
		output.append("      changed :"+numberSnmpAgentChanged).append("\n");
		output.append("      deleted :"+numberSnmpAgentDeleted).append("\n");
		output.append(" - IP").append("\n");
		output.append("      created :"+numberIpCreated).append("\n");
		output.append("      changed :"+numberIpChanged).append("\n");
		output.append("      deleted :"+numberIpDeleted).append("\n");
		output.append(" - INTERFACE").append("\n");
		output.append("      created :"+numberInterfaceCreated).append("\n");
		output.append("      changed :"+numberInterfaceChanged).append("\n");
		output.append("      deleted :"+numberInterfaceDeleted).append("\n");
		output.append(" - CARD").append("\n");
		output.append("      created :"+numberCardCreated).append("\n");
		output.append("      changed :"+numberCardChanged).append("\n");
		output.append("      deleted :"+numberCardDeleted).append("\n");
		output.append(" - PORT").append("\n");
		output.append("      created :"+numberPortCreated).append("\n");
		output.append("      changed :"+numberPortChanged).append("\n");
		output.append("      deleted :"+numberPortDeleted).append("\n");
		/*output.append(" - VLAN").append("\n");
		output.append("      created :"+numberVlanCreated).append("\n");
		output.append("      changed :"+numberVlanChanged).append("\n");
		output.append("      deleted :"+numberVlanDeleted).append("\n");*/
		
		return output.toString();
		
		
	}
	
}
