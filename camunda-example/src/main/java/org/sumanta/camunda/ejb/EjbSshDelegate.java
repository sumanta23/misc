package org.sumanta.camunda.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an deligator which is invoked form a Service task
 *
 */
@Named("sshBean")
@ApplicationScoped
public class EjbSshDelegate implements JavaDelegate {

  public static int i = 0;

  private final static Logger LOGGER = Logger.getLogger(EjbSshDelegate.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

    String command = execution.getVariables().get("1").toString();
    LOGGER.info("This is a @Stateless Ejb component invoked from a BPMN 2.0 process " + command);
    i++;
    if (i % 3 == 0) {
      LOGGER.warning("samerror");
      throw new BpmnError("samerror");
    }
    if (execution.getVariable("chk") != null) {
      LOGGER.info("chk is =" + execution.getVariable("chk"));
    }

  }

  public void getsysout(DelegateExecution var) {
    LOGGER.log(Level.INFO, var.getBusinessKey());

    int i = Integer.parseInt(var.getBusinessKey());
    if (i % 2 == 1) {
      var.setVariable("chk", true);
    } else {
      var.setVariable("chk", false);
    }
  }
  
  public JavaDelegate getLogger(DelegateExecution var){
	  LOGGER.info("in getlogger");
	  
	  JavaDelegate jd= new MagicDelegate();
	  
	  return jd;
  }
}
