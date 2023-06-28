package guru.springframework.spring6di.services.i18n;

import guru.springframework.spring6di.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("RO")
@Service("i18NService")
public class RomanianGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Salutare lume - RO";
    }
}
