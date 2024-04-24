package cue.edu.co.service.impl;

import cue.edu.co.Database.DataBaseConnection;
import cue.edu.co.mapping.mappers.StudentMapper;
import cue.edu.co.model.Student;
import cue.edu.co.repository.Repository;
import cue.edu.co.repository.impl.StudentsJDBCImpl;
import cue.edu.co.service.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Service {

    @Override
    public List<Student> listStudent() {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Juan", "test@gmail.com", 1));
        students.add(new Student(1, "Luis", "test@gmail.com", 3));
        students.add(new Student(1, "Marcos", "test@gmail.com", 5));
        students.add(new Student(1, "Juan", "test@gmail.com", 2));

        return students;

        /*
        return studentRepository.list()


                .stream()
                .map(StudentMapper::mapFromModel)
                .toList();

                 */
    }
}
