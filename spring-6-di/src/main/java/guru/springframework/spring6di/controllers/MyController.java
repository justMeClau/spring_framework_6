package guru.springframework.spring6di.controllers;


public class MyController {

    public String sayHello() {
        System.out.println("I'm in the controller");

        return "Hello Everyone!!!";
    }
}
