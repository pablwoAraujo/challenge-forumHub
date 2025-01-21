package github.pablwoaraujo.forumHub.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {

	@Id
	private UUID id;

	@Column(columnDefinition = "TEXT")
	private String solution;

	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	public Answer() {
	}

	public UUID getId() {
		return id;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}