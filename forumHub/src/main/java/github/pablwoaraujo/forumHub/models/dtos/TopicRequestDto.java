package github.pablwoaraujo.forumHub.models.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record TopicRequestDto(@NotBlank String title, @NotBlank String message, @NotBlank String status,
		@NotBlank UUID user_id, @NotBlank UUID course_id) {

}
