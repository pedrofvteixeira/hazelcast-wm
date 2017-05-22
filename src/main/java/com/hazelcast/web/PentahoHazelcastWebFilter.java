/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.web;

import javax.servlet.http.HttpSession;
import java.util.Properties;

/**
 * Created by pedroteixeira on 22/05/2017.
 */
public class PentahoHazelcastWebFilter extends WebFilter {

    public PentahoHazelcastWebFilter() {
        super();
    }

    public PentahoHazelcastWebFilter(Properties properties) {
        super(properties);
    }


    /**
     * {@code HazelcastHttpSession instance} creation is split off to a separate method to allow subclasses to return a
     * customized / extended version of {@code HazelcastHttpSession}.
     *
     * @param id              the session id
     * @param originalSession the original session
     * @return a new HazelcastHttpSession instance
     */
    @Override
    protected HazelcastHttpSession createHazelcastHttpSession(String id, HttpSession originalSession) {
        return new PentahoSerializableHazelcastHttpSession(this, id, originalSession, getConfig().isDeferredWrite(),
                getConfig().isStickySession(), getConfig().getTransientAttributes());
    }
}
