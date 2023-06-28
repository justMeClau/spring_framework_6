package guru.springframework.spring6di.assignment.controllers;

import guru.springframework.spring6di.assignment.services.DatasourceService;
import org.springframework.stereotype.Controller;


@Controller
public class DatasourceController {

    private final DatasourceService datasourceService;

    public DatasourceController(DatasourceService datasourceService) {
        this.datasourceService = datasourceService;
    }

    public String retrieveDatasourceConfig() {
        return datasourceService.getDatasourceConfig();
    }
}
