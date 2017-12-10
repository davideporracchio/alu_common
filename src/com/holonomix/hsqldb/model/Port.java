package com.holonomix.hsqldb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PORT")
public class Port extends Item {

	public final static String CLASSNAME = "Port";

	public final static String DEFAULTTYPE = "ETHERNETCSMACD";

	public final static String DEFAULTPORTTYPE = "ACCESS";

	public Port() {

		creationClassName = CLASSNAME;

		portType = DEFAULTPORTTYPE;

		type = DEFAULTTYPE;

	}

	/** The id. */

	@Id
	@GeneratedValue
	@Column(name = "id_port")
	protected Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PORT_VLAN", joinColumns = { @JoinColumn(name = "id_port") }, inverseJoinColumns = { @JoinColumn(name = "id_vlan") })
	private Set<VLan> vlanList;

	@Column(name = "rackNumber")
	private String rackNumber = "";

	@Column(name = "shelfNumber")
	private String shelfNumber = "";

	@Column(name = "slotNumber")
	private String slotNumber = "";

	@Column(name = "subSlotNumber")
	private String subSlotNumber = "";

	@Column(name = "portNumber")
	private String portNumber = "";

	@Column(name = "subPortNumber")
	private String subPortNumber = "";

	@Column(name = "portType")
	private String portType = "";

	@Column(name = "portKey")
	private String portKey = "";

	@Column(name = "maxSpeed")
	private String maxSpeed = "0";

	@Column(name = "systemModel")
	private String systemModel = "";

	@Column(name = "type")
	private String type = "";

	@Column(name = "adminStatus")
	private String adminStatus = "";

	@Column(name = "operStatus")
	private String operStatus = "";

	public Set<VLan> getVlanList() {
		if (vlanList == null) {
			vlanList = new HashSet<VLan>();
		}
		return vlanList;
	}

	public void setVlanList(Set<VLan> vlanList) {
		vlanList = vlanList;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String operStatus) {
		this.adminStatus = operStatus;
	}

	public String getOperStatus() {
		return operStatus;
	}

