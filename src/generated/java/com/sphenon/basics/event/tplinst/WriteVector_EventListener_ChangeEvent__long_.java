// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_EventListener_ChangeEvent__long_
{
    public EventListener_ChangeEvent_ set          (CallContext context, long index, EventListener_ChangeEvent_ item);
    public void     add          (CallContext context, long index, EventListener_ChangeEvent_ item) throws AlreadyExists;
    public void     prepend      (CallContext context, EventListener_ChangeEvent_ item);
    public void     append       (CallContext context, EventListener_ChangeEvent_ item);
    public void     insertBefore (CallContext context, long index, EventListener_ChangeEvent_ item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, EventListener_ChangeEvent_ item) throws DoesNotExist;
    public EventListener_ChangeEvent_ replace      (CallContext context, long index, EventListener_ChangeEvent_ item) throws DoesNotExist;
    public EventListener_ChangeEvent_ unset        (CallContext context, long index);
    public EventListener_ChangeEvent_ remove       (CallContext context, long index) throws DoesNotExist;
}

