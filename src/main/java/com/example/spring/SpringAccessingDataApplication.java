package com.example.spring;

import com.example.spring.entity.Customer;
import com.example.spring.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAccessingDataApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringAccessingDataApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringAccessingDataApplication.class);
    }


    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer(1L,"Jack", "Bauer", "Bauer@G.com", "042.540.897.64", "Juan Albino", "(51)98625-8754", "16/04/1998"));
            repository.save(new Customer(2L,"Chloe", "O'Brian", "OBrian@B.com", "042.540.897.64", "Juan Albino", "(51)98625-8754", "16/04/1998"));
            repository.save(new Customer(3L,"Kim", "Bauer", "OBrian@B.com", "042.540.897.64", "Juan Albino", "(51)98625-8754", "16/04/1998"));
            repository.save(new Customer(4L,"David", "Palmer", "Palmer@B.com", "042.540.897.64", "Juan Albino", "(51)98625-8754", "16/04/1998"));
            repository.save(new Customer(5L,"Michelle", "Dessler", "Dessler@B.com", "042.540.897.64", "Juan Albino", "(51)98625-8754", "16/04/1998"));
            repository.save(new Customer(6L,"Gilmar", "A4", "A4@B.com", "042.540.897.64", "Juan Albino", "(51)98625-8754", "16/04/1998"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}
