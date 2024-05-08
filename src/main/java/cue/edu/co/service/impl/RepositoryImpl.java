package cue.edu.co.service.impl;
import cue.edu.co.model.Student;
import cue.edu.co.repository.impl.StudentsJDBCImpl;
import cue.edu.co.service.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryImpl implements Service<Student> {

    private StudentsJDBCImpl studentRepository;

    public RepositoryImpl(Connection connection) {
        this.studentRepository = new StudentsJDBCImpl(connection);
    }

    private final List<Student> students = new ArrayList<>();

    public RepositoryImpl() {
        students.add(new Student(1, "Juan", "test@gmail.com", 1));
        students.add(new Student(2, "Luis", "test@gmail.com", 3));
        students.add(new Student(3, "Marcos", "test@gmail.com", 5));
        students.add(new Student(4, "Juan", "test@gmail.com", 2));
    }

    @Override
    public List<Student> listStudent() {

        return students;

        /*
        return studentRepository.list()


                .stream()
                .map(StudentMapper::mapFromModel)
                .toList();

                 */
    }

    @Override
    public List<Student> list() {

        return studentRepository.list();

    }

    @Override
    public Optional<Student> byId(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }
}
