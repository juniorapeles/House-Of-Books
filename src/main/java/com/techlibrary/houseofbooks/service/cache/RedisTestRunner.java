package com.techlibrary.houseofbooks.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class RedisTestRunner implements CommandLineRunner {

    private final RedisCacheService redisCacheService;

    public RedisTestRunner(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @Override
    public void run(String... args) throws Exception {
        redisCacheService.save("test-chave","Olá Redis!" );
        Object value = redisCacheService.find("test-chave");
        System.out.println("valor do Redis: "+value);
    }
}
