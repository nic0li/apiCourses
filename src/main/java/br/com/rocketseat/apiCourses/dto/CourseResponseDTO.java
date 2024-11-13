package br.com.rocketseat.apiCourses.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CourseResponseDTO {

    private Long id;

    private String name;

    private String category;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
