package com.gilboard.api.referral.service;

import com.gilboard.domain.referral.model.Referral;
import com.gilboard.domain.referral.model.ReferralHistory;
import com.gilboard.domain.referral.model.StringGenerator;
import com.gilboard.infra.repository.referral.ReferralHistoryRepository;
import com.gilboard.infra.repository.referral.ReferralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReferralService {

    private final ReferralRepository referralRepository;
    private final ReferralHistoryRepository referralHistoryRepository;
    private final StringGenerator stringGenerator;

    @Transactional
    public void createReferralCode(UUID memberId) {
        String referralCode = stringGenerator.generateRandomString();
        Referral referral = Referral.newOne(memberId, referralCode);
        referralRepository.save(referral);
    }

    @Transactional
    public void enterReferralCode(UUID inviteeId, String referralCode) {
        Referral invitorReferral = referralRepository.findByReferralCode(referralCode).orElseThrow(RuntimeException::new);
        ReferralHistory referralHistory = ReferralHistory.newOne(UUID.randomUUID(), inviteeId, invitorReferral.getId());
        referralHistoryRepository.save(referralHistory);
        invitorReferral.updateInviteeCount();
    }

}
