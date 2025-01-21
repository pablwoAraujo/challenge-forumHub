package github.pablwoaraujo.forumHub.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(@NotBlank String name, @NotBlank String email, @NotBlank String password) {

}
