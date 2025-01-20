package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.referral.model.Referral;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReferralRepositoryImpl implements ReferralRepository {

    private final ReferralJpaRepository jpaRepository;

    @Override
    public void save(Referral referral) {
        jpaRepository.save(referral);
    }

    @Override
    public Optional<Referral> findByReferralCode(String code) {
        return jpaRepository.findByReferralCode(code);
    }

    @Override
    public Optional<Referral> findById(MemberId memberId) {
        return jpaRepository.findById(memberId);
    }
}
