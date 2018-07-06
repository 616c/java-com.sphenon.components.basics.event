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

import com.sphenon.basics.context.CallContext;

public class PersistenceStateChangeEvent extends ChangeEvent {
    public PersistenceStateChangeEvent( CallContext context, Object changedObject, PersistenceEvent event ){
        super( context, changedObject );
    }
    
    protected PersistenceEvent event = PersistenceEvent.Initial;
    
    public PersistenceEvent
    getEvent(CallContext context){
        return this.event;
    }

    public enum PersistenceEvent{
        Initial,
        PostLoad,
        PreUpdate,
        PostUpdate,
        PostDelete,
        PrePersist,
        PostPersist,
        PreWrite,
        PostWrite,
        PreRemove,
        PostRemove,
        PostBuild,
        PostClone,
        PreInsert,
        PostInsert,
        PostMerge,
        PostRefresh
    }
}
