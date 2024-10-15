package ma.emsi.customerservice.web;

import ma.emsi.customerservice.dao.entities.Customer;
import ma.emsi.customerservice.service.CustomerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerRestController {
    @Autowired
    CustomerManagerService customerManagerService;

    @GetMapping("/listes")
    public List<Customer> customerList(){
        return customerManagerService.getAllCustomer();
    }

    @GetMapping("/customer-by-id/{id}")
    public Customer customerById(@RequestParam Long id){
        return customerManagerService.getCustomerById(id);
    }

    @GetMapping("/add-customer")
    public Customer saveCustomer(@RequestParam Customer customer){
        return customerManagerService.addCustomer(customer);
    }
}
