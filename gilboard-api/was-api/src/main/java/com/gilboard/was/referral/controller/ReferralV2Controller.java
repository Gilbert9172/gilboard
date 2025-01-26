package com.gilboard.was.referral.controller;

import com.gilboard.was.referral.dto.ReferralInputRequest;
import com.gilboard.was.referral.service.ReferralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ReferralV2RestController
@RequiredArgsConstructor
public class ReferralV2Controller {

    private final ReferralService referralService;

    @PostMapping("/enter")
    public void inputReferralCode(@RequestBody ReferralInputRequest req) {
        referralService.enterReferralCodeV2(req.getMemberId(), req.getReferralCode());
    }
}
