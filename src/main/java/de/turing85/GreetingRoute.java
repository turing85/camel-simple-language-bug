package de.turing85;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.platformHttp;

import io.vertx.core.http.HttpMethod;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@Getter
public class GreetingRoute extends RouteBuilder {
  private final String greeting;

  public GreetingRoute(
      @ConfigProperty(name = "greeting") String greeting) {
    this.greeting = greeting;
  }

  @Override
  public void configure() {
    from(platformHttp("/hello").httpMethodRestrict(HttpMethod.GET.name()))
        .routeId("http-get-hello")
        .setBody(constant(getGreeting()))
        .log("${exchange.getMessage().getBody()}");
  }
}
