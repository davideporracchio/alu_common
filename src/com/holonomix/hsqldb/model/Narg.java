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
@Table(name = "NARG")
public class Narg extends Item {

	public final static String CLASSNAME = "NetworkAdapterRedundancyGroup";

	public Narg() {

		creationClassName = CLASSNAME;
	}

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_networkConnection")
	protected Long id;

	@Column(name = "admin_status")
	private String adminStatus;

	@Column(name = "oper_status")
	private String operStatus;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "NARG_INTERFACE", joinColumns = { @JoinColumn(name = "id_narg") }, inverseJoinColumns = { @JoinColumn(name = "id_interface") })
	private Set<Interface> interfaceList;

	public Set<Interface> getInterfaceList() {
		if (interfaceList==null){
			interfaceList=new HashSet<Interface>();
		}
		return interfaceList;
	}

	public void setInterfaceList(Set<Interface> interfaceList) {
		this.interfaceList = interfaceList;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	

	@Override
	public String toString() {
		String item = super.toString();
		return new StringBuffer().append(item).append(",name=" + name)
				.toString();
	}

	public boolean equals(Object o) {

		if (o instanceof Narg) {

			if (this.name.equalsIgnoreCase(((Narg) o).getName())) {

				return true;

			}

		}

		// System.out.println("compare cards: return false");

		return false;

	}

	public int hashCode() {
		return name.hashCode();
	}

	public Narg clone() {

		Narg narg = new Narg();

		narg.setCreationClassName(this.creationClassName);
		narg.setDescription(this.description);
		narg.setDisplayName(this.displayName);

		narg.setName(this.name);

		narg.setPackageSystem(this.packageSystem);

		narg.setSerialNumber(this.serialNumber);

		narg.setTag(this.tag);
		
		narg.setAdminStatus(this.adminStatus);

		narg.setOperStatus(this.operStatus);
		
		for (Interface interface1:this.interfaceList){
			
			narg.getInterfaceList().add((Interface)interface1.clone());
		}
	
		return narg;
	}
}
