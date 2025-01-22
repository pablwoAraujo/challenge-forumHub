package github.pablwoaraujo.forumHub.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record CourseRequestDto(@NotBlank String name, @NotBlank String category) {

}
