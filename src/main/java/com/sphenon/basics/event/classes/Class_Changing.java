package com.sphenon.basics.event.classes;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.event.tplinst.*;

import com.sphenon.basics.event.*;

import java.util.Date;
  
public class Class_Changing implements Changing {

    protected EventDispatcher_ChangeEvent_ change_event_dispatcher;

    public EventDispatcher_ChangeEvent_ getChangeEventDispatcher(CallContext context) {
        if (this.change_event_dispatcher == null) {
            this.change_event_dispatcher = new EventDispatcher_ChangeEvent_(context);
        }
        return this.change_event_dispatcher;
    }

    public EventDispatcher_ChangeEvent_ defaultChangeEventDispatcher(CallContext context) {
        return null;
    }

    public void setChangeEventDispatcher(CallContext call_context, EventDispatcher_ChangeEvent_ change_event_dispatcher) {
        this.change_event_dispatcher = change_event_dispatcher;
    }

    protected Date last_update;

    public Date getLastUpdate(CallContext call_context) {
        if (this.last_update == null) {
            this.last_update = new java.util.Date(0L);
        }
        return this.last_update;
    }

    public Date defaultLastUpdate(CallContext call_context) {
        return null;
    }

    public void setLastUpdate(CallContext context, Date last_update) {
        this.last_update = last_update;
    }

    public void notify(CallContext context, ChangeEvent event) {
        if (this.events_disabled) { return; }
        if (this.change_transaction) {
            this.appendEvent(context, event);
        } else {
            if( this.change_event_dispatcher != null ){
                this.change_event_dispatcher.notify(context, event);
            }
        }
    }

    public void notify(CallContext context) {
        if (this.events_disabled) { return; }
        if (this.change_transaction) {
            this.appendEvent(context, null);
        } else {
            if( this.change_event_dispatcher != null ){
                this.change_event_dispatcher.notify(context);
            }
        }
    }

    protected ChangeEvent pending_event;
    protected boolean     change_transaction;
    protected boolean     events_disabled;

    // by default simply uses last event; derived classes may override this
    protected void appendEvent(CallContext context, ChangeEvent event) {
        this.pending_event = event;
    }

    public void beginChange(CallContext context) {
        if (this.change_transaction) {
            CustomaryContext.create((Context)context).throwProtocolViolation(context, "beginChange called inside transaction");
            throw (ExceptionProtocolViolation) null; // compiler insists
        }
        this.change_transaction = true;
    }

    public void commitChange(CallContext context) {
        if ( ! this.change_transaction) {
            CustomaryContext.create((Context)context).throwProtocolViolation(context, "commitChange called outside transaction");
            throw (ExceptionProtocolViolation) null; // compiler insists
        }
        this.change_transaction = false;
        this.notify(context, this.pending_event);
        this.pending_event = null;
    }

    public void cancelChange(CallContext context) {
        if ( ! this.change_transaction) {
            CustomaryContext.create((Context)context).throwProtocolViolation(context, "commitChange called outside transaction");
            throw (ExceptionProtocolViolation) null; // compiler insists
        }
        this.change_transaction = false;
        this.pending_event = null;
    }

    public void disableEvents(CallContext context) {
        this.events_disabled = true;
    }

    public void enableEvents(CallContext context) {
        this.events_disabled = false;
    }
}


