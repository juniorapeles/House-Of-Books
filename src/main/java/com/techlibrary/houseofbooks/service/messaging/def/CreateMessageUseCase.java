package com.techlibrary.houseofbooks.service.messaging.def;

import com.techlibrary.houseofbooks.service.dto.LoanDTO;

public interface CreateMessageUseCase {
    void execute(LoanDTO dto);
}
