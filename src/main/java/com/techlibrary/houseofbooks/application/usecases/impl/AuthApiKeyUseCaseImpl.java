//package com.techlibrary.houseofbooks.application.usecases.impl;
//
//import com.techlibrary.houseofbooks.application.usecases.AuthApiKeyUseCase;
//import com.techlibrary.houseofbooks.infrastructure.persistence.ApiKeyRepository;
//import com.techlibrary.houseofbooks.infrastructure.security.JwtService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthApiKeyUseCaseImpl implements AuthApiKeyUseCase {
//
//    private final ApiKeyRepository apiKeyRepository;
//    private final JwtService jwtUtil;
//
//    public AuthApiKeyUseCaseImpl(ApiKeyRepository apiKeyRepository, JwtService jwtUtil) {
//        this.apiKeyRepository = apiKeyRepository;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Override
//    public String execute(String apiKey) {
//        return apiKeyRepository.findByApiKey(apiKey)
//                .map(client -> jwtUtil.generateToken(client.getName()))
//                .orElseThrow(() -> new RuntimeException("Api Key Inválida"));
//
//    }
//}
