/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.testing.mock.osgi.testsvc.osgiserviceutil.activatedeactivate;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component
public class Service4 {

    private boolean activated;
    private Map<String, Object> map;

    @Activate
    private void activate(ServiceConfig config) {
        this.activated = true;
        map = readAnnotationToMap(config);
    }

    @Deactivate
    private void deactivate(int value) {
        this.activated = false;
    }

    public boolean isActivated() {
        return activated;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    static Map<String, Object> readAnnotationToMap(final ServiceConfig config) {
        Map<String, Object> map = new HashMap<>();
        map.put("prop1", config.prop1());
        map.put("prop2.with.periods", config.prop2_with_periods());
        map.put("prop3-with-hyphens", config.prop3$_$with$_$hyphens());
        return map;
    }
}
