package com.gilboard.api.controller;

import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.repository.MemberRepository;
import com.gilboard.infra.cache.CacheClient;
import com.gilboard.infra.serializer.CustomJsonSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MemberV1Controller {

    private final MemberRepository memberRepository;
    private final CacheClient cacheClient;

    @GetMapping("/sample1")
    public void save() {
        Member member = Member.newOne(UUID.randomUUID(), "gilbert");
        memberRepository.save(member);
        cacheClient.saveValueOfString("gilbert", CustomJsonSerializer.toJson(member), Duration.of(1, ChronoUnit.HOURS));
    }
}
