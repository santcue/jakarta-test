package cue.edu.co.test.mapping.mappers;

import cue.edu.co.test.mapping.DTO.StudentDTo;
import cue.edu.co.test.model.Student;

public class StudentMapper {

    public static StudentDTo mapFromModel(Student student) {
        return new StudentDTo(student.getId(), student.getName(), student.getEmail(), student.getSemester());
    }

    public static Student mapFromDTO(StudentDTo studentDTo) {
        return Student.builder()
                .id(studentDTo.id())
                .name(studentDTo.name())
                .email(studentDTo.email())
                .semester(studentDTo.semester())
                .build();
    }

}
