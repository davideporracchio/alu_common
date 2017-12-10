package com.holonomix.hsqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALARM")
public class Alarm extends Item {

	public final static String CLASSNAME = "Alarm";

	public final static String KEYGENERICNUMBER = "6";
	public final static String KEYDEVICE = ".1.3.6.1.4.1.733.2014.10.1";
	public final static String KEYCOMPONENT = ".1.3.6.1.4.1.733.2014.10.2";
	public final static String KEYCOMPONENTTYPE = ".1.3.6.1.4.1.733.2014.10.3";
	public final static String KEYSEVERITY = ".1.3.6.1.4.1.733.2014.10.4";
	public final static String KEYCONDITION = ".1.3.6.1.4.1.733.2014.10.5";
	public final static String KEYSERVICEEFFECT = ".1.3.6.1.4.1.733.2014.10.6";
	public final static String KEYLOCATION = ".1.3.6.1.4.1.733.2014.10.7";

	public final static String KEYDIRECTION = ".1.3.6.1.4.1.733.2014.10.8";
	public final static String KEYDESCRIPTION = ".1.3.6.1.4.1.733.2014.10.9";
	public final static String KEYDEVICETYPE = ".1.3.6.1.4.1.733.2014.10.10";

	public final static String CRITICAL = "CRITICAL";
	public final static String MAJOR = "MAJOR";
	public final static String MINOR = "MINOR";
	public final static String WARNING = "WARNING";
	public final static String CLEARED = "CLEARED";

	public Alarm() {

		creationClassName = CLASSNAME;
	}

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_alarm")
	protected Long id;

	@Column(name = "oid")
	private String oid = "";

	@Column(name = "genericNumber")
	private String genericNumber = "";

	@Column(name = "specificNumber")
	private String specificNumber = "";

	@Column(name = "deviceName")
	private String deviceName = "";

	@Column(name = "deviceType")
	private String deviceType = "";

	@Column(name = "component")
	private String component = "";

	@Column(name = "componentType")
	private String componentType = "";

	@Column(name = "severity")
	private String severity = "";

	@Column(name = "condition")
	private String condition = "";

	@Column(name = "serviceEffect")
	private String serviceEffect = "";

	@Column(name = "location")
	private String location = "";

	@Column(name = "direction")
	private String direction = "";

	@Column(name = "description")
	private String description = "";

	@Column(name = "probableCause")
	private String probableCause = "";

	@Column(name = "probableCauseQualifier")
	private String probableCauseQualifier = "";

	@Column(name = "objectType")
	private String objectType = "";

	@Column(name = "ems")
	private String ems = "";

	@Column(name = "protocol")
	private String protocol = "";

	@Column(name = "isActive")
	private boolean isActive = true;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEms() {
		return ems;
	}

	public void setEms(String ems) {
		this.ems = ems;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getGenericNumber() {
		return genericNumber;
	}

	public void setGenericNumber(String genericNumber) {
		this.genericNumber = genericNumber;
	}

	public String getSpecificNumber() {
		return specificNumber;
	}

	public void setSpecificNumber(String specificNumber) {
		this.specificNumber = specificNumber;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSeverity() {
		return severity;
	}

	public String getSeverityText() {
		String sevText = "";
		if (severity.equalsIgnoreCase("1")) {
			sevText = Alarm.CRITICAL;
		} else if (severity.equalsIgnoreCase("2")) {
			sevText = Alarm.MAJOR;
		} else if (severity.equalsIgnoreCase("3")) {
			sevText = Alarm.MINOR;
		} else if (severity.equalsIgnoreCase("4")) {
			sevText = Alarm.WARNING;
		} else if (severity.equalsIgnoreCase("5")) {
			sevText = Alarm.CLEARED;
		}
		return sevText;
	}

	public void setSeverityText(String severity) {
		if (severity.toUpperCase().indexOf("CLEARED") != -1
				|| severity.equalsIgnoreCase("CL")
				|| severity.equalsIgnoreCase("RESTORE"))
			this.severity = "5";
		else if (severity.toUpperCase().indexOf("WARNING") != -1
				|| severity.equalsIgnoreCase("WA"))
			this.severity = "4";
		else if (severity.toUpperCase().indexOf("MINOR") != -1
				|| severity.equalsIgnoreCase("MN"))
			this.severity = "3";
		else if (severity.toUpperCase().indexOf("MAJOR") != -1
				|| severity.equalsIgnoreCase("MJ"))
			this.severity = "2";
		else if (severity.toUpperCase().indexOf("CRITICAL") != -1
				|| severity.equalsIgnoreCase("CR"))
			this.severity = "1";
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getServiceEffect() {
		return serviceEffect;
	}

	public String getServiceEffectText() {
		if (serviceEffect.equalsIgnoreCase("0"))
			return "SA";
		else
			return "NSA";
	}

	public void setServiceEffect(String serviceEffect) {
		this.serviceEffect = serviceEffect;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProbableCause() {
		return probableCause;
	}

	public void setProbableCause(String probableCause) {
		this.probableCause = probableCause;
	}

	public String getProbableCauseQualifier() {
		return probableCauseQualifier;
	}

	public void setProbableCauseQualifier(String probableCauseQualifier) {
		this.probableCauseQualifier = probableCauseQualifier;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {

		return new StringBuffer().append("deviceName=" + deviceName)
				.append(", component =" + component)
				.append(", componentType =" + componentType)
				.append(", condition =" + condition)
				.append(", probableCauseQualifier =" + probableCauseQualifier)
				.append(", severity =" + severity)
				.append(", serviceEffect =" + serviceEffect)
				.append(", specificNumber =" + specificNumber)
				.append(", deviceType =" + deviceType).toString();
	}

	public boolean equals(Object o) {
		if (o instanceof Alarm) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		return name.hashCode();

	}

	public Alarm clone() {

		Alarm alarm = new Alarm();
		alarm.setDeviceName(this.deviceName);

		alarm.setCondition(this.condition);
		alarm.setProbableCauseQualifier(this.probableCauseQualifier);
		alarm.setSeverity(this.severity);
		alarm.setServiceEffect(this.serviceEffect);
		alarm.setComponent(this.component);
		alarm.setComponentType(this.componentType);
		alarm.setSpecificNumber(this.specificNumber);
		alarm.setCreationClassName(this.creationClassName);
		alarm.setDescription(this.description);
		alarm.setDisplayName(this.displayName);
		alarm.setName(this.name);
		alarm.setPackageSystem(this.packageSystem);
		alarm.setSerialNumber(this.serialNumber);
		alarm.setTag(this.tag);
		alarm.setDeviceType(this.deviceType);
		alarm.setActive(this.isActive);
		alarm.setDateCreated(this.dateCreated);
		alarm.setDirection(this.direction);
		alarm.setEms(this.ems);
		alarm.setFlagStatus(this.flagStatus);
		alarm.setGenericNumber(this.genericNumber);
		alarm.setId(this.id);
		alarm.setLocation(this.location);
		alarm.setObjectType(this.objectType);
		alarm.setOid(this.oid);
		alarm.setProbableCause(this.probableCause);
		alarm.setProtocol(this.protocol);
		alarm.setSeverityText(this.getSeverityText());
		alarm.setTag(this.tag);
		alarm.setVersion(this.version);

		return alarm;
	}

}
