package guru.springframework.spring6di.controllers;

import guru.springframework.spring6di.controllers.NoInjectionController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoInjectionControllerTest {

    @Test
    void sayHello() {
        NoInjectionController noInjectionController = new NoInjectionController();

        String greeting = noInjectionController.sayHello();
        System.out.println(greeting);

        assertEquals("Hello Everyone from the Base Service!", greeting);
    }
}