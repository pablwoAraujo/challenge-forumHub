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
@Table(name = "topics")
public class Topic {

	@Id
	private UUID id;

	@Column(length = 128, nullable = false)
	private String title;

	@Column(length = 16000)
	private String message;

	@Column(length = 128)
	private String status;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	public Topic() {
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}