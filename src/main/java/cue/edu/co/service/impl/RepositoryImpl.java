package cue.edu.co.service.impl;

import cue.edu.co.Database.DataBaseConnection;
import cue.edu.co.mapping.mappers.StudentMapper;
import cue.edu.co.model.Student;
import cue.edu.co.repository.Repository;
import cue.edu.co.repository.impl.StudentsJDBCImpl;
import cue.edu.co.service.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RepositoryImpl implements Service {

    Connection conn = DataBaseConnection.getInstance();
    private Repository<Student> studentRepository;

    public RepositoryImpl() throws SQLException {
        this.studentRepository = new StudentsJDBCImpl();
    }

    @Override
    public List listStudent() {
        return studentRepository.list()
                .stream()
                .map(StudentMapper::mapFromModel)
                .toList();
    }
}
