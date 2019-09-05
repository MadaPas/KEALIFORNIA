package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepo {

    @Autowired
    private JdbcTemplate jdbc;

    // Maps one-to-many JOIN query into Bookings and List<Tickets> in each Booking
    private final ResultSetExtractor<List<Room>> resultSetExtractor =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .addKeys("id")
                    .newResultSetExtractor(Room.class);


    public List<Room> findAll() {
        String sql = getJoinedQuery();
        List<Room> rooms = jdbc.query(sql, resultSetExtractor);
        System.out.println(rooms);
        return rooms;
    }
    public Room findOne(int id) {
        String sql = "SELECT * FROM room WHERE id = "+id;
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Room.class));

    }

    private String getJoinedQuery() {
        String query =
                "SELECT r.id as id, r.isFree," +
                        "rt.id as roomType_id, rt.name as roomType_name, rt.capacity as roomType_capacity, rt.price as roomType_price" +
                        " FROM room r" +
                        " JOIN roomType rt ON rt.id = r.type_id";
        return query;
    }

    public void deleteOne(int id){
        String sql = "DELETE FROM room WHERE ID = "+id;
        jdbc.update(sql);
    }



}
