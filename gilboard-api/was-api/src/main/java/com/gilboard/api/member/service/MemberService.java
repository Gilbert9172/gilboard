package com.gilboard.api.member.service;

import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.repository.MemberRepository;
import com.gilboard.infra.cache.CacheClient;
import com.gilboard.infra.serializer.CustomJsonSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CacheClient cacheClient;

    @Transactional
    public void createMember() {
        Member member = Member.newOne(UUID.randomUUID(), "gilbert");
        memberRepository.save(member);
        cacheClient.saveValueOfString("gilbert", CustomJsonSerializer.toJson(member), Duration.of(1, ChronoUnit.HOURS));
    }

}
