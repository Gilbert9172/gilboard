package com.gilboard.was.member.controller;

import com.gilboard.was.member.dto.JoinRequest;
import com.gilboard.was.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@MemberV1RestController
@RequiredArgsConstructor
public class MemberV1Controller {

    private final MemberService memberService;

    @PostMapping("/join")
    public void join(@RequestBody JoinRequest req) {
        memberService.createMember(req.getNickName());
    }
}
