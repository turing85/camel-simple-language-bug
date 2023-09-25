package de.turing85;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.timer;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class GreetingRoute extends RouteBuilder {
  @Override
  public void configure() {
    from(timer("sender-timer").fixedRate(true).period(1000))
        .routeId("http-get-hello")
        .setProperty("my.greeting", constant("foo"))
        .log("${exchangeProperty[my.greeting]}");
  }
}
