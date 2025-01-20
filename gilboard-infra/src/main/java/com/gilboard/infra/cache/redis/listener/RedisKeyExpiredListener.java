package com.gilboard.infra.cache.redis.listener;

import com.gilboard.domain.referral.model.Referral;
import com.gilboard.domain.referral.model.ReferralHistory;
import com.gilboard.infra.cache.CacheClient;
import com.gilboard.infra.persistence.repository.referral.ReferralHistoryQueryRepository;
import com.gilboard.infra.persistence.repository.referral.ReferralRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RedisKeyExpiredListener implements MessageListener {

    private final ReferralHistoryQueryRepository referralHistoryQueryRepository;
    private final ReferralRepository referralRepository;
    private final CacheClient cacheClient;

    @Override
    @Transactional
    public void onMessage(@NonNull Message message, byte[] pattern) {
        String referralCode = extractKeyFrom(message);
        List<ReferralHistory> referralHistories = referralHistoryQueryRepository.findAllByReferralCode(referralCode);
        Referral referral = referralRepository.findByReferralCode(referralCode).orElseThrow(RuntimeException::new);
        referral.updateInviteeCount(referralHistories.size());
    }

    private String extractKeyFrom(Message message) {
        String channel = new String(message.getChannel());
        String[] split = channel.split(":");
        return split[split.length - 1];
    }
}
