package br.com.rocketseat.apiCourses.service;

import br.com.rocketseat.apiCourses.dto.CourseRequestDTO;
import br.com.rocketseat.apiCourses.dto.CourseResponseDTO;
import br.com.rocketseat.apiCourses.model.Course;
import br.com.rocketseat.apiCourses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();
        course.setName(courseRequestDTO.getName());
        course.setCategory(courseRequestDTO.getCategory());
        course = courseRepository.save(course);
        return toCourseResponseDTO(course);
    }

    public List<CourseResponseDTO> getAllCourses(String name, String category) {
        return courseRepository.findByNameContainingAndCategoryContaining(name, category)
                .stream()
                .map(this::toCourseResponseDTO)
                .collect(Collectors.toList());
    }

    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        if (courseRequestDTO.getName() != null && !courseRequestDTO.getName().isBlank()) {
            course.setName(courseRequestDTO.getName());
        }
        if (courseRequestDTO.getCategory() != null && !courseRequestDTO.getCategory().isBlank()) {
            course.setCategory(courseRequestDTO.getCategory());
        }
        course = courseRepository.save(course);
        return toCourseResponseDTO(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public CourseResponseDTO toggleCourseActive(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setActive(!course.getActive());
        course = courseRepository.save(course);
        return toCourseResponseDTO(course);
    }

    private CourseResponseDTO toCourseResponseDTO(Course course) {
        return new CourseResponseDTO(
                course.getId(),
                course.getName(),
                course.getCategory(),
                course.getActive(),
                course.getCreatedAt(),
                course.getUpdatedAt()
        );
    }
}
