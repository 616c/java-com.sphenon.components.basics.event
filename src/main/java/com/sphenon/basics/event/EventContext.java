package com.sphenon.basics.event;

import com.sphenon.basics.context.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.event.tplinst.*;

public class EventContext extends SpecificContext {

    static public EventContext getOrCreate(Context context) {
        EventContext event_context = (EventContext) context.getSpecificContext(EventContext.class);
        if (event_context == null) {
            event_context = new EventContext(context);
            context.setSpecificContext(EventContext.class, event_context);
        }
        return event_context;
    }

    static public EventContext get(Context context) {
        EventContext event_context = (EventContext) context.getSpecificContext(EventContext.class);
        return event_context;
    }

    static public EventContext create(Context context) {
        EventContext event_context = new EventContext(context);
        context.setSpecificContext(EventContext.class, event_context);
        return event_context;
    }

    protected EventContext (Context context) {
        super(context);
        this.dispatcher = null;
    }

    protected EventDispatcher_ChangeEvent_ dispatcher;

    public void addListener(CallContext context, EventListener_ChangeEvent_ listener) {
        if (this.dispatcher == null) {
            this.dispatcher = new EventDispatcher_ChangeEvent_(context);
        }
        this.dispatcher.addListener(context, listener);
    }

    public void removeListener(CallContext context, EventListener_ChangeEvent_ listener) {
        if (this.dispatcher == null) { return; }
        this.dispatcher.removeListener(context, listener);
    }

    public EventListener_ChangeEvent_ getListener(CallContext cc) {
        EventContext event_context;
        return (this.dispatcher != null ?
                     this.dispatcher
                  : (event_context = (EventContext) this.getCallContext(EventContext.class)) != null ?
                       event_context.getListener(cc)
                     : null
               );
    }
}
