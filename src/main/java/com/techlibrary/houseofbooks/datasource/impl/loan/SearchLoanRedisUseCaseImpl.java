package com.techlibrary.houseofbooks.datasource.impl.loan;

import com.techlibrary.houseofbooks.service.cache.LoanRedisService;
import com.techlibrary.houseofbooks.datasource.def.loan.SearchLoanUseCase;
import com.techlibrary.houseofbooks.service.dto.LoanDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchLoanRedisUseCaseImpl implements SearchLoanUseCase {

    private final LoanRedisService redisCacheService;

    public SearchLoanRedisUseCaseImpl(LoanRedisService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @Override
    public List<LoanDTO> execute() {
        Object cached = redisCacheService.getAllPendingLoans();

        if (cached != null) {
            // cast seguro se você controlar o que salva
            return (List<LoanDTO>) cached;
        }

        // Se quiser só cache puro, retorna lista vazia
        return List.of();
    }
}