	public void setOperStatus(String operStatus) {
		this.operStatus = operStatus;
	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getShelfNumber() {

		return shelfNumber;

	}

	public void setShelfNumber(String shelfNumber) {

		this.shelfNumber = shelfNumber;

	}

	public String getSlotNumber() {

		return slotNumber;

	}

	public void setSlotNumber(String slotNumber) {

		this.slotNumber = slotNumber;

	}

	public String getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(String rackNumber) {
		this.rackNumber = rackNumber;
	}

	public String getPortNumber() {

		return portNumber;

	}

	public void setPortNumber(String portNumber) {

		this.portNumber = portNumber;

	}

	public String getPortType() {

		return portType;

	}

	public void setPortType(String portType) {

		this.portType = portType;

	}

	public String getPortKey() {

		return portKey;

	}

	public void setPortKey(String portKey) {

		this.portKey = portKey;

	}

	public String getMaxSpeed() {

		return maxSpeed;

	}

	public void setMaxSpeed(String maxSpeed) {
		if (maxSpeed != null && !maxSpeed.equalsIgnoreCase("")
				&& !maxSpeed.equalsIgnoreCase("--")) {
			if (maxSpeed.indexOf("M") != -1) {
				maxSpeed = maxSpeed.replace("M", "000000");
			} else if (maxSpeed.indexOf("GB") != -1
					&& maxSpeed.indexOf(".") != -1) {
				maxSpeed = maxSpeed.replace("GB", "00000");
				maxSpeed = maxSpeed.replace(".", "");
			} else if (maxSpeed.indexOf("GB") != -1
					&& maxSpeed.indexOf(".") == -1) {
				maxSpeed = maxSpeed.replace("GB", "000000");
			}
			this.maxSpeed = maxSpeed;
		}
		try {
			Integer.parseInt(this.maxSpeed);

		} catch (Exception e) {
			this.maxSpeed = "0";
		}

	}

	public String getSystemModel() {

		return systemModel;

	}

	public void setSystemModel(String systemModel) {

		this.systemModel = systemModel;

	}

	public String getType() {

		return type;

	}

	public void setType(String type) {

		this.type = type;

	}

	public String getSubSlotNumber() {
		return subSlotNumber;
	}

	public void setSubSlotNumber(String subSlotNumber) {
		this.subSlotNumber = subSlotNumber;
	}

	public String getSubPortNumber() {
		return subPortNumber;
	}

	public void setSubPortNumber(String subPortNumber) {
		this.subPortNumber = subPortNumber;
	}

	@Override
	public String toString() {

		String item = super.toString();

		return new StringBuffer().append(item).append(",name=" + name)

		.toString();

	}

	public boolean equals(Object o) {

		if (o instanceof Port) {

			if (this.rackNumber.equalsIgnoreCase(((Port) o).getRackNumber())
					&&
					
					this.shelfNumber.equalsIgnoreCase(((Port) o).getShelfNumber())
					&&

					this.slotNumber
							.equalsIgnoreCase(((Port) o).getSlotNumber())
					&&

					this.subSlotNumber.equalsIgnoreCase(((Port) o)
							.getSubSlotNumber())
					&&

					this.portNumber
							.equalsIgnoreCase(((Port) o).getPortNumber())
					&&

					this.subPortNumber.equalsIgnoreCase(((Port) o)
							.getSubPortNumber())) {

				// System.out.println("compare cards: return true");

				return true;

			}

		}

		// System.out.println("compare cards: return false");

		return false;

	}

	public int hashCode() {

		return portKey.hashCode();

	}

	public void splitName(String smartName) {

		String portName = smartName;

		if (portName.contains(".")) {

			subPortNumber = portName.substring(portName.lastIndexOf(".") + 1);

			portName = portName.substring(0, portName.lastIndexOf("."));
		}

		if (portName.contains("/")) {
			String split[] = portName.split("/");

			if (split.length == 3) {

				shelfNumber = split[0];

				slotNumber = split[1];

				portNumber = split[2];

			}

			if (split.length == 4) {

				shelfNumber = split[0];

				slotNumber = split[1];

				subSlotNumber = split[2];

				portNumber = split[3];

			}

		}

	}
	
	public void splitNameWithRack(String smartName) {

		String portName = smartName;

		if (portName.contains(".")) {

			subPortNumber = portName.substring(portName.lastIndexOf(".") + 1);

			portName = portName.substring(0, portName.lastIndexOf("."));
		}

		if (portName.contains("/")) {
			String split[] = portName.split("/");

			if (split.length == 4) {

				rackNumber = split[0];
				
				shelfNumber = split[1];

				slotNumber = split[2];

				portNumber = split[3];

			}

			if (split.length == 5) {
				rackNumber = split[0];
				
				shelfNumber = split[1];

				slotNumber = split[2];

				subSlotNumber = split[3];

				portNumber = split[4];

			}

		}

	}

	public String getNameForSmarts() {

		StringBuffer name = new StringBuffer();
		if (!rackNumber.equalsIgnoreCase("")) {
			name.append(rackNumber).append("/");
		}
		name.append(shelfNumber).append("/").append(slotNumber);
		if (!subSlotNumber.equalsIgnoreCase("")) {
			name.append("/").append(subSlotNumber);
		}
		name.append("/").append(portNumber);
		if (!subPortNumber.equalsIgnoreCase("")) {
			name.append(".").append(subPortNumber);
		}
		return name.toString();
	}

	public Port clone() {

		Port port = new Port();
		port.setAdminStatus(this.adminStatus);
		port.setCreationClassName(this.creationClassName);
		port.setDescription(this.description);
		port.setDisplayName(this.displayName);
		port.setMaxSpeed(this.maxSpeed);
		port.setName(this.name);
		port.setOperStatus(this.operStatus);
		port.setPackageSystem(this.packageSystem);
		port.setPortKey(this.portKey);
		port.setPortNumber(this.portNumber);
		port.setPortType(this.portType);
		port.setSubPortNumber(this.subPortNumber);
		port.setSubSlotNumber(this.subSlotNumber);
		port.setSerialNumber(this.serialNumber);
		port.setRackNumber(this.rackNumber);
		port.setShelfNumber(this.shelfNumber);
		port.setSlotNumber(this.slotNumber);
		port.setSystemModel(this.systemModel);
		port.setTag(this.tag);
		port.setType(this.type);
		if (this.vlanList != null)
			for (VLan vlan : this.vlanList) {

				port.getVlanList().add((VLan) vlan.clone());
			}
		return port;
	}

}
