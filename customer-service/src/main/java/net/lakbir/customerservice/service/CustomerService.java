package net.lakbir.customerservice.service;


import lombok.AllArgsConstructor;
import net.lakbir.customerservice.entities.Customer;
import net.lakbir.customerservice.repository.CustomerRepository;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lakbir.abderrahim on 03/02/2026
 */

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @McpTool(description = "Get all customers")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @McpTool(description = "Fin a customer by id")
    public Customer findById(@McpToolParam(description = "The customer id") Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @McpTool(description = "Save a new customer")
    public Customer save(@McpToolParam(description = "The customer to save (name, email)") Customer customer) {
        return customerRepository.save(customer);
    }
}
