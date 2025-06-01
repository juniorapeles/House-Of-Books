//package com.techlibrary.houseofbooks.service.controller;
//
//import com.techlibrary.houseofbooks.application.security.config.UserRepository;
//import com.techlibrary.houseofbooks.domain.model.User;
//import com.techlibrary.houseofbooks.service.dto.AuthenticationDTO;
//import com.techlibrary.houseofbooks.service.dto.RegisterDTO;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthtenticationController {
//
//
//    private AuthenticationManager authenticationManager;
//    private UserRepository userRepository;
//
//    public AuthtenticationController(AuthenticationManager authenticationManager, UserRepository userRepository) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
//        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
//
//        var auth =  authenticationManager.authenticate(userNamePassword);
//
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody RegisterDTO data) {
//        if (this.userRepository.findByName(data.login()) != null) {
//            return ResponseEntity.badRequest().body("Usuário já existe");
//        }
//
//        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
//        User newUser = new User(data.login(), encryptedPassword, data.role());
//
//        this.userRepository.save(newUser);
//
//        return ResponseEntity.ok().body("Usuário registrado com sucesso");
//    }
//
//}
