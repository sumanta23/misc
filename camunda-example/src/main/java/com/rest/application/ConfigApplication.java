package com.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.sumanta.camunda.ejb.*;

@ApplicationPath("/rest")
public class ConfigApplication extends Application {

  private Set<Object> singletons = new HashSet<Object>();

  public ConfigApplication() {
    singletons.add(new CallMe());
  }

  @Override
  public Set<Object> getSingletons() {
    return singletons;
  }
}
