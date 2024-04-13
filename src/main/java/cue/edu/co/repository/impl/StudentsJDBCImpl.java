package cue.edu.co.repository.impl;

import cue.edu.co.Database.DataBaseConnection;
import cue.edu.co.model.Student;
import cue.edu.co.repository.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsJDBCImpl implements Repository<Student> {

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }

    @Override
    public List<Student> list() {
        List<Student> students = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {
            while (resultSet.next()) {
                Student student = createStudent(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los estudiantes", e);
        }
        return students;
    }

    @Override
    public Student byId(int id) {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Student student) {

    }

    private Student createStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setSemester(resultSet.getInt("semester"));
        return student;
    }

}
