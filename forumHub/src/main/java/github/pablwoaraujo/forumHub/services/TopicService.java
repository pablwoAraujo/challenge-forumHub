package github.pablwoaraujo.forumHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.pablwoaraujo.forumHub.models.entities.Topic;
import github.pablwoaraujo.forumHub.repositories.TopicRepository;
import jakarta.transaction.Transactional;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	@Transactional
	public Topic create(Topic topic) {
		Topic newTopic = repository.save(topic);

		return newTopic;
	}
}
