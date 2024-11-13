package br.com.rocketseat.apiCourses.controller;

import br.com.rocketseat.apiCourses.dto.CourseRequestDTO;
import br.com.rocketseat.apiCourses.dto.CourseResponseDTO;
import br.com.rocketseat.apiCourses.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.ok(courseService.createCourse(courseRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String category) {
        return ResponseEntity.ok(courseService.getAllCourses(name, category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id,
                                                          @RequestBody CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<CourseResponseDTO> toggleCourseActive(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.toggleCourseActive(id));
    }

}
