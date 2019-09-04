package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomTypeRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public List<RoomType> findAll() {
        String sql = "SELECT * FROM roomType";
        List<RoomType> roomTypes = jdbc.query(sql, new BeanPropertyRowMapper<>(RoomType.class));
        return roomTypes;
    }

    public RoomType findOne(int typeId) {

        String sql = "SELECT * FROM roomType WHERE id = "+typeId;
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(RoomType.class));

    }



}
