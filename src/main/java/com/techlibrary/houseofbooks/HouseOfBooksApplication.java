package com.techlibrary.houseofbooks;

import com.techlibrary.houseofbooks.messaging.producer.LoanProducer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HouseOfBooksApplication {

    @Autowired
    private LoanProducer loanProducer;

    public static void main(String[] args) {
        SpringApplication.run(HouseOfBooksApplication.class, args);
    }

    @PostConstruct
    public void sendTestMessage() {
        loanProducer.sendMessage("Mensagem de teste do producer");
    }
}
