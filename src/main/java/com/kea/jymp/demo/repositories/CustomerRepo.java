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

    public Customer findOne(int id) {
        String sql = "SELECT * FROM customer where id = "+id;
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public void deleteOne(int id) {
        String sql = "DELETE FROM customer WHERE id = " + id;
        jdbc.update(sql);
    }

    public void updateOne(int id, Customer updatedObject){
        String sql = "UPDATE customer SET first_name = ?, last_name = ?, email = ?";
        jdbc.update(sql, updatedObject.getFirstName(), updatedObject.getLastName(), updatedObject.getEmail());
    }


}
