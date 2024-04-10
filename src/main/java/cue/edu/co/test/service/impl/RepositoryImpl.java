package cue.edu.co.test.service.impl;

import cue.edu.co.test.Database.DataBaseConnection;
import cue.edu.co.test.mapping.mappers.StudentMapper;
import cue.edu.co.test.model.Student;
import cue.edu.co.test.repository.Repository;
import cue.edu.co.test.repository.impl.StudentsJDBCImpl;
import cue.edu.co.test.service.Service;

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
