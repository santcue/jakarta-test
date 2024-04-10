package cue.edu.co.test.repository;

import cue.edu.co.test.model.Student;

import java.util.List;

public interface Repository <T> {

    List<T> list();
    T byId(int id);
    void save(T t);
    void delete(int id);
    void update(T t);

}
