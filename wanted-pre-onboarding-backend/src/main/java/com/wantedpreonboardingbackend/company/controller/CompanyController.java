package com.wantedpreonboardingbackend.company.controller;

import com.wantedpreonboardingbackend.company.dto.CompanyRequestDto;
import com.wantedpreonboardingbackend.company.dto.CompanyResponseDto;
import com.wantedpreonboardingbackend.company.repository.Company;
import com.wantedpreonboardingbackend.company.service.CompanyService;
import com.wantedpreonboardingbackend.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
@Slf4j
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("")
    public Response.SuccessResponse enrollCompany(@RequestBody CompanyRequestDto companyRequestDto){
        Company company = companyService.enroll(companyRequestDto.CompanyDtoToEntity(companyRequestDto));
        return new Response.SuccessResponse<>(company.CompanyEntityToResponseDto(company), HttpStatus.CREATED);
    }
}
