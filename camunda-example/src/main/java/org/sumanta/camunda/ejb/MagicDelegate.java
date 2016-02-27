package org.sumanta.camunda.ejb;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class MagicDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger(MagicDelegate.class.getName());

    public void execute(DelegateExecution execution) throws Exception {

        String command = execution.getVariables().get("1").toString();
        LOGGER.info("This is a  BPMN 2.0 process listed from callback JavaDelegate: " + command);

        LOGGER.info("from magic");

    }

}
