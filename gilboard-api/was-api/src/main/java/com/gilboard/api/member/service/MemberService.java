package com.gilboard.api.member.service;

import com.gilboard.api.referral.service.ReferralService;
import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.repository.MemberRepository;
import com.gilboard.infra.cache.CacheClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ReferralService referralService;
    private final CacheClient cacheClient;

    @Transactional
    public void createMember(String nickName) {
        UUID memberId = UUID.randomUUID();
        Member member = Member.newOne(memberId, nickName);
        memberRepository.save(member);
        referralService.createReferralCode(memberId);
    }

}
