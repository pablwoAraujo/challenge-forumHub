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
@Table(name = "user_profiles")
public class UserProfile {

	@Id
	private UUID id;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "profile_id", nullable = false)
	private Profile profile;

	public UserProfile() {
	}

	public UUID getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public User getUser() {
		return user;
	}

	public Profile getProfile() {
		return profile;
	}
}