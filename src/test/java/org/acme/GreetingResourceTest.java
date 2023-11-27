package org.acme;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(GreetingResource.class) // tried to pratice https://quarkus.io/guides/getting-started-testing#restassured
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

    @TestHTTPEndpoint(GreetingResource.class)
    @TestHTTPResource
    URL url;

    @Test
    public void testHelloUsingHttpResourceEndpoint() throws IOException {
        try(InputStream in = url.openStream()) {
            String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            Assertions.assertEquals("Hello from RESTEasy Reactive", contents);
        }
    }

    @Test
    public void testHelloUsingRESTassured() {
        when().get()
            .then()
                .statusCode(200)
                .body(containsString("Hello"));
    }
}