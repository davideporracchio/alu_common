package com.holonomix.hsqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHASSIS")
public class Chassis extends Item {

public final static String CLASSNAME="Chassis";
	
	public Chassis(){
		
		creationClassName=CLASSNAME;
	}
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_chassis")
	protected Long id;
	
			
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
		if (o instanceof Chassis){
			if (this.name.equalsIgnoreCase(((Chassis)o).getName()) ||
			this.name.equalsIgnoreCase(((Chassis)o).getName().replace("CHASSIS-","")))
				return true;
		}
		return false;
	}
	 public int hashCode() {
	       return name.hashCode();
	          
	}
	 
	 public Chassis clone(){
			
		 Chassis chassis= new Chassis();
			
		 chassis.setCreationClassName(this.creationClassName);
		 chassis.setDescription(this.description);
		 chassis.setDisplayName(this.displayName);
			
		 chassis.setName(this.name);
			
		 chassis.setPackageSystem(this.packageSystem);
			
		 
		 chassis.setSerialNumber(this.serialNumber);
		
			
		 chassis.setTag(this.tag);
		
		
		return chassis;
		}

	
}
