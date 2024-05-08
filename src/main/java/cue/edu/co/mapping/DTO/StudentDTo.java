package cue.edu.co.mapping.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
public record StudentDTo(Integer id, String name, String email, Integer semester) {
}
