package cue.edu.co.test.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Student {

    private int id;
    private String name;
    private String email;
    private int semester;

}
