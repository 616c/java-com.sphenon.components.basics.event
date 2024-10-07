// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Vector.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIId("")
@UIName("")
@UIClassifier("Vector_EventListener_ChangeEvent__")
@UIParts("js:instance.getIterable(context)")
public interface Vector_EventListener_ChangeEvent__long_
  extends ReadOnlyVector_EventListener_ChangeEvent__long_,
          WriteVector_EventListener_ChangeEvent__long_
          , GenericVector<EventListener_ChangeEvent_>
          , GenericIterable<EventListener_ChangeEvent_>
{
    public EventListener_ChangeEvent_                                    get             (CallContext context, long index) throws DoesNotExist;
    public EventListener_ChangeEvent_                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_EventListener_ChangeEvent__long_ReadOnlyVector_EventListener_ChangeEvent__long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_EventListener_ChangeEvent__long_ReadOnlyVector_EventListener_ChangeEvent__long__  tryGetReference (CallContext context, long index);

    public EventListener_ChangeEvent_                                    set             (CallContext context, long index, EventListener_ChangeEvent_ item);
    public void                                        add             (CallContext context, long index, EventListener_ChangeEvent_ item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, EventListener_ChangeEvent_ item);
    public void                                        append          (CallContext context, EventListener_ChangeEvent_ item);
    public void                                        insertBefore    (CallContext context, long index, EventListener_ChangeEvent_ item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, EventListener_ChangeEvent_ item) throws DoesNotExist;
    public EventListener_ChangeEvent_                                    replace         (CallContext context, long index, EventListener_ChangeEvent_ item) throws DoesNotExist;
    public EventListener_ChangeEvent_                                    unset           (CallContext context, long index);
    public EventListener_ChangeEvent_                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_EventListener_ChangeEvent__long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<EventListener_ChangeEvent_>              getIterator_EventListener_ChangeEvent__ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_EventListener_ChangeEvent__long_          getIterable_EventListener_ChangeEvent__ (CallContext context);
    public Iterable<EventListener_ChangeEvent_> getIterable (CallContext context);
}
