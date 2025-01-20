package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.referral.model.ReferralHistory;

import java.util.Optional;

public interface ReferralHistoryRepository {

    void save(ReferralHistory referralHistory);

    Optional<ReferralHistory> findByInviterId(MemberId memberId);
}
