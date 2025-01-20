package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.referral.model.ReferralHistory;
import com.gilboard.domain.referral.model.ReferralHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferralHistoryJpaRepository extends JpaRepository<ReferralHistory, ReferralHistoryId> {
    Optional<ReferralHistory> findReferralHistoryByInviterId(MemberId memberId);
}
