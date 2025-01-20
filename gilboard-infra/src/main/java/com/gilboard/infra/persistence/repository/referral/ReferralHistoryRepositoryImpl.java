package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.referral.model.ReferralHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReferralHistoryRepositoryImpl implements ReferralHistoryRepository {

    private final ReferralHistoryJpaRepository jpaRepository;

    @Override
    public void save(ReferralHistory referralHistory) {
        jpaRepository.save(referralHistory);
    }

    @Override
    public Optional<ReferralHistory> findByInviterId(MemberId memberId) {
        return jpaRepository.findReferralHistoryByInviterId(memberId);
    }
}
