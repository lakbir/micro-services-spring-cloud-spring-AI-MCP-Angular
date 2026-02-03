package net.lakbir.customerservice;

import net.lakbir.customerservice.entities.Customer;
import net.lakbir.customerservice.repository.CustomerRepository;
import net.lakbir.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService) {
        return args -> {
            List<String> customers = List.of("Lakbir", "Abderrahim", "John Doe");
            customers.forEach(c -> {
                customerService.save(Customer.builder()
                        .name(c)
                        .email(c+"@gmail.com")
                        .build());
            });
        };
    }

}
