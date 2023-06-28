package guru.springframework.spring6di.assignment.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("qa")
@Service
public class DatasourceServiceQa implements DatasourceService {

    @Override
    public String getDatasourceConfig() {
        return "QA - datasource configs";
    }
}
