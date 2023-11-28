package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

//@QuarkusTest
public class GreetingGraphQLTest {

    //@Test
    public void testHelloTestEndpoint() {
        given()
          .when().get("/hello/Test")
          .then()
             .statusCode(200)
             .body(is("Hello Test"));
    }

    //@Test
    public void testHelloWithSpaceEndpoint() {
        given()
          .when().get("/hello/Test Space")
          .then()
             .statusCode(200)
             .body(is("Hello Test Space"));
    }
    
    //@Test
    public void testHelloAnotherEndpoint() {
        given()
          .when().get("/hello/Another")
          .then()
             .statusCode(200)
             .body(is("Hello Another"));
    }
    
}
