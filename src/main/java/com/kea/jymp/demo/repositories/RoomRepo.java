package com.kea.jymp.demo.repositories;

import com.kea.jymp.demo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
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

    public int addOne(Room newRoom){
        String sql = "INSERT INTO room (isFree, type_id) VALUES(?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((Connection connection)->{

            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});

            ps.setBoolean(1, newRoom.isFree());
            ps.setInt(2, newRoom.getRoomType().getId());

            return ps;
        },keyHolder);

        return keyHolder.getKey().intValue();

    }




    public List<Room> findAll() {
        String sql = getJoinedQuery();
        List<Room> rooms = jdbc.query(sql, resultSetExtractor);
        System.out.println(rooms);
        return rooms;
    }
    public Room findOne(int id) {
        String sql = getJoinedQuery() + " WHERE r.id = ?";
        List<Room> rooms = jdbc.query(sql, new Object[] {id}, resultSetExtractor);
        return rooms.get(0);

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

    public void updateOne(int id, Room roomToUpdate){
        String sql = "UPDATE room SET isFree = ?, type_id = ? WHERE id = ?;";
        jdbc.update(sql, roomToUpdate.isFree(), roomToUpdate.getRoomType().getId(), id);
    }

}
