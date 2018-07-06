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
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.classes.*;

public class EventStringPool extends StringPoolClass {
    static protected EventStringPool singleton = null;

    static public EventStringPool getSingleton (CallContext cc) {
        if (singleton == null) {
            singleton = new EventStringPool(cc);
        }
        return singleton;
    }

    static public VariativeString get(CallContext cc, String id) {
        return VariativeStringClass.createVariativeStringClass(cc, id, getSingleton(cc));
    }

    static public String get(CallContext cc, String id, String isolang) {
        return getSingleton(cc).getString(cc, id, isolang);
    }

    protected EventStringPool (CallContext cc) {
        super(cc);
        /*************************************************/
        /* THE FOLLOWING SECTION IS PARTIALLY GENERATED. */
        /* BE CAREFUL WHEN EDITING MANUALLY !            */
        /*                                               */
        /* See StringPool.java for explanation.          */
        /*************************************************/
        //BEGINNING-OF-STRINGS
        //P-0-com.sphenon.basics.event.templates
        //F-0-0-EventDispatcher.javatpl
        addEntry(cc, "0.0.0", "en", "EventListener vanished");
        addEntry(cc, "0.0.0", "de", "EventListener ist verschwunden");
        addEntry(cc, "0.0.1", "en", "EventListener vanished");
        addEntry(cc, "0.0.1", "de", "EventListener ist verschwunden");
        //F-0-1-WeakReference.javatpl
        addEntry(cc, "0.1.0", "en", "Typed WeakReference contains invalid type");
        addEntry(cc, "0.1.0", "de", "Getypte WeakReference enthält ungültigen Typ");
        //END-OF-STRINGS
        /*************************************************/
    }
}
