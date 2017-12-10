package com.holonomix.hsqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="IP")
public class Ip extends Item {
	
	public final static String CLASSNAME="IP";
	
	public Ip(){
			
			creationClassName=CLASSNAME;
	}
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_ip")
	protected Long id;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "netmask", nullable = false)
	private String netmask="";

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return new StringBuffer().append(item).append(",ip = " + address)
				.toString();
	}
	
	public boolean equals(Object o){
		if (o instanceof Ip){
			if (this.address.equalsIgnoreCase(((Ip)o).getAddress()))
				return true;
		}
		return false;
	}
	 public int hashCode() {
	       return address.hashCode();
	          
	}
	
	 public Ip clone(){
			
		 Ip ip= new Ip();
			
		 ip.setCreationClassName(this.creationClassName);
		 ip.setDescription(this.description);
		 ip.setDisplayName(this.displayName);
		 ip.setName(this.name);
		 ip.setNetmask(this.netmask);
		 ip.setPackageSystem(this.packageSystem);
		 ip.setSerialNumber(this.serialNumber);
		 ip.setTag(this.tag);
		 ip.setAddress(this.address);	
			
			return ip;
		}
	

}
