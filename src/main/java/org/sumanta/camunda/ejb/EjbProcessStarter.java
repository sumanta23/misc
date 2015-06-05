package org.sumanta.camunda.ejb;

import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.camunda.bpm.engine.RuntimeService;

/**
 * Ejb which is automatically started when the application is deployed and
 * creates a new process instance
 *
 */
@Startup
@Singleton
@DependsOn("EjbSshDelegate")
public class EjbProcessStarter {

  @Inject
  private RuntimeService runtimeService;

  @Schedule(second="*/5")
  public void startProcessInstance() {

    /*
     * ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
     * 
     * RuntimeService runtimeService = processEngine.getRuntimeService();
     */
    
    System.out.println("trying to fuck");
    runtimeService.startProcessInstanceByKey("testResolveBean");

  }

}
