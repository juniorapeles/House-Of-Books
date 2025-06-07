package com.techlibrary.features.loan.mapper;

import com.techlibrary.features.loan.dto.LoanDTO;
import com.techlibrary.features.loan.domain.Loan;
import com.techlibrary.generics.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper extends GenericMapper<Loan, LoanDTO> {

}