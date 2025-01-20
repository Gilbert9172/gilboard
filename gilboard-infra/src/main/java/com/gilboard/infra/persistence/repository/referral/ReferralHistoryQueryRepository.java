package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.referral.model.ReferralHistory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.gilboard.domain.referral.model.QReferral.referral;
import static com.gilboard.domain.referral.model.QReferralHistory.referralHistory;

@Service
@RequiredArgsConstructor
public class ReferralHistoryQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    public List<ReferralHistory> findAllByReferralCode(final String referralCode) {
        return queryFactory.selectFrom(referralHistory)
                .leftJoin(referral).on(referral.id.eq(referralHistory.inviterId))
                .where(referral.referralCode.eq(referralCode))
                .fetch();
    }
}
