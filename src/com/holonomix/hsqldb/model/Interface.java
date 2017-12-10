package com.holonomix.hsqldb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INTERFACE")
public class Interface extends Item {


	public final static String CLASSNAME="Interface";
	public final static String DEFAULTTYPE = "ETHERNETCSMACD";
	public final static String VLANTYPE = "ETHERNETCSMACD";
	public final static String GENERICTYPE = "GENERIC";
	public final static String TUNNELTYPE = "TUNNEL";
	public final static String ATMTYPE = "ATM";
	public final static String LOOPBACK = "SOFTWARELOOPBACK";
	
	public Interface(){
			
			creationClassName=CLASSNAME;
	}
	
	
		
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_interface")
	protected Long id;
	
	@Column(name="max_speed")
	private String maxSpeed="0";
	
	@Column(name="max_transfer_unit")
	private String maxTransferUnit="0";
	
	
	private String interfaceNumber="";

	



	@Column(name="layered_over")
	private String layeredOver;
	
	@Column(name="admin_status")
	private String adminStatus;
	
	@Column(name="oper_status")
	private String operStatus;
	
	@Column(name="device_id")
	private String deviceId;
	
	@Column(name="vlan_id")
	private String vlanId;
	
	@Column(name="interface_key")
	private String interfaceKey;
	
	@Column(name="parent_Interface")
	private String parentInterface;
	
	@Column(name="parent_Device")
	private String parentDevice="";
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "INTERFACE_VLAN", joinColumns = { @JoinColumn(name = "id_interface") }, inverseJoinColumns = { @JoinColumn(name = "id_vlan") })
	private Set<VLan> vlanList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "INTERFACE_IP", joinColumns = { @JoinColumn(name = "id_interface") }, inverseJoinColumns = { @JoinColumn(name = "id_ip") })
	private Set<Ip> ipList;
	
	private Mac mac;
	
	public Mac getMac() {
		return mac;
	}

	public void setMac(Mac mac) {
		this.mac = mac;
	}

	public Set<Ip> getIpList() {
		if (ipList==null){
			ipList=new HashSet<Ip>();
		}
		return ipList;
	}

	public void setIpList(Set<Ip> ipList) {
		this.ipList = ipList;
	}
	
	public Set<VLan> getVlanList() {
		if (vlanList==null){
			vlanList=new HashSet<VLan>();
		}
		return vlanList;
	}

	public void setVlanList(Set<VLan> vlanList) {
		this.vlanList = vlanList;
	}
	
	public String getParentDevice() {
		return parentDevice;
	}

	public void setParentDevice(String parentDevice) {
		this.parentDevice = parentDevice;
	}

	public String getParentInterface() {
		return parentInterface;
	}

	public void setParentInterface(String parentInterface) {
		this.parentInterface = parentInterface;
	}

	public String getInterfaceKey() {
		return interfaceKey;
	}

	public void setInterfaceKey(String interfaceKey) {
		this.interfaceKey = interfaceKey;
	}

	

	public String getMaxTransferUnit() {
		return maxTransferUnit;
	}

	public void setMaxTransferUnit(String maxTransferUnit) {
		this.maxTransferUnit = maxTransferUnit;
	}
	

	public String getVlanId() {
		return vlanId;
	}

	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name="type")
	private String type="";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(String maxSpeed) {
		if(maxSpeed!=null && !maxSpeed.equalsIgnoreCase("") && !maxSpeed.equalsIgnoreCase("--") && !maxSpeed.equalsIgnoreCase("Auto")){
		 if(maxSpeed.equalsIgnoreCase("0M")){
				maxSpeed="0";
		 }
		 else if (maxSpeed.indexOf("M")!=-1){
			 maxSpeed= maxSpeed.replace("M", "000000");
		 }
		 else if (maxSpeed.indexOf("BG")!=-1){
			 maxSpeed= maxSpeed.replace("GB", "000000");
		 }
			 this.maxSpeed = maxSpeed;
		}

	}

	public String getLayeredOver() {
		return layeredOver;
	}

	public void setLayeredOver(String layeredOver) {
		this.layeredOver = layeredOver;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public String getOperStatus() {
		return operStatus;
	}

	public void setOperStatus(String operStatus) {
		this.operStatus = operStatus;
	}

	

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String item = super.toString();
		return new StringBuffer().append(item).append(",name=" + name)
				.toString();
	}
	
public boolean equals(Object o) {

		
		if (o instanceof Interface) {

			if (this.deviceId.equalsIgnoreCase(((Interface) o).getDeviceId())){

				return true;

			}

		}

		// System.out.println("compare cards: return false");

		return false;

	}
	
	 public int hashCode() {
	       return deviceId.hashCode();	          
	}
	 
	 public String getInterfaceNumber() {
			return interfaceNumber;
		}

		public void setInterfaceNumber(String interfaceNumber) {
			this.interfaceNumber = interfaceNumber;
		}
	
	 
	 public Interface clone(){
			
		 Interface interface1= new Interface();
			
			interface1.setCreationClassName(this.creationClassName);
			interface1.setDescription(this.description);
			interface1.setDisplayName(this.displayName);
			
			interface1.setName(this.name);
			
			interface1.setPackageSystem(this.packageSystem);
			
			
			interface1.setSerialNumber(this.serialNumber);
			
			interface1.setDeviceId(this.deviceId);
			interface1.setVlanId(this.vlanId);
			interface1.setTag(this.tag);
			interface1.setType(this.type);
			interface1.setAdminStatus(this.adminStatus);
			interface1.setMaxSpeed(this.maxSpeed);
			interface1.setOperStatus(this.operStatus);
			interface1.setParentInterface(this.parentInterface);
			interface1.setInterfaceKey(this.interfaceKey);
			interface1.setInterfaceNumber(this.interfaceNumber);
			interface1.setMaxTransferUnit(this.maxTransferUnit);
			interface1.setMac(this.mac);
			if (this.vlanList!=null)
				for (VLan vlan:this.vlanList){
						
					 interface1.getVlanList().add((VLan)vlan.clone());
				}
			if (this.ipList!=null)
				for (Ip ip:this.ipList){
						
					 interface1.getIpList().add((Ip)ip.clone());
				}
			return interface1;
		}
}

