// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/event/v0001/origin/source/java/com/sphenon/basics/event/templates/EventListener.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

public interface EventListener_ChangeEvent_
    extends java.util.EventListener
{
    public void notify(CallContext context);
    public void notify(CallContext context, ChangeEvent event);
}

