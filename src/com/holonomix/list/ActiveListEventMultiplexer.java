

package com.holonomix.list;

// Java classes.

import javax.swing.event.EventListenerList;


public class ActiveListEventMultiplexer implements ActiveListListener {

    /* /////////////////////////////////////////////////////////////////////////
     * Private variables.
     */
    
    /** The list of all registered listener. */
    private EventListenerList listenerList;
    
    /* /////////////////////////////////////////////////////////////////////////
     * ActiveListListener interface implementation.
     */
    
    /** {@inheritDocs} */
    public void contentsChanged(ActiveListEvent event) {
        fireContentsChanged(event);
    }
    
    /* /////////////////////////////////////////////////////////////////////////
     * Event management.
     */
    
    /** {@inheritDoc} */
    public void addActiveListListener(ActiveListListener listener) {
        listenerList.add(ActiveListListener.class, listener);
    }
    
    /** {@inheritDoc} */
    public void removeActiveListListener(ActiveListListener listener) {
        listenerList.remove(ActiveListListener.class, listener);
    }
    
    /** {@inheritDoc} */
    public void fireContentsChanged(ActiveListEvent event) {
        
        // Guaranteed to return a non-null array.

        Object[] listeners = listenerList.getListenerList();

        // Process the listeners last to first, notifying those that are
        // interested in this event.

        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ActiveListListener.class) {
                ((ActiveListListener) listeners[i+1])
                    .contentsChanged(event);
            }          
        }
    }
}