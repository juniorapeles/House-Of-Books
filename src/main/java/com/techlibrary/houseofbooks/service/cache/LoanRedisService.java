package com.techlibrary.houseofbooks.service.cache;

import com.techlibrary.houseofbooks.service.dto.LoanDTO;
import org.hibernate.type.SerializationException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoanRedisService {

    private static final String KEY = "loan:pending";

    private final RedisTemplate<String, Object> redisTemplate;

    public LoanRedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveLoan(LoanDTO dto) {
        redisTemplate.opsForHash().put(KEY, dto.loanId().toString(), dto);
    }

    public LoanDTO getLoan(Integer id) {
        return (LoanDTO) redisTemplate.opsForHash().get(KEY, id.toString());
    }

    public List<LoanDTO> getAllPendingLoans() {
        try {
            Map<Object, Object> loans = redisTemplate.opsForHash().entries(KEY);
            return loans.values().stream()
                    .map(loan -> (LoanDTO) loan)
                    .collect(Collectors.toList());
        } catch (SerializationException e) {
            System.err.println("Error deserializing Redis data, clearing cache" + e);
            return Collections.emptyList();
        }
    }

    public void deleteLoan(Integer id) {
        redisTemplate.opsForHash().delete(KEY, id.toString());
    }
}
