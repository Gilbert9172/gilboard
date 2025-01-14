package com.gilboard.infra.repository.referral;

import com.gilboard.domain.referral.model.ReferralHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReferralHistoryJpaRepository extends JpaRepository<ReferralHistory, UUID> {

}
