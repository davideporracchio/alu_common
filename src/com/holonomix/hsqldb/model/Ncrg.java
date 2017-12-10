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
@Table(name = "NCRG")
public class Ncrg extends Item {

	public final static String CLASSNAME = "NetworkConnectionRedundancyGroup";

	public Ncrg() {

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
	@JoinTable(name = "NCRG_NETWORKCONNECTION", joinColumns = { @JoinColumn(name = "id_narg") }, inverseJoinColumns = { @JoinColumn(name = "id_networkconnection") })
	private Set<NetworkConnection> networkConnectionList;

	public Set<NetworkConnection> getNetworkConnectionList() {
		if (networkConnectionList==null){
			networkConnectionList=new HashSet<NetworkConnection>();
		}
		return networkConnectionList;
	}

	public void setNetworkConnectionList(Set<NetworkConnection> networkConnectionList) {
		this.networkConnectionList = networkConnectionList;
	}
	

	private Interface interfaceA;

	private Interface interfaceB;
	
	public Interface getInterfaceA() {
		return interfaceA;
	}

	public void setInterfaceA(Interface interfaceA) {
		this.interfaceA = interfaceA;
	}

	public Interface getInterfaceB() {
		return interfaceB;
	}

	public void setInterfaceB(Interface interfaceB) {
		this.interfaceB = interfaceB;
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

		if (o instanceof Ncrg) {

			int size = networkConnectionList.size();
			int foundEquals= 0;
			if(networkConnectionList.size()==((Ncrg) o).getNetworkConnectionList().size()){
				for (NetworkConnection n1 :networkConnectionList){
					for (NetworkConnection n2 :((Ncrg) o).getNetworkConnectionList()){
						if (n1.equals(n2)){
							foundEquals++;
						}
					}
				}
				if (size==foundEquals)
					return true;
				
			}
			//if (this.name.equalsIgnoreCase(((Ncrg) o).getName())) {

			//	return true;

			//}

		}

		// System.out.println("compare cards: return false");

		return false;

	}

	public int hashCode() {
		return description.hashCode();
	}

	public Ncrg clone() {

		Ncrg narg = new Ncrg();

		narg.setCreationClassName(this.creationClassName);
		narg.setDescription(this.description);
		narg.setDisplayName(this.displayName);

		narg.setName(this.name);

		narg.setPackageSystem(this.packageSystem);

		narg.setSerialNumber(this.serialNumber);

		narg.setTag(this.tag);
		
		narg.setAdminStatus(this.adminStatus);

		narg.setOperStatus(this.operStatus);
		
		for (NetworkConnection networkConnection:this.networkConnectionList){
			
			narg.getNetworkConnectionList().add((NetworkConnection)networkConnection.clone());
		}
	
		return narg;
	}
}
