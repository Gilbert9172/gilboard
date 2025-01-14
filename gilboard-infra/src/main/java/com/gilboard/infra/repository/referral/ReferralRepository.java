package com.gilboard.infra.repository.referral;

import com.gilboard.domain.referral.model.Referral;

import java.util.Optional;

public interface ReferralRepository {
    void save(Referral referral);

    Optional<Referral> findByReferralCode(String code);
}
