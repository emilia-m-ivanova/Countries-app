package com.country.service;

import com.country.controller.AuthenticationRequest;
import com.country.controller.AuthenticationResponse;
import com.country.controller.RegisterRequest;
import com.country.exception.UserAlreadyExistsException;
import com.country.model.Role;
import com.country.model.User;
import com.country.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;

  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) throws UserAlreadyExistsException {

    Optional<User> existingUser = userRepository.findByUsername(request.getUsername());
    if(existingUser.isPresent()){
      throw new UserAlreadyExistsException("The provided username is already in use");
    }
    var user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );
    var user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() -> new BadCredentialsException("The username and password do not match"));
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
}
