// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteSet.javatpl
// please do not modify this file directly
package com.sphenon.basics.event.tplinst;

import com.sphenon.basics.event.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteSet_WeakReference_EventListener_ChangeEvent___
{
    // adds item, may already exist
    public void     set     (CallContext context, WeakReference_EventListener_ChangeEvent__ item);

    // adds item, must not already exist
    public void     add     (CallContext context, WeakReference_EventListener_ChangeEvent__ item) throws AlreadyExists;

    // replace item, must already exist
    public void     replace (CallContext context, WeakReference_EventListener_ChangeEvent__ item) throws DoesNotExist;
    // does this method make any sense?
    // should'nt it be? : 
    // public void     replace (CallContext context, WeakReference_EventListener_ChangeEvent__ item, WeakReference_EventListener_ChangeEvent__ item) throws DoesNotExist;

    // removes item, need not exist
    public void     unset   (CallContext context, WeakReference_EventListener_ChangeEvent__ item);

    // removes item, must exist
    public void     remove  (CallContext context, WeakReference_EventListener_ChangeEvent__ item) throws DoesNotExist;
}

