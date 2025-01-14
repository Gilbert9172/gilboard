package com.gilboard.infra.repository.referral;

import com.gilboard.domain.referral.model.ReferralHistory;

public interface ReferralHistoryRepository {

    void save(ReferralHistory referralHistory);

}
