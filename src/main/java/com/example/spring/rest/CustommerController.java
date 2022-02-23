package com.example.spring.rest;

import java.util.HashMap;
import java.util.Map;

import com.example.spring.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.spring.entity.Customer;
import com.example.spring.repository.CustomerRepository;

import java.util.List;


@RestController
@RequestMapping(value = "/data/customers")

public class CustommerController {
    @Autowired
    CustomerRepository crepository;

    @GetMapping(value = "/")
    public Iterable<Customer> getIterable() {
        return crepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Customer getIterable(@PathVariable Long id) throws ResourceNotFoundException {
        return crepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
    }

    @GetMapping(value = "/last/{lastName}")
    public List<Customer> findByLastName(@PathVariable String lastName) throws ResourceNotFoundException {
        List<Customer> list = crepository.findByLastName(lastName);
        return list;
    }

    // /data/customers?id=10

    @DeleteMapping(value = "/{id}")
    public Map<String, Boolean> deleteById(@PathVariable Long id) throws ResourceNotFoundException {

        Customer customer = crepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        crepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }


    @PutMapping(value = "/")
    public Customer updateCustomer(Long id, Customer customerDetails) throws ResourceNotFoundException {

        Customer customer = crepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());
        customer.setBirthDate(customerDetails.getBirthDate());

        final Customer updatedCustomers = crepository.save(customer);

        return updatedCustomers;
    }

    @PostMapping(value = "/")
    public Customer addNewCustomer(@RequestBody Customer lastName) throws ResourceNotFoundException {
        System.out.println(lastName);
        List<Customer> addressFront = crepository.findByLastName(lastName.getLastName());
        if (addressFront != null) {
            return crepository.save(lastName);
        }
        return null;
    }

}
