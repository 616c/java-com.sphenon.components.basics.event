// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/event/v0001/origin/source/java/com/sphenon/basics/event/templates/WeakReference.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.event.*;

import java.lang.ref.WeakReference;

public class WeakReference_EventListener_ChangeEvent__
    extends WeakReference
{
    public WeakReference_EventListener_ChangeEvent__ (CallContext context, EventListener_ChangeEvent_ t) {
        super(t);
    }

    public EventListener_ChangeEvent_ getTyped (CallContext call_context) {
        try {
            return (EventListener_ChangeEvent_) this.get();
        } catch (ClassCastException cce) {
            Context context = Context.create(call_context);
            CustomaryContext cc = CustomaryContext.create(context);
            cc.throwProtocolViolation(context, EventStringPool.get(context, "0.1.0" /* Typed WeakReference contains invalid type */));
            throw (ExceptionProtocolViolation) null; // compiler insists
        }
    }

    public boolean equals (Object o) {
        try {
            WeakReference wr = (WeakReference) o;
            Object my_o = this.get();
            return (my_o == null || wr == null ? false : my_o.equals(wr.get()));
        } catch (ClassCastException cce) {
            return false;
        }
    }

    public int hashCode () {
        return this.get().hashCode();
    }
}

