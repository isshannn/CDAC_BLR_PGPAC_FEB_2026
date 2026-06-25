package com.samvas.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.samvas.model.Student;

public class StudentDAO {
	private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(
            JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Student student) {

        String sql =
                "insert into student values(?,?,?)";

        return jdbcTemplate.update(
                sql,
                student.getId(),
                student.getName(),
                student.getCourse());
    }

    public List<Student> getAllStudents() {

        String sql =
                "select * from student";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<Student>(
                        Student.class));
    }

}
