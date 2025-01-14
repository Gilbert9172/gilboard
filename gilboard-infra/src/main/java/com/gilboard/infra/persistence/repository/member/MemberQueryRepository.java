package com.gilboard.infra.persistence.repository.member;

import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.model.MemberId;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.gilboard.domain.member.model.QMember.member;

@Service
@RequiredArgsConstructor
public class MemberQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    public Member findById(MemberId id) {
        return queryFactory.selectFrom(member)
                .where(member.id.eq(id))
                .fetchOne();
    }
}
