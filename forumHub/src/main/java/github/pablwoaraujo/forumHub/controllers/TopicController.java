package github.pablwoaraujo.forumHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import github.pablwoaraujo.forumHub.models.entities.Topic;
import github.pablwoaraujo.forumHub.services.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService service;

	@PostMapping
	public ResponseEntity<Topic> register(@RequestBody Topic topic) {
		Topic result = service.create(topic);
		var uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/topic/{id}")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(uri).body(result);
	}

}
