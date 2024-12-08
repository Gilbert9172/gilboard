package com.gilboard.api.controller;

import com.gilboard.domain.service.MemberQueryService;
import lombok.RequiredArgsConstructor;
import com.gilboard.domain.model.Member;
import com.gilboard.domain.repository.MemberJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberV1Controller {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberQueryService memberQueryService;

    @GetMapping("/sample1")
    public void save() {
        memberJpaRepository.save(Member.newOne("gilbert"));
    }

    @GetMapping("/sample2")
    public void get() {
        memberQueryService.findById();
    }
}
