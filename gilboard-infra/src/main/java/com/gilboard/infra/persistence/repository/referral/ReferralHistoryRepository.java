package com.gilboard.infra.persistence.repository.referral;

import com.gilboard.domain.referral.model.ReferralHistory;

public interface ReferralHistoryRepository {

    void save(ReferralHistory referralHistory);

}
