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

import java.util.ArrayList;
import java.util.List;

import com.sphenon.basics.context.*;

public class MemberChangeEvent extends ChangeEvent
{
    protected String member_name;

    public String getMemberName (CallContext context) {
        return this.member_name;
    }

    public MemberChangeEvent setMemberName (CallContext context, String member_name) {
        this.member_name = member_name;
        return this;
    }

    protected boolean is_structural;

    public boolean isStructural (CallContext context) {
        return this.is_structural;
    }

    public MemberChangeEvent (CallContext context, Object changed_object, String member_name) {
        this(context, changed_object, member_name, true);
    }

    public MemberChangeEvent (CallContext context, Object changed_object, String member_name, boolean is_structural) {
        super(context, changed_object);
        this.member_name   = member_name;
        this.is_structural = is_structural;
    }
    
    public MemberChangeEvent clone(CallContext context) {
        return new MemberChangeEvent(context, this.changed_object, this.member_name, this.is_structural);
    }

    // ======================================================================================
    // [Issue:MemberChangeEvent.java,VUIObjectAdapterBase.java]
    // to be discussed/eliminated:
    //    - anonymous mechanism (it is unclear what's the purpose)
    //    - not each event needs it
    protected ArrayList equipments = null;
    
    public void addEquipment(CallContext context, Object equipment){
        if (equipment == null) { return; }
        if (this.equipments == null) {
            this.equipments = new ArrayList();
        }
        this.equipments.add(equipment);
    }
    
    public List getEquipments(CallContext context) {
        if (this.equipments != null) {
            return this.equipments;
        }
        return new ArrayList();
    }
    // [End:Issue:MemberChangeEvent.java,VUIObjectAdapterBase.java]
    // ======================================================================================
}
