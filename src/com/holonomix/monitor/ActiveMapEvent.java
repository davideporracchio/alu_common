

package com.holonomix.monitor;
// Java classes.

import java.util.EventObject;

/**
 * Event thrown by any <tt>EventList</tt>.
 */
public class ActiveMapEvent extends EventObject implements Cloneable {
    
    /** Class serial number. */
    private final static long serialVersionUID = 42L;
    
    
    private String eventName;
    
    /* /////////////////////////////////////////////////////////////////////////
     * Constructors.
     */
    
    /** Constructor. */
    public ActiveMapEvent(Object source) {
        super(source);
    }

    /* /////////////////////////////////////////////////////////////////////////
     * Getter and setter methods.
     */
    
   
      
    
    

    /* /////////////////////////////////////////////////////////////////////////
     * Cloneable interface implementation.
     */
    
    /** {@inheritDoc} */
    @Override
    public Object clone() {
        ActiveMapEvent event = new ActiveMapEvent(this.getSource());
        event.setEventName(this.eventName);
        
        return event;
    }
    
    /* /////////////////////////////////////////////////////////////////////////
     * Object class overriding methods.
     */
    
    public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/** {@inheritDoc} */
    @Override
    public String toString() {
        
       
        
           
        
                
        String out = super.toString()
            .concat("[")
            .concat("eventName=" + eventName + "]");
           
        return out;
    }    
}
