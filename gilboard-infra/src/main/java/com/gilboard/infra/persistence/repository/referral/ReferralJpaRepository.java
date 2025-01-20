package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.referral.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferralJpaRepository extends JpaRepository<Referral, MemberId> {
    Optional<Referral> findByReferralCode(String referralCode);
}
