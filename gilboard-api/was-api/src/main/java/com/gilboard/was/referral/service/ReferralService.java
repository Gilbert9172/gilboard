package com.gilboard.was.referral.service;

import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.referral.model.Referral;
import com.gilboard.domain.referral.model.ReferralHistory;
import com.gilboard.domain.referral.model.ReferralHistoryId;
import com.gilboard.domain.referral.model.StringGenerator;
import com.gilboard.infra.cache.CacheClient;
import com.gilboard.infra.lock.redisson.DistributedLock;
import com.gilboard.infra.persistence.repository.referral.ReferralHistoryRepository;
import com.gilboard.infra.persistence.repository.referral.ReferralRepository;
import com.gilboard.infra.persistence.sequence.SequenceGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class ReferralService {

    private final ReferralRepository referralRepository;
    private final ReferralHistoryRepository referralHistoryRepository;
    private final StringGenerator stringGenerator;
    private final CacheClient cacheClient;
    private final SequenceGenerator sequenceGenerator;

    @Transactional
    public void createReferralCode(MemberId memberId) {
        String referralCode = stringGenerator.generateRandomString();
        Referral referral = Referral.newOne(memberId, referralCode);
        referralRepository.save(referral);
    }

    @Transactional
    public void enterReferralCode(MemberId inviteeId, String referralCode) {
        Referral invitorReferral = referralRepository.findByReferralCode(referralCode).orElseThrow(RuntimeException::new);
        ReferralHistoryId referralHistoryId = ReferralHistoryId.newOne(sequenceGenerator.generate());
        ReferralHistory referralHistory = ReferralHistory.newOne(referralHistoryId, inviteeId, invitorReferral.getId());
        referralHistoryRepository.save(referralHistory);

        String redisKey = String.format("referral:%s", referralCode);
        cacheClient.saveValueOfString(redisKey, inviteeId.toString(), Duration.ofSeconds(20L));
    }

    @Transactional
    @DistributedLock(value = "#referralCode")
    public void enterReferralCodeV2(MemberId inviteeId, String referralCode) {
        Referral invitorReferral = referralRepository.findByReferralCode(referralCode).orElseThrow(RuntimeException::new);
        ReferralHistoryId referralHistoryId = ReferralHistoryId.newOne(sequenceGenerator.generate());
        ReferralHistory referralHistory = ReferralHistory.newOne(referralHistoryId, inviteeId, invitorReferral.getId());
        referralHistoryRepository.save(referralHistory);
        invitorReferral.updateInviteeCountV2();
    }
}
