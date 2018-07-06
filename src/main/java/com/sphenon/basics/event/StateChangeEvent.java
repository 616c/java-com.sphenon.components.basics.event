package com.sphenon.basics.event;

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
import com.sphenon.basics.state.*;

public class StateChangeEvent extends ChangeEvent
{
    protected State old_state;

    public State getOldState (CallContext context) {
        return this.old_state;
    }

    protected State new_state;

    public State getNewState (CallContext context) {
        return this.new_state;
    }

    protected String state_variable;

    public String getStateVariable (CallContext context) {
        return this.state_variable;
    }

    public void setStateVariable (CallContext context, String state_variable) {
        this.state_variable = state_variable;
    }

    public StateChangeEvent (CallContext context, Object changed_object, State old_state, State new_state) {
        super(context, changed_object);
        this.old_state = old_state;
        this.new_state = new_state;
    }
}
