package github.pablwoaraujo.forumHub.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import github.pablwoaraujo.forumHub.models.dtos.TopicRequestDto;
import github.pablwoaraujo.forumHub.models.dtos.UpdateTopicRequestDto;
import github.pablwoaraujo.forumHub.models.entities.Course;
import github.pablwoaraujo.forumHub.models.entities.Topic;
import github.pablwoaraujo.forumHub.models.entities.User;
import github.pablwoaraujo.forumHub.repositories.CourseRepository;
import github.pablwoaraujo.forumHub.repositories.TopicRepository;
import github.pablwoaraujo.forumHub.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Transactional
	public Topic create(TopicRequestDto data) {
		Optional<User> user = userRepository.findById(data.user_id());
		Optional<Course> course = courseRepository.findById(data.course_id());

		if (user.isEmpty() || course.isEmpty())
			throw new RuntimeException("Usuário ou Curso não encontrado.");

		if (topicRepository.existsByTitleAndMessageIgnoreCase(data.title(), data.message()))
			throw new RuntimeException("Tópico já cadastrado, tente outro título ou mensagem.");

		Topic topic = new Topic(data.title(), data.message(), data.status(), user.get(), course.get());
		Topic newTopic = topicRepository.save(topic);

		return newTopic;
	}

	public Page<Topic> search(Pageable pagination) {
		Page<Topic> topics = topicRepository.findAll(pagination);

		return topics;
	}

	public Page<Topic> all(Pageable pagination) {
		Page<Topic> topics = topicRepository.findAll(pagination);

		return topics;
	}

	public Optional<Topic> findById(UUID id) {
		return topicRepository.findById(id);
	}

	public void delete(UUID id) {
		Optional<Topic> topic = this.findById(id);

		if (topic.isEmpty()) {
			throw new RuntimeException("Tópico não encontrado.");
		}

		topicRepository.deleteById(id);
	}

	public Optional<Topic> update(UUID id, UpdateTopicRequestDto data) {
		Optional<Topic> topicOptional = this.findById(id);

		if (topicOptional.isEmpty()) {
			throw new RuntimeException("Tópico não encontrado.");
		}

		Topic topic = topicOptional.get();

		if (data.title() != null && !data.title().isEmpty()) {
			topic.setTitle(data.title());
		}

		if (data.message() != null && !data.message().isEmpty()) {
			topic.setMessage(data.message());
		}

		topic = topicRepository.save(topic);
		return Optional.of(topic);
	}
}
