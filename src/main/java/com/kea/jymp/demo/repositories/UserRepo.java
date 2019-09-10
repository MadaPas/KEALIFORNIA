package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.User;
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
public class UserRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public int addOne(User newUser){

        String sql = "INSERT INTO user (first_name, last_name, email) VALUES(?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((Connection connection)->{

            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});

            ps.setString(1, newUser.getFirstName());
            ps.setString(2, newUser.getLastName());
            ps.setString(3, newUser.getEmail());

            return ps;
        },keyHolder);

        return keyHolder.getKey().intValue();



    }

    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        List<User> users = jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    public User findOne(int id) {
        String sql = "SELECT * FROM user where id = "+id;
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public void deleteOne(int id) {
        String sql = "DELETE FROM user WHERE id = " + id;
        jdbc.update(sql);
    }

    public void updateOne(int id, User updatedObject){
        String sql = "UPDATE user SET first_name = ?, last_name = ?, email = ?";
        jdbc.update(sql, updatedObject.getFirstName(), updatedObject.getLastName(), updatedObject.getEmail());
    }


}
