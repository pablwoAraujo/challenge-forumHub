package github.pablwoaraujo.forumHub.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.pablwoaraujo.forumHub.models.dtos.JWTResponseDto;
import github.pablwoaraujo.forumHub.models.dtos.LoginRequestDto;
import github.pablwoaraujo.forumHub.models.entities.User;
import github.pablwoaraujo.forumHub.services.TokenService;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTResponseDto> efetuarLogin(@RequestBody @Valid LoginRequestDto dados) {
    	System.out.println(dados);
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
    	System.out.println(token);

        var authentication = manager.authenticate(token);
    	System.out.println(authentication);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new JWTResponseDto(tokenJWT));
    }
}