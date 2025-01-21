package github.pablwoaraujo.forumHub.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {

	@Id
	private UUID id;

	@Column(length = 64)
	private String name;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	public Profile() {
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}