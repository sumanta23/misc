package org.sumanta.camunda.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;

@Path("/callme")
public class CallMe {

  @Inject
  private RuntimeService runtimeService;

  @Path("/exe/{id}")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String exe(@PathParam("id") String id) {
    System.out.println("trying to fuck " + id);
    String message = "";
    try {
      ProcessEngine processEngine1 = ProcessEngines.getDefaultProcessEngine();

      RuntimeService runtimeService1 = processEngine1.getRuntimeService();

      Map<String, Object> commands = new HashMap<String, Object>();

      commands.put("1", "ls -all ~");

      runtimeService1.startProcessInstanceByKey("sshexe", "sf", commands);
    } catch (Exception exception) {
      message = exception.getMessage();
    }
    return message;
  }
}
