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

    public Booking findOne(int id) {

        String sql = "SELECT * from booking WHERE id = "+id;
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Booking.class));

    }

    public void deleteOne(int id) {
        String sql = "DELETE FROM booking WHERE id = "+id;
        jdbc.update(sql);
    }

    public void updateOne(int id, Booking updatedBooking) {
        String sql = "UPDATE booking SET room_id = ?, customer_id = ?, start_date = ?, end_date = ?, no_of_guests = ? WHERE id = "+id;
        jdbc.update(sql, updatedBooking.getRoomId(), updatedBooking.getCustomerId(), updatedBooking.getStartDate(), updatedBooking.getNoOfGuests());
    }

}
