package github.pablwoaraujo.forumHub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.pablwoaraujo.forumHub.models.dtos.UserRequestDto;
import github.pablwoaraujo.forumHub.models.entities.User;
import github.pablwoaraujo.forumHub.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional
	public User create(UserRequestDto dto) {
		if (repository.findByEmail(dto.email()) != null) {
			throw new RuntimeException("Email já cadastrado");
		}

		User user = new User(dto.name(), dto.email(), dto.password());
		User newUser = repository.save(user);

		return newUser;
	}

	public List<User> all() {
		return repository.findAll();
	}
}
