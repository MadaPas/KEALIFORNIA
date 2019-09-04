package com.kea.jymp.demo.controllers;


import com.kea.jymp.demo.models.Customer;
import com.kea.jymp.demo.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    // Get all customers
    @GetMapping("/api/customers")
    @ResponseBody
    public List<Customer> findAll() {
        List<Customer> customers = customerRepo.findAll();
        return customers;
    }

    // Get one customer
    @GetMapping("/api/customers/{id}")
    @ResponseBody
    public Customer findOne(@PathVariable int id) {
        return customerRepo.findOne(id);
    }

    // Delete one customer
    @CrossOrigin
    @DeleteMapping("/api/customers/{id]")
    @ResponseBody
    public void deleteOne(@PathVariable int id) {
        customerRepo.deleteOne(id);
    }

    // Update one customer
    @CrossOrigin
    @PutMapping("/api/customers/{id]")
    @ResponseBody
    public void updateOne(@PathVariable int id, @RequestBody Customer updatedObject){

        System.out.println("dd");
        System.out.println(updatedObject);
        customerRepo.updateOne(id, updatedObject);

    }

}
