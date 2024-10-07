// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Set.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface Set_WeakReference_EventListener_ChangeEvent___
  extends ReadSet_WeakReference_EventListener_ChangeEvent___,
          WriteSet_WeakReference_EventListener_ChangeEvent___,
          Navigatable_Iterator_WeakReference_EventListener_ChangeEvent____,
          OfKnownSize
{
    public boolean contains (CallContext context, WeakReference_EventListener_ChangeEvent__ item);

    public void     set     (CallContext context, WeakReference_EventListener_ChangeEvent__ item);
    public void     add     (CallContext context, WeakReference_EventListener_ChangeEvent__ item) throws AlreadyExists;
    public void     replace (CallContext context, WeakReference_EventListener_ChangeEvent__ item) throws DoesNotExist;
    public void     unset   (CallContext context, WeakReference_EventListener_ChangeEvent__ item);
    public void     remove  (CallContext context, WeakReference_EventListener_ChangeEvent__ item) throws DoesNotExist;

    public Iterator_WeakReference_EventListener_ChangeEvent___ getNavigator (CallContext context);

    public long     getSize (CallContext context);
}

