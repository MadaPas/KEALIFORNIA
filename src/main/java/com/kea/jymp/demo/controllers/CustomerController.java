package com.kea.jymp.demo.controllers;

import com.kea.jymp.demo.models.Customer;
import com.kea.jymp.demo.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    // Get all bookings
    @GetMapping("/api/customers")
    @ResponseBody
    public List<Customer> findAll() {
        List<Customer> customers = customerRepo.findAll();
        return customers;
    }

}
