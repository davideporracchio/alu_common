
package com.holonomix.list;

// Java classes.

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Any list allowing concurrent modifications and firing events must implement
 * this interface.
 */
public interface ActiveList<E> extends List<E> {
    
    /** The read/write lock used to allow concurrency. */
    public ReadWriteLock getReadWriteLock();
    
    /** 
     * Register a new event listener.
     * @param listener The new event listener.
     */
    public void addActiveListListener(ActiveListListener listener);
    
    /** 
     * Remove a previously registered event listener.
     * @param listener The previously registered event listener.
     */
    public void removeActiveListListener(ActiveListListener listener); 
    
    /**
     * Activate or deactivate the list: while a list is active it sends events
     * to all registered listener. This method can be used to avoid performance
     * problems when heavily working on the list.
     * @param active True if the list can send events, false otherwise.
     */
    public void setActive(boolean activated);
    
    /**
     * Return true if the list is activated, false otherwise.
     * @return True if the list is activated, false otherwise.
     */
    public boolean isActive();
    
    /**
     * Manually notify all registered listeners with the given event. This is
     * useful to better control the performance of the model.
     * @param event The event containing information about changes occurred
     *     inside the list.
     */
    public void fireContentsChanged(ActiveListEvent event);
}