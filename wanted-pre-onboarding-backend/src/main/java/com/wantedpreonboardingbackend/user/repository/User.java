package com.wantedpreonboardingbackend.user.repository;

import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNotice;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "userTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String email;

    @ManyToOne()
    @JoinColumn(name = "recruitmentNoticeId")
    private RecruitmentNotice recruitmentNotice;
}
