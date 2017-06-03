package com.jees.firstspring.dao;

import com.jees.firstspring.dto.BDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BDao {
    private JdbcTemplate jdbcTemplate;

    public BDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<BDto> list(String name) {
        ArrayList<BDto> dtos = (ArrayList<BDto>) jdbcTemplate.query(
                "select * from mvc_board where bId = 1",
                new RowMapper<BDto>() {
                    @Override
                    public BDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        BDto bDto = new BDto(
                                rs.getString("bTitle"),
                                rs.getString("bContext"),
                                rs.getTimestamp("bDate"),
                                rs.getInt("bHit"));

                        return bDto;
                    }
                }, name);
        return dtos;
    }
}
