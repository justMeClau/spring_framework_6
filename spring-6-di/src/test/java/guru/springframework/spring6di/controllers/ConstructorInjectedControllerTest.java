package guru.springframework.spring6di.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConstructorInjectedControllerTest {

    @Autowired
    ConstructorInjectedController controller;

    @Test
    void sayHello() {
        String greeting = controller.sayHello();
        System.out.println(greeting);

        assertEquals("Hello Everyone from the PRIMARY Service!", greeting);
    }
}