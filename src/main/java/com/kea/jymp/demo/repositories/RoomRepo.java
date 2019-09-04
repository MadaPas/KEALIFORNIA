package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Room> findAll() {
        String sql = "SELECT * FROM room";
        List<Room> rooms = jdbc.query(sql, new BeanPropertyRowMapper<>(Room.class));
        return rooms;
    }
    public Room findOne(int id) {
        String sql = "SELECT * FROM room WHERE id = "+id;
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Room.class));

    }



}
