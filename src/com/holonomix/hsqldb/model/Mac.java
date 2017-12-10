package com.holonomix.hsqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="MAC")
public class Mac extends Item {
	
	public final static String CLASSNAME="MAC";
	
	public Mac(){
			
			creationClassName=CLASSNAME;
	}
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_mac")
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
		return new StringBuffer().append(item).append(",mac = " + address)
				.toString();
	}
	
	public boolean equals(Object o){
		if (o instanceof Mac){
			if (this.address.replace(":", "-").equalsIgnoreCase(((Mac)o).getAddress().replace(":", "-")))
				return true;
		}
		return false;
	}
	 public int hashCode() {
	       return address.hashCode();
	          
	}
	
	 public Mac clone(){
			
		 Mac mac= new Mac();
			
		 mac.setCreationClassName(this.creationClassName);
		 mac.setDescription(this.description);
		 mac.setDisplayName(this.displayName);
		 mac.setName(this.name);
		 mac.setNetmask(this.netmask);
		 mac.setPackageSystem(this.packageSystem);
		 mac.setSerialNumber(this.serialNumber);
		 mac.setTag(this.tag);
		 mac.setAddress(this.address);	
			
			return mac;
		}
	

}
