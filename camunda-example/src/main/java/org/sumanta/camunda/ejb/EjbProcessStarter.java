package org.sumanta.camunda.ejb;

import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.inject.Singleton;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;

/**
 * Ejb which is automatically started when the application is deployed and creates a new process instance
 *
 */
@Startup
@Singleton
@DependsOn("SshModeler")
public class EjbProcessStarter {

    @Schedule(second = "*/5")
    public void startProcessInstance() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        System.out.println("trying to start");
        runtimeService.startProcessInstanceByKey("sshexe");

    }

}
