package com.example.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBClient {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> fetchAll() {
        return jdbcTemplate.query("select * from student", (rs, n)-> {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setClazz(rs.getInt("class"));
            student.setRollNumber(rs.getInt("rollnumber"));
            student.setSection(rs.getString("section"));
            return student;
        });

    }


}
