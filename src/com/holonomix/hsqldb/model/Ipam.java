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
@Table(name = "IPAM")
public class Ipam extends Item {

	public final static String CLASSNAME = "IPAM";

	public Ipam() {

		creationClassName = CLASSNAME;
	}

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ipam")
	protected Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "IPAM_DEVICE", joinColumns = { @JoinColumn(name = "id_ipam") }, inverseJoinColumns = { @JoinColumn(name = "id_device") })
	private Set<Device> deviceList;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "IPAM_VLAN", joinColumns = { @JoinColumn(name = "id_ipam") }, inverseJoinColumns = { @JoinColumn(name = "id_vlan") })
	private Set<VLan> vlanList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "IPAM_NETWORKCONNECTION", joinColumns = { @JoinColumn(name = "id_ipam") }, inverseJoinColumns = { @JoinColumn(name = "id_networkConnection") })
	private Set<NetworkConnection> networkConnectionList;

	private SummaryTopology summaryTopology = new SummaryTopology();
	
	public SummaryTopology getSummaryTopology() {
		return summaryTopology;
	}

	public void setSummaryTopology(SummaryTopology summaryTopology) {
		this.summaryTopology = summaryTopology;
	}
	
	
	public Set<NetworkConnection> getNetworkConnectionList() {
		if (networkConnectionList == null) {

			networkConnectionList = new HashSet<NetworkConnection>();

		}
		return networkConnectionList;
	}

	public void setNetworkConnectionList(
			Set<NetworkConnection> networkConnectionList) {
		this.networkConnectionList = networkConnectionList;
	}
	

	public Set<VLan> getVlanList() {

		if (vlanList == null) {

			vlanList = new HashSet<VLan>();

		}

		return vlanList;

	}

	public void setVlanList(Set<VLan> vlanList) {

		this.vlanList = vlanList;

	}

	public Set<Device> getDeviceList() {
		if (deviceList == null) {
			deviceList = new HashSet<Device>();
		}
		return deviceList;
	}

	public void setDeviceList(Set<Device> deviceList) {
		this.deviceList = deviceList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String item = super.toString();
		return new StringBuffer().append(item).append(",name=" + name)
				.toString();
	}

	public boolean equals(Object o) {
		if (o instanceof Ipam) {
			if (this.name.equalsIgnoreCase(((Ipam) o).getName()))
				return true;
		}
		return false;
	}

	public int hashCode() {
		return name.hashCode();

	}
	public Ipam clone(){
		
		Ipam ipam= new Ipam();
			
		ipam.setCreationClassName(this.creationClassName);
		ipam.setDescription(this.description);
		 ipam.setDisplayName(this.displayName);
		 ipam.setName(this.name);
		 ipam.setPackageSystem(this.packageSystem);
		 ipam.setSerialNumber(this.serialNumber);
		 ipam.setTag(this.tag);
		 for (Device device:this.deviceList){
				
			 ipam.getDeviceList().add((Device)device.clone());
			}
		 for (VLan vlan:this.vlanList){
				
			 ipam.getVlanList().add((VLan)vlan.clone());
			}
			
			return ipam;
		}
	
}
