package github.pablwoaraujo.forumHub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import github.pablwoaraujo.forumHub.models.dtos.UserRequestDto;
import github.pablwoaraujo.forumHub.models.entities.User;
import github.pablwoaraujo.forumHub.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> all() {
		List<User> result = service.all();
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(result);
	}
	
	@PostMapping
	public ResponseEntity<User> register(@RequestBody UserRequestDto dto) {
		User user = service.create(dto);
		var uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/{id}")
				.buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).body(user);
	}

}
