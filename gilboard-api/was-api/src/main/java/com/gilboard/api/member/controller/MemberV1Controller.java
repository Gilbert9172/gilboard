package com.gilboard.api.member.controller;

import com.gilboard.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@MemberV1RestController
@RequiredArgsConstructor
public class MemberV1Controller {

    private final MemberService memberService;

    @GetMapping("/join")
    public void join() {
        memberService.createMember();
    }
}
