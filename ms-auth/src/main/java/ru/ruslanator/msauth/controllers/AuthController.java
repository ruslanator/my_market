package ru.ruslanator.msauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ruslanator.corelib.interfaces.ITokenService;
import ru.ruslanator.corelib.models.UserInfo;
import ru.ruslanator.corelib.repositories.RedisRepository;
import ru.ruslanator.msauth.dtos.AuthRequestDto;
import ru.ruslanator.msauth.dtos.AuthResponseDto;
import ru.ruslanator.msauth.dtos.SignUpRequestDto;
import ru.ruslanator.msauth.entities.User;
import ru.ruslanator.msauth.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private ITokenService iTokenService;

    @Autowired
    private RedisRepository redisRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody SignUpRequestDto signUpRequest) {
        User user = new User();
        user.setPassword(signUpRequest.getPassword());
        user.setEmail(signUpRequest.getEmail());
        userService.saveUser(user);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto request) {
        User user = userService.findByLoginAndPassword(request.getEmail(), request.getPassword());
        List<String> roles = new ArrayList<>();
        user.getRole().forEach(role -> roles.add(role.getName()));
        UserInfo userInfo = UserInfo.builder()
                .userId(user.getId())
                .userEmail(user.getEmail())
                .role(roles)
                .build();
        String token = iTokenService.generateToken(userInfo);
        return new AuthResponseDto(token);
    }

    @GetMapping("/logout")
    public Boolean logout(@RequestHeader("Authorization") String token) {
        redisRepository.saveToken(token);
        return true;
    }
}
