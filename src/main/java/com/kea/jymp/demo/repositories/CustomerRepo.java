package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        List<Customer> customers = jdbc.query(sql, new BeanPropertyRowMapper<>(Customer.class));
        return customers;
    }



}
