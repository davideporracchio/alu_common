

package com.holonomix.list;

// Java classes.

import java.util.EventListener;


public interface ActiveListListener extends EventListener {
    
    /**
     * Fired when the contents of the list has changed, an interval has been
     * inserted in the data model or removed from the data model.
     * @param event The event containing all information about the model
     *     change.
     */
    public void contentsChanged(ActiveListEvent event);
}
