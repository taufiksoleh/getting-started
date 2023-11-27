package org.acme.hibernate.orm.panache;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class FruitResourceTest {
    @Test
    public void testListFruitsEndpoint() {
        given()
                .when().get("fruits")
                .then()
                    .statusCode(200)
                    .body(is("[{\"id\":2,\"name\":\"Apple\"},{\"id\":3,\"name\":\"Banana\"},{\"id\":1,\"name\":\"Cherry\"}]"));
    }
}