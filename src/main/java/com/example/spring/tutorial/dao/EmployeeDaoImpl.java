package com.example.spring.tutorial.dao;

import com.example.spring.tutorial.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



//    @Override
    //saving employee data by using jdbc template
//    public Employee save(Employee employee) {
//        jdbcTemplate.update("insert into emplyoees(id, name) values(?, ?)", employee.getId(), employee.getName());
//        return employee;
//    }

    @Override
    //saving employee data by using namedParameterJdbcTemplate
    public Employee save(Employee employee) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", employee.getId());
        map.put("name", employee.getName());
        namedParameterJdbcTemplate.update("insert into employees(id, name) values(:id, :name)", map);
        return employee;
    }

    @Override
    public Employee get(long id) {
        return jdbcTemplate.queryForObject("select * from employees where id = ?",
                (rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("name"))
                , id);

    }

    @Override
    public List<Employee> getAll() {

        return jdbcTemplate.query("select * from employees",( rs, rowNum) ->
               new Employee(rs.getLong("id"),rs.getString("name"))
        );
    }
}
