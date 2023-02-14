package com.example.aop.service;

import com.example.aop.domain.Member;
import com.example.aop.dto.MemberModifyDto;
import com.example.aop.repo.MemberRepo;
import com.example.aop.repo.MemberRepoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepo memberRepo;


    @Transactional
    public ResponseEntity<?> modifyInfo(MemberModifyDto modifyDto) {
        Member member = memberRepo.findById(modifyDto.getSeq()).orElseThrow(
                () -> new IllegalArgumentException("유저 없음")
        );
        member.changeInfo(modifyDto); // JPA 영속화 사용
//        memberRepo.modifyInfo(modifyDto); // querydsl 사용
//        System.out.println(modifyDto);
        return ResponseEntity.ok().body(member);
    }
}
