package com.kea.jymp.demo.repositories;


import com.kea.jymp.demo.models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepo {
    @Autowired
    private JdbcTemplate jdbc;

    public Hotel findHotelById(int id) {
        Hotel result = null;

        String query = "SELECT * FROM hotel WHERE id =?";
        SqlRowSet rs = jdbc.queryForRowSet(query, id);

        if (rs.first()) {
            result = extractNextHotelFromRowSet(rs);
        }
        return result;
    }

    public List<Hotel> getAllHotels() {
        List<Hotel> result = new ArrayList();

        String query = "SELECT * FROM hotel";
        SqlRowSet rs = jdbc.queryForRowSet(query);

        while (rs.next()) {
            result.add(extractNextHotelFromRowSet(rs));
        }
        return result;
    }

    private Hotel extractNextHotelFromRowSet (SqlRowSet rs) {
        Hotel result = new Hotel();

        result.setId(rs.getInt("id"));
        result.setName(rs.getString("name"));

        return result;
    }


    public List<Integer> getAllHotelsInt() {
        List<Integer> result = new ArrayList();

        String query = "SELECT id FROM hotel;";
        SqlRowSet rs = jdbc.queryForRowSet((query));

        while (rs.next()) {
            result.add(rs.getInt("id"));
        }
        return result;
    }


    public void addHotel (Hotel hotel) {
        jdbc.update("INSERT INTO hotel (name) VALUE " +
                "(?);", hotel.getName());
    }

    public void deleteHotel(int id) {
        jdbc.update("DELETE FROM hotel WHERE id = ?", id);
    }

    public void editHotel (Hotel hotel) {
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement("UPDATE hotel SET name = ? WHERE id = ?");
            ps.setString(1, hotel.getName());
            ps.setInt(2, hotel.getId());

            return ps;
        };

        jdbc.update(psc);
    }

}
