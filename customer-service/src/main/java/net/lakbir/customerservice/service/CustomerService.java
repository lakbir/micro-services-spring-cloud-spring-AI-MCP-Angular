package net.lakbir.customerservice.service;


import lombok.AllArgsConstructor;
import net.lakbir.customerservice.entities.Customer;
import net.lakbir.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lakbir.abderrahim on 03/02/2026
 */

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
