package cue.edu.co.model;

import jakarta.enterprise.context.SessionScoped;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@SessionScoped
public class Student implements Serializable {

    private int id;
    private String name;
    private String email;
    private int semester;

}
