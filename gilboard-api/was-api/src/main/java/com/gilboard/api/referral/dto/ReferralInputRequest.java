package com.gilboard.api.referral.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReferralInputRequest {

    private UUID memberId;
    private String referralCode;

}
