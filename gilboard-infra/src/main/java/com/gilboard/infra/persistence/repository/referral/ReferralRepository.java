package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.referral.model.Referral;

import java.util.Optional;

public interface ReferralRepository {
    void save(Referral referral);

    Optional<Referral> findByReferralCode(String code);

    Optional<Referral> findById(MemberId memberId);
}
