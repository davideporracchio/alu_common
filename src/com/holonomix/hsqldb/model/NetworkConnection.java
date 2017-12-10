package com.holonomix.hsqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NETWORKCONNECTION")
public class NetworkConnection extends Item {

	public final static String CLASSNAME = "NetworkConnection";

	public NetworkConnection() {

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

	private Interface interfaceA;

	private Interface interfaceB;

	@Column(name = "type")
	private String type = "";

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String item = super.toString();
		return new StringBuffer().append(item).append(",name=" + name)
				.toString();
	}

	public boolean equals(Object o) {

		if (o instanceof NetworkConnection) {

			if (this.description.equalsIgnoreCase(((NetworkConnection) o).getDescription())) {

				return true;

			}

		}

		// System.out.println("compare cards: return false");

		return false;

	}

	public int hashCode() {
		return description.hashCode();
	}

	public NetworkConnection clone() {

		NetworkConnection interface1 = new NetworkConnection();

		interface1.setCreationClassName(this.creationClassName);
		interface1.setDescription(this.description);
		interface1.setDisplayName(this.displayName);

		interface1.setName(this.name);

		interface1.setPackageSystem(this.packageSystem);

		interface1.setSerialNumber(this.serialNumber);

		interface1.setTag(this.tag);
		interface1.setType(this.type);
		interface1.setAdminStatus(this.adminStatus);

		interface1.setOperStatus(this.operStatus);
		interface1.setInterfaceA(this.interfaceA);
		interface1.setInterfaceB(this.interfaceB);
		return interface1;
	}
}
