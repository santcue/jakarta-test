package cue.edu.co.test.mapping.DTO;

import lombok.Builder;

@Builder
public record StudentDTo(Integer id, String name, String email, Integer semester) {
}
