package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.referral.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReferralJpaRepository extends JpaRepository<Referral, UUID> {
    Optional<Referral> findByReferralCode(String referralCode);
}
