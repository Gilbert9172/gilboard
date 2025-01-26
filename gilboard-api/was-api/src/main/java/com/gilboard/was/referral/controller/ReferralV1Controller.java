package com.gilboard.was.referral.controller;

import com.gilboard.was.referral.dto.ReferralInputRequest;
import com.gilboard.was.referral.service.ReferralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ReferralV1RestController
@RequiredArgsConstructor
public class ReferralV1Controller {

    private final ReferralService referralService;

    @PostMapping("/enter")
    public void inputReferralCode(@RequestBody ReferralInputRequest req) {
        referralService.enterReferralCode(req.getMemberId(), req.getReferralCode());
    }
}
