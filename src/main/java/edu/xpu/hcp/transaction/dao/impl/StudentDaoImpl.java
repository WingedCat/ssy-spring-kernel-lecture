package edu.xpu.hcp.transaction.dao.impl;

import edu.xpu.hcp.transaction.dao.StudentDao;
import edu.xpu.hcp.transaction.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void saveStudent(Student student) {
        String sql = "insert into student(name,age) values (?,?)";
        this.jdbcTemplate.update(sql,student.getName(),student.getAge());
    }
}
