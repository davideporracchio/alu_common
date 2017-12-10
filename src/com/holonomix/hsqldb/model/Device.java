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
@Table(name = "DEVICE")
public class Device extends Item {

	public final static String CLASSNAMEUNKNOWN="Unknown";
	public final static String CLASSNAMEROUTER="Router";
	public final static String CLASSNAMESWITCH="Switch";
	public final static String CLASSNAMEOLT="OLT";
	public final static String CLASSNAMEMSAN="MSAN";
	public Device(){
		
		creationClassName=CLASSNAMEUNKNOWN;
	}
	
	public void setCreationClassName(String creationClassName){
		if (creationClassName.equalsIgnoreCase("router"))
				this.creationClassName=	CLASSNAMEROUTER;
		else if (creationClassName.equalsIgnoreCase("switch"))
				this.creationClassName=	CLASSNAMESWITCH;
		else if (creationClassName.equalsIgnoreCase("olt"))
			this.creationClassName=	CLASSNAMEOLT;
		else if (creationClassName.equalsIgnoreCase("msan"))
			this.creationClassName=	CLASSNAMEMSAN;
		else 
			this.creationClassName=	"ERROR";
		
	}
	
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_device")
	protected Long id;
	
	@Column(name="model")
	private String model;
	
	@Column(name="location")
	private String location;
	
	@Column(name="type")
	private String type;
	
	@Column(name="vendor")
	private String vendor;
	
	@Column(name="osVersion")
	private String osVersion;
	



	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DEVICE_IP", joinColumns = { @JoinColumn(name = "id_device") }, inverseJoinColumns = { @JoinColumn(name = "id_ip") })
	private Set<Ip> ipList;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DEVICE_SNMPAGENT", joinColumns = { @JoinColumn(name = "id_device") }, inverseJoinColumns = { @JoinColumn(name = "id_snmpagent") })
	private Set<SNMPAgent> snmpAgentList;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DEVICE_CHASSIS", joinColumns = { @JoinColumn(name = "id_device") }, inverseJoinColumns = { @JoinColumn(name = "id_chassis") })
	private Set<Chassis> chassisList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DEVICE_INTERFACE", joinColumns = { @JoinColumn(name = "id_device") }, inverseJoinColumns = { @JoinColumn(name = "id_interface") })
	private Set<Interface> interfaceList;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DEVICE_CARD", joinColumns = { @JoinColumn(name = "id_device") }, inverseJoinColumns = { @JoinColumn(name = "id_card") })
	private Set<Card> cardList;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "IPAM_NARG", joinColumns = { @JoinColumn(name = "id_device") }, inverseJoinColumns = { @JoinColumn(name = "id_narg") })
	private Set<Narg> nargList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "IPAM_NCRG", joinColumns = { @JoinColumn(name = "id_device") }, inverseJoinColumns = { @JoinColumn(name = "id_ncrg") })
	private Set<Ncrg> ncrgList;

	public Set<Narg> getNargList() {
		if (nargList == null) {

			nargList = new HashSet<Narg>();

		}
		return nargList;
	}

	public void setNargList(
			Set<Narg> nargList) {
		this.nargList = nargList;
	}
	
	public Set<Ncrg> getNcrgList() {
		if (ncrgList == null) {

			ncrgList = new HashSet<Ncrg>();

		}
		return ncrgList;
	}

	public void setNcrgList(
			Set<Ncrg> ncrgList) {
		this.ncrgList = ncrgList;
	}
	
	
	public Set<Card> getCardList() {
		if (cardList==null){
			cardList=new HashSet<Card>();
		}
		return cardList;
	}

	public void setCardList(Set<Card> cardList) {
		this.cardList = cardList;
	}
	
	
	
	public Set<Chassis> getChassisList() {
		if (chassisList==null){
			chassisList=new HashSet<Chassis>();
		}
		return chassisList;
	}

	public void setChassisList(Set<Chassis> chassisList) {
		this.chassisList = chassisList;
	}

	public Set<Interface> getInterfaceList() {
		if (interfaceList==null){
			interfaceList=new HashSet<Interface>();
		}
		return interfaceList;
	}

	public void setInterfaceList(Set<Interface> interfaceList) {
		this.interfaceList = interfaceList;
	}

	public Set<SNMPAgent> getSnmpAgentList() {
		if (snmpAgentList==null){
			snmpAgentList=new HashSet<SNMPAgent>();
		}
		return snmpAgentList;
	}

	public void setSnmpAgentList(Set<SNMPAgent> snmpAgentList) {
		this.snmpAgentList = snmpAgentList;
	}

	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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


	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	@Override
	public String toString() {
		String item = super.toString();
		return new StringBuffer().append(item).append(",name=" + name).toString();
	}
	
	public void overwrite(Device d){
		if (d.getChassisList()!=null)
		for (Chassis el:d.getChassisList())
			this.chassisList.add(el);
		if (d.getIpList()!=null)
		for (Ip el:d.getIpList()){
			if(this.ipList.add(el)==false){
				for  (Ip iptemp: this.ipList){
					if(iptemp.equals(el)){
						iptemp.update();
					}
				}
			}
		}
		if (d.getInterfaceList()!=null)
		for (Interface el:d.getInterfaceList())
			this.interfaceList.add(el);
		if (d.getSnmpAgentList()!=null)
		for (SNMPAgent el:d.getSnmpAgentList())
			this.snmpAgentList.add(el);
		
		
		
	}
	
	public boolean equals(Object o){
		if (o instanceof Device){
			if (this.name.equalsIgnoreCase(((Device)o).getName()) //&&
				//this.creationClassName.equalsIgnoreCase(((Device)o).getCreationClassName()) 
					)
				return true;
		}
		return false;
	}
	 public int hashCode() {
	       return name.hashCode();
	          
	}
	 
	 public Device clone(){
			
		 Device device= new Device();
		 device.setId(this.id);
		 device.setCreationClassName(this.creationClassName);
		 device.setDescription(this.description);
		 device.setDisplayName(this.displayName);
		 device.setName(this.name);
		 device.setPackageSystem(this.packageSystem);
		 device.setSerialNumber(this.serialNumber);
		 device.setTag(this.tag);
		 device.setLocation(this.location);
		 device.setModel(this.model);
		 device.setVendor(this.vendor);
		 device.setType(this.type);
		 device.setOsVersion(this.osVersion);
		 if(this.chassisList!=null)
		 for (Chassis chassis:this.chassisList){
				
			 device.getChassisList().add((Chassis)chassis.clone());
			}
		 if(this.cardList!=null)
		 for (Card card:this.cardList){
				
			 device.getCardList().add((Card)card.clone());
			}
		 if(this.interfaceList!=null)
		 for (Interface interface1:this.interfaceList){
				
			 device.getInterfaceList().add((Interface)interface1.clone());
			}
		 if(this.ipList!=null)
		 for (Ip ip:this.ipList){
				
			 device.getIpList().add((Ip)ip.clone());
			}
		 if(this.snmpAgentList!=null)
		 for (SNMPAgent snmpAgent:this.snmpAgentList){
				
			 device.getSnmpAgentList().add((SNMPAgent)snmpAgent.clone());
		 }
			
		 if(this.nargList!=null)
			for (Narg narg:this.nargList){
			
				device.getNargList().add((Narg)narg.clone());
		}
		 if(this.ncrgList!=null)
				for (Ncrg ncrg:this.ncrgList){
				
					device.getNcrgList().add((Ncrg)ncrg.clone());
			}
		return device;
	}
}
