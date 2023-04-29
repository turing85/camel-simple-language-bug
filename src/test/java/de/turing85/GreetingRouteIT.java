package de.turing85;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GreetingRouteIT {
  @Test
  void getGreeting() {
    given()
        .when().get("/hello")
        .then()
            .statusCode(200)
            .body(is("foobar"));
  }
}