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

public class ChangeEventDelegate extends ChangeEvent {

    protected ChangeEvent original_event = null;

    public ChangeEvent getOriginalEvent(CallContext context){
        return this.original_event;
    }

    public ChangeEventDelegate (CallContext context, Object changed_object, ChangeEvent original_event) {
        super(context, changed_object);
        this.original_event = original_event;
    }
}
