package guru.springframework.spring6di.controllers.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("RO")
@SpringBootTest
class Myi18NControllerTestRO {

    @Autowired
    Myi18NController myi18NController;

    @Test
    void sayHello() {
        String greeting = myi18NController.sayHello();
        System.out.println(greeting);
        assertEquals("Salutare lume - RO", greeting);
    }
}