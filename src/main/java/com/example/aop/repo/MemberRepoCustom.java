package com.example.aop.repo;

import com.example.aop.domain.Member;
import com.example.aop.dto.MemberModifyDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepoCustom {
    void modifyInfo(MemberModifyDto modifyDto);
}
