package github.pablwoaraujo.forumHub.configs;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import github.pablwoaraujo.forumHub.repositories.UserRepository;
import github.pablwoaraujo.forumHub.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var tpkenJWT = recuperarToken(request);

		if (tpkenJWT != null) {
			var subject = tokenService.getSujeito(tpkenJWT);
			var usuario = userRepository.findByEmail(subject);

			var autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(autenticacao);
		}

		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		var token = request.getHeader("Authorization").trim();
		System.out.println(token);
		if (token == null || token.isBlank() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.replace("Bearer ", "");
	}
}