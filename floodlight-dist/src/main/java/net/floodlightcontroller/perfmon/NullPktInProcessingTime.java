/**
 *    Copyright 2013, Big Switch Networks, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License"); you may
 *    not use this file except in compliance with the License. You may obtain
 *    a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *    License for the specific language governing permissions and limitations
 *    under the License.
 **/

package net.floodlightcontroller.perfmon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.projectfloodlight.openflow.protocol.OFMessage;

import net.floodlightcontroller.core.FloodlightContext;
import net.floodlightcontroller.core.IOFMessageListener;
import net.floodlightcontroller.core.IOFSwitch;
import net.floodlightcontroller.core.module.FloodlightModuleContext;
import net.floodlightcontroller.core.module.FloodlightModuleException;
import net.floodlightcontroller.core.module.IFloodlightModule;
import net.floodlightcontroller.core.module.IFloodlightService;

/**
 * An IPktInProcessingTimeService implementation that does nothing.
 * This is used mainly for performance testing or if you don't
 * want to use the IPktInProcessingTimeService features.
 * @author alexreimers
 *
 */
public class NullPktInProcessingTime 
    implements IFloodlightModule, IPktInProcessingTimeService {
    
    private CumulativeTimeBucket ctb;
    private boolean inited = false;
    
    public Collection<Class<? extends IFloodlightService>> getModuleServices() {
        Collection<Class<? extends IFloodlightService>> l = 
                new ArrayList<Class<? extends IFloodlightService>>();
        l.add(IPktInProcessingTimeService.class);
        return l;
    }
    
    
    public Map<Class<? extends IFloodlightService>, IFloodlightService>
            getServiceImpls() {
        Map<Class<? extends IFloodlightService>,
        IFloodlightService> m = 
            new HashMap<Class<? extends IFloodlightService>,
                        IFloodlightService>();
        // We are the class that implements the service
        m.put(IPktInProcessingTimeService.class, this);
        return m;
    }
    
    
    public Collection<Class<? extends IFloodlightService>> getModuleDependencies() {
        // We don't have any dependencies
        return null;
    }
    
    
    public void init(FloodlightModuleContext context)
                             throws FloodlightModuleException {

    }

    
    public void startUp(FloodlightModuleContext context) {
        // no-op
    }

    
    public boolean isEnabled() {
        return false;
    }

    
    public void bootstrap(List<IOFMessageListener> listeners) {
        if (!inited)
            ctb = new CumulativeTimeBucket(listeners);
    }

    
    public void recordStartTimeComp(IOFMessageListener listener) {

    }

    
    public void recordEndTimeComp(IOFMessageListener listener) {

    }

    
    public void recordStartTimePktIn() {

    }

    
    public void recordEndTimePktIn(IOFSwitch sw, OFMessage m,
                                   FloodlightContext cntx) {
        
    }

    
    public void setEnabled(boolean enabled) {
    
    }

    
    public CumulativeTimeBucket getCtb() {
        return ctb;
    }
}
