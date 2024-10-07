package com.sphenon.basics.event;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

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

public class MemberChangeEvent_Update extends MemberChangeEvent
{
    public MemberChangeEvent_Update (CallContext context, Object changed_object, String membername, Object old_value, Object new_value) {
        this(context, changed_object, membername, old_value, new_value, true);
    }

    public MemberChangeEvent_Update (CallContext context, Object changed_object, String membername, Object old_value, Object new_value, boolean is_structural) {
        super(context, changed_object, membername, is_structural);
        this.old_value = old_value;
        this.new_value = new_value;
    }

    public MemberChangeEvent_Update clone(CallContext context) {
        return new MemberChangeEvent_Update(context, this.changed_object, this.member_name, this.old_value, this.new_value, this.is_structural);
    }

    protected Object new_value;

    public Object getNewValue (CallContext context) {
        return this.new_value;
    }

    protected Object old_value;

    public Object getOldValue (CallContext context) {
        return this.old_value;
    }
}
