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

import github.pablwoaraujo.forumHub.models.dtos.TopicRequestDto;
import github.pablwoaraujo.forumHub.models.entities.Topic;
import github.pablwoaraujo.forumHub.services.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService service;

	@PostMapping
	public ResponseEntity<Topic> register(@RequestBody TopicRequestDto data) {
		Topic result = service.create(data);
		var uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/topic/{id}")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(uri).body(result);
	}

	@GetMapping
	public ResponseEntity<Page<Topic>> all(
			@PageableDefault(size = 10, sort = "title", direction = Sort.Direction.ASC) Pageable pagination) {
		Page<Topic> page = service.search(pagination);

		return ResponseEntity.ok(page);
	}

}
