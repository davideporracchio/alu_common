package com.holonomix.hsqldb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VLAN")
public class VLan extends Item {

	public final static String CLASSNAMEVLAN="VLAN";
	
	public VLan(){
		
		creationClassName=CLASSNAMEVLAN;
	}
	
	public void setCreationClassName(String creationClassName){
		
				this.creationClassName=	creationClassName;
		
		
		
	}
	private String VLANkey;
	private String VLANnumber;
	
	
	public String getVLANkey() {
		return VLANkey;
	}

	public void setVLANkey(String vLANkey) {
		VLANkey = vLANkey;
	}

	public String getVLANnumber() {
		return VLANnumber;
	}

	public void setVLANnumber(String vLANnumber) {
		VLANnumber = vLANnumber;
	}
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_vlan")
	protected Long id;
	
	Set<String> deviceNameList;

	

	public Set<String> getDeviceNameList() {
		if (deviceNameList==null){
			deviceNameList=new HashSet<String>();
		}
		return deviceNameList;
	}

	public void setDeviceNameList(Set<String> deviceNameList) {
		this.deviceNameList = deviceNameList;
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
		return new StringBuffer().append(item).append(",name=" + name).toString();
	}
	
	
	
	public boolean equals(Object o){
		if (o instanceof VLan){
			if (this.VLANkey.equalsIgnoreCase(((VLan)o).getVLANkey()))
				
				return true;
		}
		return false;
	}
	 public int hashCode() {
	       return VLANkey.hashCode();
	          
	}
	 
	 public VLan clone(){
			
		 VLan vlan= new VLan();
			
		 vlan.setCreationClassName(this.creationClassName);
		 vlan.setDescription(this.description);
		 vlan.setDisplayName(this.displayName);
		 vlan.setName(this.name);
		 vlan.setPackageSystem(this.packageSystem);
		 vlan.setSerialNumber(this.serialNumber);
		 vlan.setTag(this.tag);
		 vlan.setVLANkey(this.VLANkey);
		 vlan.setVLANnumber(this.VLANnumber);
		 
		return vlan;
		}
}
