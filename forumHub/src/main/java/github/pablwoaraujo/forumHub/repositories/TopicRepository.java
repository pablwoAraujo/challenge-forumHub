package github.pablwoaraujo.forumHub.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.pablwoaraujo.forumHub.models.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, UUID> {

	Page<Topic> findAll(Pageable pagination);

	boolean existsByTitleAndMessageIgnoreCase(String title, String message);

}
