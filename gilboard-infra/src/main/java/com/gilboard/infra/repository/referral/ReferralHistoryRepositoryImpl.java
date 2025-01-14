package com.gilboard.infra.repository.referral;

import com.gilboard.domain.referral.model.ReferralHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReferralHistoryRepositoryImpl implements ReferralHistoryRepository {

    private final ReferralHistoryJpaRepository jpaRepository;

    @Override
    public void save(ReferralHistory referralHistory) {
        jpaRepository.save(referralHistory);
    }
}
