package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Customer 1")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Customer 2")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Customer 3")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        log.debug("saveCustomer:: Save customer, customer = [{}]", customer);

        LocalDateTime now = LocalDateTime.now();

        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .createdDate(now)
                .updateDate(now)
                .name(customer.getName())
                .version(customer.getVersion())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void updateCustomer(UUID customerId, Customer customer) {
        log.debug("updateCustomer:: Save customer - in service, customerId = [{}], customer = [{}]",
                customerId, customer);

        Customer existingCustomer = customerMap.get(customerId);
        existingCustomer.setUpdateDate(LocalDateTime.now());
        existingCustomer.setName(customer.getName());
        existingCustomer.setVersion(customer.getVersion());

        customerMap.put(existingCustomer.getId(), existingCustomer);
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("deleteCustomer:: Delete customer - in service, customerId = [{}]", customerId);

        customerMap.remove(customerId);

    }

    @Override
    public void updateCustomerPatch(UUID customerId, Customer customer) {
        Customer existingCustomer = customerMap.get(customerId);

        if (Objects.nonNull(customer.getName())) {
            existingCustomer.setName(customer.getName());
        }

        if (Objects.nonNull(customer.getVersion())) {
            existingCustomer.setVersion(customer.getVersion());
        }
    }
}
