package com.gilboard.was.member.service;

import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.member.repository.MemberRepository;
import com.gilboard.infra.cache.CacheClient;
import com.gilboard.infra.persistence.sequence.SequenceGenerator;
import com.gilboard.was.referral.service.ReferralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ReferralService referralService;
    private final SequenceGenerator sequenceGenerator;
    private final CacheClient cacheClient;

    @Transactional
    public void createMember(String nickName) {
        MemberId memberId = MemberId.newOne(sequenceGenerator.generate());
        Member member = Member.newOne(memberId, nickName);
        memberRepository.save(member);
        referralService.createReferralCode(memberId);
    }

}
