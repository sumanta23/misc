package org.sumanta.camunda.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an Ejb which is invoked form a Service task
 *
 */
@Named("sshBean")
@Stateless
public class EjbSshDelegate implements JavaDelegate {

  private final static Logger LOGGER = Logger.getLogger(EjbSshDelegate.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

    String command = execution.getVariables().get("1").toString();
    LOGGER.info("This is a @Stateless Ejb component invoked from a BPMN 2.0 process " + command);

  }


  public void sysout(String var) {
    LOGGER.log(Level.INFO, var);
  }

}
