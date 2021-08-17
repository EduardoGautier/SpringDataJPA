package com.example.spring.rest;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.spring.entity.Customer;
import com.example.spring.repository.CustomerRepository;


@RestController
@RequestMapping("/data")
public class CustommerController {
	@Autowired
	CustomerRepository crepository;

	@GetMapping("/")
	public Iterable<Customer>getIterable() {
		return crepository.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Customer> getIterable(@PathVariable Long id) {
		return crepository.findById(id);
	}
	
	
}
