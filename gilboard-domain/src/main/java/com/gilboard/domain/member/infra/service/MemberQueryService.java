package com.gilboard.domain.member.infra.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

    private final JPAQueryFactory queryFactory;

//    @Transactional(readOnly = true)
//    public Member findById() {
//        return queryFactory.selectFrom(member).where(member.id.eq(1L)).fetchOne();
//    }
}
