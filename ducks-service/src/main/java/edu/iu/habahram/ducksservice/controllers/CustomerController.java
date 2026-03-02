package edu.iu.habahram.ducksservice.controllers;

import edu.iu.habahram.ducksservice.model.Customer;
import edu.iu.habahram.ducksservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/signup")
    public Customer signup(@RequestBody Customer customer) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        customer.setPassword(encoder.encode(customer.getPassword()));

        return customerRepository.save(customer);
    }
}