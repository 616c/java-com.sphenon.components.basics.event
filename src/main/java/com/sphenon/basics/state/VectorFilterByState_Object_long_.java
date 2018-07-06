package com.sphenon.basics.state;

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
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.tplinst.*;
import com.sphenon.basics.event.*;
import com.sphenon.basics.event.tplinst.*;

import java.util.Vector;
import java.util.Date;

public class VectorFilterByState_Object_long_ extends VectorFilter_Object_long_ implements Changing {

    public VectorFilterByState_Object_long_(CallContext context, Vector<ConditionalItem> conditional_items, Stateful stateful_controller) {
        this(context, conditional_items, stateful_controller, false);
    }

    public VectorFilterByState_Object_long_(CallContext context, Vector<ConditionalItem> conditional_items, Stateful stateful_controller, boolean caching) {
        super(context, getData(context, conditional_items), caching);
        this.conditional_items = conditional_items;
        this.setStatefulController(context, stateful_controller);
    }

    public VectorFilterByState_Object_long_(CallContext context) {
        super(context, null);
    }

    public void setVector (CallContext context, Vector_Object_long_ vector) {
        // ignored, this uses setConditionalItems only
    }

    public Vector_Object_long_ defaultVector (CallContext context) {
        return null;
    }

    protected Stateful stateful_controller;

    public Stateful getStatefulController (CallContext context) {
        return this.stateful_controller;
    }

    public void setStatefulController (CallContext context, Stateful stateful_controller) {
        if (this.stateful_controller != null && this.stateful_controller instanceof Changing) {
            ((Changing) this.stateful_controller).getChangeEventDispatcher(context).removeListener(context, this.getChangeEventDispatcher(context));
        }
        this.stateful_controller = stateful_controller;
        if (this.stateful_controller != null && this.stateful_controller instanceof Changing) {
            ((Changing) this.stateful_controller).getChangeEventDispatcher(context).addListener(context, this.getChangeEventDispatcher(context));
        }
    }

    protected Vector<ConditionalItem> conditional_items;

    public Vector<ConditionalItem> getConditionalItems (CallContext context) {
        return this.conditional_items;
    }

    public void setConditionalItems (CallContext context, Vector<ConditionalItem> conditional_items) {
        super.setVector(context, getData(context, conditional_items));
        this.conditional_items = conditional_items;
    }

    static protected Vector_Object_long_ getData(CallContext context, Vector<ConditionalItem> conditional_items) {
        Vector_Object_long_ data = Factory_Vector_Object_long_.construct(context);
        for (ConditionalItem ci : conditional_items) {
            data.append(context, ci.getItem(context));
        }
        return data;
    }

    protected boolean isMatching(CallContext context, Object item, long orig_size) {
        String condition = conditional_items.get((int) orig_size).getCondition(context);
        if (condition == null || condition.isEmpty()) {
            return true;
        }
        return stateful_controller != null ? stateful_controller.checkState(context, condition) : ((Stateful) item).checkState(context, condition);
    }

    // --- from Changing ------------------------------------------------------

    protected EventDispatcher_ChangeEvent_ change_event_dispatcher;

    public EventDispatcher_ChangeEvent_ getChangeEventDispatcher(CallContext context) {
        if (this.change_event_dispatcher == null) {
            this.change_event_dispatcher = new EventDispatcher_ChangeEvent_(context);
        }
        return this.change_event_dispatcher;
    }

    protected Date last_update;

    public Date getLastUpdate(CallContext call_context) {
        if (this.last_update == null) {
            this.last_update = new java.util.Date(0L);
        }
        return this.last_update;
    }
}
