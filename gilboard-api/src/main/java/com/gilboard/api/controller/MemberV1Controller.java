package com.gilboard.api.controller;

import lombok.RequiredArgsConstructor;
import com.gilboard.domain.model.Member;
import com.gilboard.domain.repository.MemberJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberV1Controller {

    private final MemberJpaRepository memberJpaRepository;

    @GetMapping("/sample")
    public void save() {
        memberJpaRepository.save(Member.newOne("gilbert"));
    }

}
