package org.acme;

import io.smallrye.mutiny.Uni;
import org.acme.hibernate.orm.panache.Fruit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@TransactionQuarkusTest
public class TestStereoTypeTestCase {
    
    @Test
    public void testFruit() {
        Uni<Fruit> fruit = Fruit.findById(1);
        String name = fruit.await().indefinitely().name;
        Assertions.assertEquals("Apple", "test");
    }
}