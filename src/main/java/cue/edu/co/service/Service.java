package cue.edu.co.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    List<T> listStudent();
    List<T> list();
    Optional<T> byId(int id);


}
