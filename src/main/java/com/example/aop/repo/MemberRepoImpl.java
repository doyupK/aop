package com.example.aop.repo;

import com.example.aop.dto.MemberModifyDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.aop.domain.QMember.member;

@RequiredArgsConstructor
public class MemberRepoImpl implements MemberRepoCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void modifyInfo(MemberModifyDto modifyDto) {
        jpaQueryFactory.update(member)
                .set(member.name, modifyDto.getName())
                .execute();
    }
}
