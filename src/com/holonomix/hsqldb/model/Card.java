package com.holonomix.hsqldb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARD")
public class Card extends Item  implements Comparable<Card> {

	public final static String CLASSNAME = "Card";

	public Card() {

		creationClassName = CLASSNAME;

	}

	/** The id. */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_card")
	protected Long id;

	@Column(name = "type")
	private String type = "";
	
	@Column(name = "location")
	private String location = "";

	@Column(name = "status")
	private String status = "";
	
	@Column(name = "rackNumber")
	private String rackNumber = "";
	
	@Column(name = "shelfNumber")
	private String shelfNumber = "";

	@Column(name = "slotNumber")
	private String slotNumber = "";

	@Column(name = "subSlotNumber")
	private String subSlotNumber = "";

	private int numberPort =0;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, targetEntity = Port.class)
	@org.hibernate.annotations.Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@org.hibernate.annotations.IndexColumn(name = "id_card")
	private Set<Port> portList;

	
	
	public String getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(String rackNumber) {
		this.rackNumber = rackNumber;
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
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {

		return type;

	}

	public void setType(String type) {

		this.type = type;

	}

	public Set<Port> getPortList() {

		if (portList == null) {

			portList = new HashSet<Port>();

		}

		return portList;

	}

	public void setPortList(Set<Port> portList) {

		this.portList = portList;

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getSubSlotNumber() {
		return subSlotNumber;
	}

	public void setSubSlotNumber(String subSlotNumber) {
		this.subSlotNumber = subSlotNumber;
	}
	

	public int getNumberPort() {
		return numberPort;
	}

	public void setNumberPort(int numberPort) {
		this.numberPort = numberPort;
	}

	@Override
	public String toString() {

		String item = super.toString();

		return new StringBuffer().append(item).append(",name=" + name)

		.toString();

	}

	public boolean equals(Object o) {

		if (o instanceof Card) {

			if (this.rackNumber.equalsIgnoreCase(((Card) o).getRackNumber())
					&&
					this.shelfNumber.equalsIgnoreCase(((Card) o).getShelfNumber())
					&&

					this.slotNumber
							.equalsIgnoreCase(((Card) o).getSlotNumber())
					&&

					this.subSlotNumber.equalsIgnoreCase(((Card) o)
							.getSubSlotNumber()))

				return true;

		}

		return false;

	}

	public int hashCode() {

		return name.hashCode();

	}

	public void splitName(String smartName) {

		if (smartName.contains("/")) {

			String split[] = smartName.split("/");

			if (split.length == 2) {

				shelfNumber = split[0];

				slotNumber = split[1];
			}
			if (split.length == 3) {

				shelfNumber = split[0];

				slotNumber = split[1];

				subSlotNumber = split[2];
			}
		}

	}
	
	public void splitNameWithRack(String smartName) {

		if (smartName.contains("/")) {

			String split[] = smartName.split("/");

			if (split.length == 3) {

				rackNumber= split[0];
				
				shelfNumber = split[1];

				slotNumber = split[2];
			}
			if (split.length == 4) {

				rackNumber= split[0];
				
				shelfNumber = split[1];

				slotNumber = split[2];

				subSlotNumber = split[3];
			}
		}

	}

	public String getNameForSmarts(boolean subport) {

		StringBuffer name = new StringBuffer();
		if (!rackNumber.equalsIgnoreCase("")) {
			name.append(rackNumber).append("/");
		}
		name.append(shelfNumber).append("/").append(slotNumber);
		if(subport){
			if (!subSlotNumber.equalsIgnoreCase(""))
				name.append("/").append(subSlotNumber);
		}
		return name.toString();
	}

	public Card clone() {

		Card card = new Card();

		card.setCreationClassName(this.creationClassName);
		card.setDescription(this.description);
		card.setDisplayName(this.displayName);
		//card.setId(this.id);
		card.setName(this.name);
		card.setLocation(this.location);
		card.setPackageSystem(this.packageSystem);
		card.setRackNumber(this.rackNumber);
		card.setSerialNumber(this.serialNumber);
		card.setShelfNumber(this.shelfNumber);
		card.setSlotNumber(this.slotNumber);
		card.setSubSlotNumber(this.subSlotNumber);
		card.setStatus(this.status);
		card.setNumberPort(this.numberPort);
		card.setTag(this.tag);
		card.setType(this.type);
		if (this.portList != null)
			for (Port port : this.portList) {

				card.getPortList().add((Port) port.clone());
			}
		return card;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(Card arg0) {
		
		 return this.getNameForSmarts(true).compareTo(arg0.getNameForSmarts(true));
	}
}
