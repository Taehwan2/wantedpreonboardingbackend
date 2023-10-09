package com.wantedpreonboardingbackend.recruitmentnotice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Target;
import java.util.List;

public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice,Long> {
   @Query("select s from RecruitmentNotice s where s.company.companyName like CONCAT('%', :name, '%')")
   Page findAllByName(String name, Pageable pageable);
}
