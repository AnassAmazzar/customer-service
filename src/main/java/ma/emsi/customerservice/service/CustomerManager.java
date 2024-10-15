package ma.emsi.customerservice.service;

import ma.emsi.customerservice.dao.entities.Customer;

import java.util.List;

public interface CustomerManager {
    List<Customer> getAllCustomer();
    Customer getCustomerById(Long id);
    Customer addCustomer(Customer customer);
}
