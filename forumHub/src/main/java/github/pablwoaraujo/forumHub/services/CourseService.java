package github.pablwoaraujo.forumHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import github.pablwoaraujo.forumHub.models.dtos.CourseRequestDto;
import github.pablwoaraujo.forumHub.models.entities.Course;
import github.pablwoaraujo.forumHub.repositories.CourseRepository;
import jakarta.transaction.Transactional;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	@Transactional
	public Course create(CourseRequestDto data) {
		if (repository.findByName(data.name()) != null) {
			throw new RuntimeException("Nome já cadastrado");
		}

		Course course = new Course(data.name(), data.category());
		Course newCourse = repository.save(course);

		return newCourse;
	}

	public Page<Course> search(Pageable pagination) {
		Page<Course> courses = repository.findAll(pagination);

		return courses;
	}
}
