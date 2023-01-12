package com.country.controller;

import com.country.exception.UserAlreadyExistsException;
import com.country.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<Object> register(
      @RequestBody RegisterRequest request
  ) {
    try{
      return ResponseEntity.ok(service.register(request));
    } catch (UserAlreadyExistsException ex){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(ex.getMessage());
    }
  }
  @PostMapping("/login")
  public ResponseEntity<Object> login(
      @RequestBody AuthenticationRequest request
  ) {
    try{
      return ResponseEntity.ok(service.authenticate(request));
    } catch (BadCredentialsException ex){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(ex.getMessage());
    }
  }


}
