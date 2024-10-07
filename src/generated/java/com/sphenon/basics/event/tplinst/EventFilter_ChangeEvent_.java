// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/event/v0001/origin/source/java/com/sphenon/basics/event/templates/EventFilter.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.function.*;

public class EventFilter_ChangeEvent_
    implements EventListener_ChangeEvent_
{
    protected EventListener_ChangeEvent_ listener;
    protected Predicate1<ChangeEvent> predicate;

    public EventFilter_ChangeEvent_(CallContext context, EventListener_ChangeEvent_ listener, Predicate1<ChangeEvent> predicate) {
        this.listener  = listener;
        this.predicate = predicate;
    }

    public void notify(CallContext context) {
        if (this.predicate == null) {
            this.listener.notify(context);
        }
    }

    public void notify(CallContext context, ChangeEvent event) {
        if (    this.predicate == null
             || this.predicate.check(context, event) == true
           ) {
            this.listener.notify(context, event);
        }
    }
}
