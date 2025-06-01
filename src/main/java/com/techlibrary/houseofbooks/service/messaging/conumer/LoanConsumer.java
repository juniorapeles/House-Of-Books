package com.techlibrary.houseofbooks.service.messaging.conumer;

import com.techlibrary.houseofbooks.service.dto.LoanDTO;
import lombok.Getter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class LoanConsumer {

    private final List<LoanDTO> loanMessages = new ArrayList<>();

    @RabbitListener(queues = "${queue.loan}")
    public void receiveMessage(LoanDTO dto) {

        System.out.println("Recenido empréstimo: " + dto);
        loanMessages.add(dto);
    }

}
