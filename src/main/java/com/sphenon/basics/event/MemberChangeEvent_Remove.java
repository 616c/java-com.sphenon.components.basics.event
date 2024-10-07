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

public class MemberChangeEvent_Remove extends MemberChangeEvent
{
    public MemberChangeEvent_Remove (CallContext context, Object changed_object, String membername, Object value) {
        this(context, changed_object, membername, value, true);
    }

    public MemberChangeEvent_Remove (CallContext context, Object changed_object, String membername, Object value, boolean is_structural) {
        super(context, changed_object, membername, is_structural);
        this.value = value;
    }

    public MemberChangeEvent_Remove clone(CallContext context) {
        return new MemberChangeEvent_Remove(context, this.changed_object, this.member_name, this.value, this.is_structural);
    }

    protected Object value;

    public Object getValue (CallContext context) {
        return this.value;
    }
}
