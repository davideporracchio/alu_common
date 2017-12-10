package com.holonomix.hsqldb.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
@MappedSuperclass
public abstract class Item {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		return true;
	}

	public enum Status {
		UPDATED, DELETED, ADDED, NOCHANGES,COMPLETED,ERROR;  
	}
	
	
	public Item(){
		super();
		this.setLastUpdated(new DateTime());
		this.setDateCreated(new DateTime());
		this.setVersion(0);
	}
	
	protected Status flagStatus;
	
	/** The date created. */
	@Basic
	@Column(name = "date_created", nullable = false, updatable = false)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	protected DateTime dateCreated;
	
	/** The last updated. */
	@Basic
	@Column(name = "last_updated", nullable = false)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	protected DateTime lastUpdated;
		
	
	/** The version. */
	@Basic
	@Version @Column( name="version",nullable=false )
	protected int version;
	
	@Basic
	@Column( name="creationClassName",nullable=false )
	protected String creationClassName;
	

	@Basic
	@Column(name = "name")
	protected String name="";

	@Basic
	@Column(name = "description")
	protected String description="";
	
	@Basic
	@Column(name = "displayName")
	protected String displayName="";
	
	@Basic
	@Column(name = "packageSystem")
	protected String packageSystem="";
	
	@Basic
	@Column(name = "serialNumber")
	protected String serialNumber="";
	
	@Basic
	@Column(name = "tag")
	protected String tag="";
		

	public String getCreationClassName() {
		return creationClassName;
	}

	public void setCreationClassName(String creationClassName) {
		this.creationClassName = creationClassName;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPackageSystem() {
		return packageSystem;
	}

	public void setPackageSystem(String packageSystem) {
		this.packageSystem = packageSystem;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	
	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	/**
	 * Gets the date created.
	 *
	 * @return the date created
	 */
	public DateTime getDateCreated() {
		return dateCreated;
	}
	
	/**
	 * Sets the date created.
	 *
	 * @param dateCreated the new date created
	 */
	public void setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	/**
	 * Gets the last updated.
	 *
	 * @return the last updated
	 */
	public DateTime getLastUpdated() {
		return lastUpdated;
	}
	
	public Status getFlagStatus() {
		return flagStatus;
	}

	public void setFlagStatus(Status flagStatus) {
		this.flagStatus = flagStatus;
	}

	/**
	 * Sets the last updated.
	 *
	 * @param lastUpdated the new last updated
	 */
	public void setLastUpdated(DateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
	
	return new StringBuffer().append("version=" + version).append(",dateCreated=" + dateCreated.toString("dd/MM/YYYY HH:mm:ss")).append(",lastUpdated=" + lastUpdated.toString("dd/MM/YYYY HH:mm:ss")).toString();
	}
	
	public void update(){
		 
		 version++;
		 lastUpdated=new DateTime();
	 }
	
	public abstract Item clone();
}
