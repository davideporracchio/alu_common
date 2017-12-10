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
@Table(name = "IONIX")
public class Ionix extends Item {
	
	public final static String CLASSNAME="IONIX";
	public final static String PARTIALIMPORT="PARTIALIMPORT";
	public final static String COMPLETEIMPORT="COMPLETEIMPORT";
	
	public Ionix(){
			
			creationClassName=CLASSNAME;
	}
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_ionix")
	protected Long id;

		
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "IONIX_IPAM", joinColumns = { @JoinColumn(name = "id_ionix") }, inverseJoinColumns = { @JoinColumn(name = "id_ipam") })
	private Set<Ipam> ipamList;

	
	public Set<Ipam> getIpamList() {
		if (ipamList==null)
			ipamList=new HashSet<Ipam>();
		return ipamList;
	}

	public void setIpamList(Set<Ipam> ipamList) {
		this.ipamList = ipamList;
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
	
	public boolean equals(Object o){
		if (o instanceof Ionix){
			if (this.name.equalsIgnoreCase(((Ionix)o).getName()))
				return true;
		}
		return false;
	}
	 public int hashCode() {
	       return name.hashCode();
	          
	}
	 
	 public Ionix clone(){
			
			Ionix ionix= new Ionix();
			
			ionix.setCreationClassName(this.creationClassName);
			ionix.setDescription(this.description);
			ionix.setDisplayName(this.displayName);
			
			ionix.setName(this.name);
			
			ionix.setPackageSystem(this.packageSystem);
			
			
			ionix.setSerialNumber(this.serialNumber);
			
			
			ionix.setTag(this.tag);
			
			for (Ipam ipam:this.ipamList){
				
				ionix.getIpamList().add((Ipam)ipam.clone());
			}
			return ionix;
		}
}
