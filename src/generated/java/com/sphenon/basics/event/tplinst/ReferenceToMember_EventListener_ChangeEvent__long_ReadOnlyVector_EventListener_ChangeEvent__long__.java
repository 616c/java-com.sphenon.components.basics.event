// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReferenceToMember.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.many.*;

public interface ReferenceToMember_EventListener_ChangeEvent__long_ReadOnlyVector_EventListener_ChangeEvent__long__
  extends Reference_EventListener_ChangeEvent__
    , ReferenceToMember<EventListener_ChangeEvent_,ReadOnlyVector<EventListener_ChangeEvent_>>
{
    public ReadOnlyVector_EventListener_ChangeEvent__long_ getContainer(CallContext context);
    public long     getIndex    (CallContext context);
}
