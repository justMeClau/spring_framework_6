package guru.springframework.spring6di.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PropertyInjectedControllerTest {

    @Autowired
    PropertyInjectedController controller;

    @Test
    void sayHello() {
        String greeting = controller.sayHello();
        System.out.println(greeting);

        assertEquals("Friends don't let friends do property injection!", greeting);
    }
}