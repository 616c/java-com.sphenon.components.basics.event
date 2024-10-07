// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadVector_EventListener_ChangeEvent__long_
{
    public EventListener_ChangeEvent_                                    get             (CallContext context, long index) throws DoesNotExist;
    public EventListener_ChangeEvent_                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_EventListener_ChangeEvent__long_ReadOnlyVector_EventListener_ChangeEvent__long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_EventListener_ChangeEvent__long_ReadOnlyVector_EventListener_ChangeEvent__long__  tryGetReference (CallContext context, long index);
}

