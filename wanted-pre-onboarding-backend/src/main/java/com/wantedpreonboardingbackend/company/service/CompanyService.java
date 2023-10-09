package com.wantedpreonboardingbackend.company.service;

import com.wantedpreonboardingbackend.company.repository.Company;
import com.wantedpreonboardingbackend.company.repository.CompanyRipository;
import com.wantedpreonboardingbackend.error.BusinessLogicException;
import com.wantedpreonboardingbackend.error.ExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {
    private final CompanyRipository companyRipository;

    @Transactional
    public Company enroll(Company company) {
          return   companyRipository.save(company);
    }
    @Transactional(readOnly = true)
    public Company findByCompanyId(Long companyId) {
        return companyRipository.findById(companyId).orElseThrow(()->new BusinessLogicException(ExceptionCode.NOSUCHFOUND));
    }
}
