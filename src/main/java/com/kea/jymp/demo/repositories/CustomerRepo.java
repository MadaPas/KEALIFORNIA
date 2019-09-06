package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public int addOne(Customer newCustomer){

        String sql = "INSERT INTO customer (first_name, last_name, email) VALUES(?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((Connection connection)->{

            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});

            ps.setString(1, newCustomer.getFirstName());
            ps.setString(2, newCustomer.getLastName());
            ps.setString(3, newCustomer.getEmail());

            return ps;
        },keyHolder);

        return keyHolder.getKey().intValue();



    }

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
