package hello;

import datadog.trace.api.Trace;

public class Greeter {

  @Trace(operationName = "Greeter", resourceName = "sayHello")
  public String sayHello() {
	  return "Hello world!";
  }

}
