package guru.springframework.spring6di.assignment.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles({"uat", "EN"})
@SpringBootTest
class DatasourceControllerTestUat {

    @Autowired
    DatasourceController datasourceController;

    @Test
    void retrieveDatasourceConfig() {
        String config = datasourceController.retrieveDatasourceConfig();
        System.out.println(config);

        assertEquals("UAT - datasource configs", config);
    }
}