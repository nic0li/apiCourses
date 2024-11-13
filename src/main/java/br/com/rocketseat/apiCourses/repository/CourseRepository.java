package br.com.rocketseat.apiCourses.repository;

import br.com.rocketseat.apiCourses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByNameContainingAndCategoryContaining(String name, String category);

}
