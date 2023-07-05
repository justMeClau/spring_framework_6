package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer getCustomerById(UUID id);

    Customer saveCustomer(Customer customer);

    void updateCustomer(UUID customerId, Customer customer);

    void deleteCustomer(UUID customerId);

    void updateCustomerPatch(UUID customerId, Customer customer);
}
