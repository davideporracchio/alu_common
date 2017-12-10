
package com.holonomix.monitor;

// Java classes.

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.swing.event.EventListenerList;

/**
 * This is the default implementation of the <tt>ActiveMap</tt> interface. By
 * default it is implemented by an <tt>ArrayList</tt>.
 * The implementation can be delegated to a <tt>List</tt> instance. In this
 * case the list behaves like a <i>Decorator</i> of the given list.
 * All methods implementing the <tt>List</tt> interface are thread-safe and they
 * all guarantee safe synchronization using the read/write lock available throw
 * the method <tt>getReadWriteLock</tt>.
 */
public class MapMonitor implements ActiveMap {
    
    /* /////////////////////////////////////////////////////////////////////////
     * Private variables.
     */
    private static MapMonitor mapMonitor;
    /** True if the list can send events, false otherwise. */
    private boolean activated;
    
    /** Lock to allow multithreaded access to the list data. */
    private ReadWriteLock lock;
    
    /** The list of all registered listener. */
    private EventListenerList listenerList;
    
    /**
     * The internal representation of the list. By default the list is
     * implemented by an <tt>ArrayList</tt>.
     */
    protected Map<String,String> map;
    
    /* /////////////////////////////////////////////////////////////////////////
     * Constructors and initializing methods.
     */
    
    /** Default constructor. */
    private MapMonitor() {
        this.map = new HashMap<String,String>(); // Default implementation.
        init();
    }
    
    public static MapMonitor getInstance(){
    	if (mapMonitor==null)
    		mapMonitor=new MapMonitor();
    	return mapMonitor;
    }
    
    
    /**
     * Decorate the given list to make it firing events when modified.
     * @param list The list to be decorated.
     */   
    public MapMonitor(Map<String,String>  map) {
        this.map = map;
        init();
    }
    
    /** Initialization methods containing common initialization tasks. */
    private void init() {
        activated = true;
        lock = new ReentrantReadWriteLock();
        listenerList = new EventListenerList();
    }
    
    /* /////////////////////////////////////////////////////////////////////////
     * ActiveMap interface implementation.
     */
    
    /** {@inheritDoc} */
    public ReadWriteLock getReadWriteLock() {
        return lock;
    }
    
    /** {@inheritDoc} */
    public void addActiveMapListener(ActiveMapListener listener) {
        listenerList.add(ActiveMapListener.class, listener);
    }
    
    /** {@inheritDoc} */
    public void removeActiveMapListener(ActiveMapListener listener) {
        listenerList.remove(ActiveMapListener.class, listener);
    }
    
    /** {@inheritDoc} */
    public void setActive(boolean activated) {
        this.activated = activated;
    }
    
    /** {@inheritDoc} */
    public boolean isActive() {
        return activated;
    }
    
    /** {@inheritDoc} */
    public void fireContentsChanged(ActiveMapEvent event) {
        
        // Guaranteed to return a non-null array.

        Object[] listeners = listenerList.getListenerList();

        // Process the listeners last to first, notifying those that are
        // interested in this event.

        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ActiveMapListener.class) {
                ((ActiveMapListener) listeners[i+1])
                    .contentsChanged(event);
            }          
        }
    }
    
   
   
    /** 
     * This method is thread-safe.
     * {@inheritDoc} 
     */
    public String get(String key) {
        
        try {
            lock.readLock().lock();
            if (map.containsKey(key)){
            return map.get(key);
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }
    }
   
   
    /** 
     * This method is thread-safe.
     * {@inheritDoc} 
     */
    public boolean put(String key, String value) {
        
        try {
            lock.writeLock().lock();
            map.put(key, value);
           
            if (activated) {
                ActiveMapEvent event = new ActiveMapEvent(this);
                event.setEventName(key);
                fireContentsChanged(event);
            }
            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    /** 
     * This method is thread-safe.
     * {@inheritDoc} 
     */
    public int size() {
        
        try {
            lock.readLock().lock();

            return map.size();
        } finally {
            lock.readLock().unlock();
        }
    }
    
   
    
    /* /////////////////////////////////////////////////////////////////////////
     * Embedded classes.
     */
    
    /**
     * This is an <tt>ActiveMap</tt> <tt>Iterator</tt> sending events when
     * items are removed from or added to the embedded list being iterated.
     */
    @SuppressWarnings("hiding")
    private class ActiveMapIterator<E> implements Iterator<E> {

        /**
         * The iterator of the list implementation wrapped by the
         * <tt>ActiveMap</tt>.
         */
        private Iterator<E> iterator;

        /** Index of element to be returned by subsequent call to next. */
        protected int index;
        
        /**
         * Constructor.
         * @param iterator The iterator of the list wrapped by the current
         *     <tt>ActiveMap</tt>.
         */
        public ActiveMapIterator(Iterator<E> iterator) {

            if (iterator == null) {
                String msg = "Decorated iterator cannot be null!";
                throw new IllegalArgumentException(msg);
            }
            this.iterator = iterator;
            this.index = 0;
        }

        /* /////////////////////////////////////////////////////////////////////
         * Iterator interface implementation.
         */

        /** {@inheritDoc} */
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /** {@inheritDoc} */
        public E next() {
            E element = iterator.next();
            index++;
            return element;
        }

        /**
         * Remove the current list element and send an event to all registered
         * listeners.
         */
        public void remove() {

            iterator.remove();
            
            ActiveMapEvent event = new ActiveMapEvent(map);
            
           
            
           
            
            fireContentsChanged(event);
        }
    }
    
    
}