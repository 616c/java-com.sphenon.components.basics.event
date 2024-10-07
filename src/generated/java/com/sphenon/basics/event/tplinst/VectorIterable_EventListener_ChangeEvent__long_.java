// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIterable.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_EventListener_ChangeEvent__long_ implements Iterable<EventListener_ChangeEvent_>
{
    protected java.util.Iterator<EventListener_ChangeEvent_> iterator;

    public VectorIterable_EventListener_ChangeEvent__long_ (CallContext context, Vector_EventListener_ChangeEvent__long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<EventListener_ChangeEvent_>()).iterator() : vector.getIterator_EventListener_ChangeEvent__(context));
    }

    public java.util.Iterator<EventListener_ChangeEvent_> iterator () {
        return this.iterator;
    }
}

