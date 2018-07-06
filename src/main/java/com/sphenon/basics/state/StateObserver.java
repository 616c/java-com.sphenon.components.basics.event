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
import com.sphenon.basics.event.*;
import com.sphenon.basics.event.tplinst.*;

import com.sphenon.basics.state.classes.*;

public class StateObserver {

    protected Changing changing;
    protected StateComplexCondition before;
    protected StateComplexCondition after;
    protected EventListener_ChangeEvent_ listener;

    public StateObserver(CallContext context, String before_condition, String after_condition, Changing changing) {
        this.before = before_condition == null || before_condition.isEmpty() ? null : new com.sphenon.basics.state.classes.StateComplexCondition(context, before_condition);
        this.after = after_condition == null || after_condition.isEmpty() ? null : new com.sphenon.basics.state.classes.StateComplexCondition(context, after_condition);
        this.listener = new EventListener_ChangeEvent_() {
                public void notify(CallContext context) { }
                public void notify(CallContext context, ChangeEvent event) {
                    if (event instanceof com.sphenon.basics.event.StateChangeEvent) {
                        if (    (    before == null
                                  || before.matches(context, ((com.sphenon.basics.event.StateChangeEvent) event).getOldState(context))
                                )
                             && (    after == null
                                  || after.matches(context, ((com.sphenon.basics.event.StateChangeEvent) event).getNewState(context))
                                )
                           ) {
                            action(context);
                        }
                    }
                }
            };
        this.changing = changing;
        this.changing.getChangeEventDispatcher(context).addListener(context, this.listener);
    }

    protected void unbind(CallContext context) {
        this.changing.getChangeEventDispatcher(context).removeListener(context, this.listener);
    }

    public void action(CallContext context) {
    }
}
