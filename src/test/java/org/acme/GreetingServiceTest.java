package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class GreetingServiceTest {
    @Inject
    GreetingService service;

    @Test
    public void testHelloUsingInjected() {
        Assertions.assertEquals("hello Taufik", service.greeting("Taufik"));
    }
}