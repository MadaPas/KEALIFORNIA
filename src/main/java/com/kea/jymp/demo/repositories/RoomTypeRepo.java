package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.Room;
import com.kea.jymp.demo.models.RoomType;
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
public class RoomTypeRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public List<RoomType> findAll() {
        String sql = "SELECT * FROM roomType";
        List<RoomType> roomTypes = jdbc.query(sql, new BeanPropertyRowMapper<>(RoomType.class));
        return roomTypes;
    }

    public int addOne(RoomType newRoomType){
        String sql = "INSERT INTO roomType (name, capacity, price, description) VALUES(?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((Connection connection)->{

            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});

            ps.setString(1,newRoomType.getName());
            ps.setInt(2,newRoomType.getCapacity());
            ps.setDouble(3,newRoomType.getPrice());
            ps.setString(4,newRoomType.getDescription());

            return ps;
        },keyHolder);

        return keyHolder.getKey().intValue();

    }

    public RoomType findOne(int typeId) {

        String sql = "SELECT * FROM roomType WHERE id = " + typeId;
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(RoomType.class));

    }

    public void deleteOne(int id){
        String sql = "DELETE FROM roomType WHERE id = " + id;
        jdbc.update(sql);
    }

    public void updateOne(int id, RoomType updatedRoomType){
        String sql = "UPDATE roomType SET name = ?, capacity = ?, price = ?, description = ? WHERE id = " + id;
        jdbc.update(sql, updatedRoomType.getName(), updatedRoomType.getCapacity(), updatedRoomType.getPrice(), updatedRoomType.getDescription());
    }

}
