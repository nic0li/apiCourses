package br.com.rocketseat.apiCourses.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CourseRequestDTO {

    @NotBlank(message = "O nome do curso é obrigatório.")
    private String name;

    @NotBlank(message = "A categoria do curso é obrigatória.")
    private String category;

}
