package com.gilboard.api.controller;

import com.gilboard.cache.CacheClient;
import com.gilboard.domain.member.infra.repository.MemberJpaRepository;
import com.gilboard.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MemberV1Controller {

    private final MemberJpaRepository memberJpaRepository;
    private final CacheClient cacheClient;

    @GetMapping("/sample1")
    public void save() {
        memberJpaRepository.save(Member.newOne(UUID.randomUUID(), "gilbert"));
        cacheClient.saveValueOfString("gilbert", "9172", Duration.of(1, ChronoUnit.HOURS));
    }
}
