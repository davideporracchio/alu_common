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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GLOBALTOPOLOGYCOLLECTION")
public class GlobalTopologyCollection extends Item {

	public final static String CLASSNAME = "Global_TopologyCollection";

	public GlobalTopologyCollection() {

		creationClassName = CLASSNAME;

	}

	/** The id. */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_global")
	protected Long id;

	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "GLOBAL_INTERFACE", joinColumns = { @JoinColumn(name = "id_global") }, inverseJoinColumns = { @JoinColumn(name = "id_interface") })
	private Set<Interface> interfaceList;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "GLOBAL_CARD", joinColumns = { @JoinColumn(name = "id_global") }, inverseJoinColumns = { @JoinColumn(name = "id_card") })
	private Set<Card> cardList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "GLOBAL_PORT", joinColumns = { @JoinColumn(name = "id_global") }, inverseJoinColumns = { @JoinColumn(name = "id_port") })
	private Set<Port> portList;

	
	public Set<Port> getPortList() {

		if (portList == null) {

			portList = new HashSet<Port>();

		}

		return portList;

	}

	public void setInterfaceList(Set<Interface> interfaceList) {

		this.interfaceList = interfaceList;

	}
	
	public Set<Interface> getInterfaceList() {

		if (interfaceList == null) {

			interfaceList = new HashSet<Interface>();

		}

		return interfaceList;

	}

	public void setPortList(Set<Port> portList) {

		this.portList = portList;

	}
	

	
	public Set<Card> getCardList() {
		if (cardList==null){
			cardList=new HashSet<Card>();
		}
		return cardList;
	}

	public void setCardList(Set<Card> cardList) {
		this.cardList = cardList;
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

	public boolean equals(Object o) {

		if (o instanceof GlobalTopologyCollection) {

			if (this.name.equalsIgnoreCase(((GlobalTopologyCollection) o).getName()))
					
				return true;

		}

		return false;

	}

	public int hashCode() {

		return name.hashCode();

	}

	

	public GlobalTopologyCollection clone() {

		GlobalTopologyCollection global = new GlobalTopologyCollection();

		global.setCreationClassName(this.creationClassName);
		global.setDescription(this.description);
		global.setDisplayName(this.displayName);

		global.setName(this.name);

		global.setPackageSystem(this.packageSystem);

		global.setSerialNumber(this.serialNumber);
		
		global.setTag(this.tag);
		
		if (this.portList != null)
			for (Port port : this.portList) {

				global.getPortList().add((Port) port.clone());
			}
		
		if (this.interfaceList != null)
			for (Interface inter : this.interfaceList) {

				global.getInterfaceList().add((Interface) inter.clone());
			}
		
		if (this.cardList != null)
			for (Card card : this.cardList) {

				global.getCardList().add((Card) card.clone());
			}
		return global;
	}

	
}
