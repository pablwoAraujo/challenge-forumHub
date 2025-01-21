package github.pablwoaraujo.forumHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.pablwoaraujo.forumHub.models.entities.Course;
import github.pablwoaraujo.forumHub.repositories.CourseRepository;
import jakarta.transaction.Transactional;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	@Transactional
	public Course create(Course course) {
		Course newCourse = repository.save(course);

		return newCourse;
	}
}
