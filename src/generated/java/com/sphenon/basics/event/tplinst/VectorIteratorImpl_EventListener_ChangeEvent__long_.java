// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIteratorImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class VectorIteratorImpl_EventListener_ChangeEvent__long_
    implements IteratorItemIndex_EventListener_ChangeEvent__long_,
               Cloneable
{
    private ReadOnlyVector_EventListener_ChangeEvent__long_ vector;
    private long current_index;

    public VectorIteratorImpl_EventListener_ChangeEvent__long_ (CallContext context, ReadOnlyVector_EventListener_ChangeEvent__long_ vector) {
        this.vector = vector;
        this.current_index = 0;
    }

    public void     next          (CallContext context) {
        // if (this.current_index < this.vector.getSize(context))
           this.current_index++;
    }

    public long getCurrentIndex (CallContext context) throws DoesNotExist {
        return this.current_index;
    }

    public long tryGetCurrentIndex (CallContext context) {
        return this.current_index;
    }

    public EventListener_ChangeEvent_ getCurrent    (CallContext context) throws DoesNotExist {
        return vector.get(context, this.current_index);
    }

    public EventListener_ChangeEvent_ tryGetCurrent (CallContext context) {
        return vector.tryGet(context, this.current_index);
    }

    public boolean  canGetCurrent (CallContext context) {
        return vector.canGet(context, this.current_index);
    }

    public Reference_EventListener_ChangeEvent__ getReferenceToCurrent (CallContext context) throws DoesNotExist {
        return vector.getReference(context, this.current_index);
    }

    public Reference_EventListener_ChangeEvent__ tryGetReferenceToCurrent (CallContext context) {
        return vector.tryGetReference(context, this.current_index);
    }

    public VectorIteratorImpl_EventListener_ChangeEvent__long_ clone(CallContext context) {
        try {
            return (VectorIteratorImpl_EventListener_ChangeEvent__long_) super.clone();
        } catch (CloneNotSupportedException cnse) { return null; }
    }
}
