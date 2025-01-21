package github.pablwoaraujo.forumHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import github.pablwoaraujo.forumHub.models.entities.Course;
import github.pablwoaraujo.forumHub.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService service;

	@PostMapping
	public ResponseEntity<Course> register(@RequestBody Course course) {
		Course result = service.create(course);
		var uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/course/{id}")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(uri).body(result);
	}

}
