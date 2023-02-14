package com.example.aop.repo;

import com.example.aop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Long>, MemberRepoCustom {
}
