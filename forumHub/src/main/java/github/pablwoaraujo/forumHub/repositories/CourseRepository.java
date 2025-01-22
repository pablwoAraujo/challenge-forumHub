package github.pablwoaraujo.forumHub.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.pablwoaraujo.forumHub.models.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
	Page<Course> findAll(Pageable pagination);

	Course findByName(String name);

}
