package com.cydeo.repository;

import com.cydeo.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

@Transactional
public interface CourseRepository extends JpaRepository<Course,Long> {

    // finde the course by category
    List<Course> findCourseByCategory(String Category);

    // find all courses by category and order by the entities by name
    List<Course> findByCategoryOrderByName(String course);

    // check if the course name is exist if so true false otherwise
    Boolean existsCourseByName(String name);

    // count the number of the courses for provided category
    Integer countByCategory(String category);
    // find all courses the starts with the provided course name
    List<Course> findByNameStartingWith(String course);
    // find caurses based on category and return stream

    Stream<Course> streamByCategory(String course);

    // NAME PARAMETER


    @Query("SELECT c FROM Course c WHERE c.category= :category AND c.Rating > :rating")
    List<Course> findAllCoursesByCategoryAndRatingMoreThan(@Param("category") String category, @Param("rating") int rating);


}
