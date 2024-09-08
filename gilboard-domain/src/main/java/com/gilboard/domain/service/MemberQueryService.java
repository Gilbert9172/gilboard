package com.gilboard.domain.service;

import com.gilboard.domain.model.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.gilboard.domain.model.QMember.member;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    public Member findById() {
        return queryFactory.selectFrom(member).where(member.id.eq(1L)).fetchOne();
    }
}
