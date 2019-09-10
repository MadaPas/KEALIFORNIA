package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public int addOne(Booking newBooking){
        String sql = "INSERT INTO booking (room_id, customer_id, start_date, end_date, no_of_guests) VALUES(?,?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((Connection connection)->{

            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});

            ps.setInt(1, newBooking.getRoomId());
            ps.setInt(2, newBooking.getCustomerId());
            ps.setObject(3, newBooking.getStartDate());
            ps.setObject(4, newBooking.getEndDate());
            ps.setInt(5, newBooking.getNoOfGuests());

            return ps;
        },keyHolder);

        return keyHolder.getKey().intValue();


    }

    public List<Booking> findBetweenDates(String startDate, String endDate){
        LocalDate sDate = LocalDate.parse(startDate);
        LocalDate eDate = LocalDate.parse(endDate);

        System.out.println("received start date: " + sDate);
        System.out.println("received end date  : " + eDate);

        // Get all bookings
        List<Booking> allBookings = findAll();
        List<Booking> sortedBookings = new ArrayList<>();

        // Iterate over each booking
        for (Booking cBooking : allBookings) {

            LocalDate cStartDate = cBooking.getStartDate();
            LocalDate cEndDate = cBooking.getEndDate();
            // implement voodoo to give us only bookings that interfere (or dont) with provided time period
            // help

            // if current booking ends in the period OR starts in the period
            if((cEndDate.isBefore(eDate) && (cEndDate.isAfter(sDate))) || (cStartDate.isAfter(sDate) && cStartDate.isBefore(eDate))){
                System.out.println("date with id of "+cBooking.getId() + " is in given period");
                //allBookings.remove(cBooking);
                sortedBookings.add(cBooking);
            }
        }

        System.out.println("Iteration of bookings complete.");

        //String sql = "SELECT * FROM booking WHERE date BETWEEN '" + startDate + "' AND '" + endDate + "'";
        //return jdbc.query(sql, new BeanPropertyRowMapper<>(Booking.class));
        return sortedBookings;

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
        String sql = "UPDATE booking SET room_id = ?, user_id = ?, start_date = ?, end_date = ?, no_of_guests = ? WHERE id = "+id;
        jdbc.update(sql, updatedBooking.getRoomId(), updatedBooking.getCustomerId(), updatedBooking.getStartDate(), updatedBooking.getNoOfGuests());
    }

}
