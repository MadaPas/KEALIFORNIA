package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Booking> findAll() {
        String sql = "SELECT * FROM booking";
        List<Booking> bookings = jdbc.query(sql, new BeanPropertyRowMapper<>(Booking.class));
        return bookings;
    }

}
