package guru.springframework.spring6di.assignment.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class DatasourceServiceProd implements DatasourceService {

    @Override
    public String getDatasourceConfig() {
        return "PROD - datasource configs";
    }
}
