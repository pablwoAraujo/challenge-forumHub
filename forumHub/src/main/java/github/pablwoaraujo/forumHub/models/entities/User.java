package github.pablwoaraujo.forumHub.models.entities;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails {

	@Id
	private UUID id;

	@Column(length = 128, nullable = false)
	private String name;

	@Column(length = 255, nullable = false, unique = true)
	private String email;

	@Column(length = 255, nullable = false)
	private String password;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	public User() {
	}

	public User(String name, String email, String password) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String getUsername() {
		return this.name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}
}