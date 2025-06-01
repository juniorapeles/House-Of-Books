package com.techlibrary.houseofbooks.service.messaging.impl;

import com.techlibrary.houseofbooks.service.messaging.def.CreateMessageUseCase;
import com.techlibrary.houseofbooks.service.messaging.producer.LoanProducer;
import com.techlibrary.houseofbooks.service.dto.LoanDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateMessageUseCaseImpl implements CreateMessageUseCase {

    private final LoanProducer loanProducer;

    public CreateMessageUseCaseImpl(LoanProducer loanProducer) {
        this.loanProducer = loanProducer;
    }

    @Override
    public void execute(LoanDTO dto) {
        loanProducer.send(dto);
    }
}
