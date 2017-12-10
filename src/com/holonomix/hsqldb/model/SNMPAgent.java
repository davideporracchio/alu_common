package com.holonomix.hsqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SNMPAGENT")
public class SNMPAgent extends Item {
	
	public final static String CLASSNAME="SNMPAgent";
	
	public SNMPAgent(){
		
		creationClassName=CLASSNAME;
	}
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_snmpagent")
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
		return new StringBuffer().append(item).append(",name = " + name)
				.toString();
	}
	
	public boolean equals(Object o){
		if (o instanceof SNMPAgent){
			if (this.name.equalsIgnoreCase(((SNMPAgent)o).getName()))
				return true;
		}
		return false;
	}
	 public int hashCode() {
	       return name.hashCode();
	          
	}
	 
	 public SNMPAgent clone(){
			
		 SNMPAgent snmpagent= new SNMPAgent();
			
		 snmpagent.setCreationClassName(this.creationClassName);
		 snmpagent.setDescription(this.description);
		 snmpagent.setDisplayName(this.displayName);
		 snmpagent.setName(this.name);
		 snmpagent.setPackageSystem(this.packageSystem);
		 snmpagent.setSerialNumber(this.serialNumber);
		 snmpagent.setTag(this.tag);
			
			
			return snmpagent;
		}
	
}
