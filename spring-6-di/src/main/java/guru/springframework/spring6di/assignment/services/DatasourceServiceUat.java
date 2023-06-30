package guru.springframework.spring6di.assignment.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("uat")
@Service
public class DatasourceServiceUat implements DatasourceService {

    @Override
    public String getDatasourceConfig() {
        return "UAT - datasource configs";
    }
}
