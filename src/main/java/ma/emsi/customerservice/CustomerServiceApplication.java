package ma.emsi.customerservice;

import ma.emsi.customerservice.dao.entities.Customer;
import ma.emsi.customerservice.dao.repository.CustomerRepository;
import ma.emsi.customerservice.web.CustomerRestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "ma.emsi.customerservice.dao.repository")
@EntityScan(basePackages= "ma.emsi.customerservice.dao.entities")
@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerRestController customerRestController){
        return args -> {
            customerRestController.saveCustomer(Customer.builder().name("XTest").email("Xtest@gmail.com").build());
            customerRestController.saveCustomer(Customer.builder().name("YTest").email("Ytest@gmail.com").build());
            customerRestController.saveCustomer(Customer.builder().name("ahmed").email("ahmed@gmail.com").build());
            customerRestController.saveCustomer(Customer.builder().name("achraf").email("achraf@gmail.com").build());
            customerRestController.saveCustomer(Customer.builder().name("kamal").email("kamal@gmail.com").build());

            System.out.println(customerRestController.customerList());
        };
    }

}

/*
*CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("X").email("X@gmail.com").build());
            customerRepository.save(Customer.builder().name("Y").email("X@gmail.com").build());
        };
    }
* */
