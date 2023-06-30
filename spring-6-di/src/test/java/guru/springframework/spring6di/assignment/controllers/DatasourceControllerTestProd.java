package guru.springframework.spring6di.assignment.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles({"prod", "EN"})
@SpringBootTest
class DatasourceControllerTestProd {

    @Autowired
    DatasourceController datasourceController;

    @Test
    void retrieveDatasourceConfig() {
        String config = datasourceController.retrieveDatasourceConfig();
        System.out.println(config);

        assertEquals("PROD - datasource configs", config);
    }
}