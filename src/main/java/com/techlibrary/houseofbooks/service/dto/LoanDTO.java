package com.techlibrary.houseofbooks.service.dto;

import com.techlibrary.houseofbooks.service.enums.EStatus;

public record LoanDTO(
        Long loanId,
        Long userId,
        Long bookId,
        EStatus status
) {}