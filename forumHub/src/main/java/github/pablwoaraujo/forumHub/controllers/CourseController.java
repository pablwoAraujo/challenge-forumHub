package github.pablwoaraujo.forumHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import github.pablwoaraujo.forumHub.models.dtos.CourseRequestDto;
import github.pablwoaraujo.forumHub.models.entities.Course;
import github.pablwoaraujo.forumHub.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService service;

	@PostMapping
	public ResponseEntity<Course> register(@RequestBody CourseRequestDto data) {
		Course result = service.create(data);
		var uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/course/{id}")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(uri).body(result);
	}

	@GetMapping
	public ResponseEntity<Page<Course>> all(
			@PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pagination) {
		Page<Course> page = service.search(pagination);

		return ResponseEntity.ok(page);
	}
}
