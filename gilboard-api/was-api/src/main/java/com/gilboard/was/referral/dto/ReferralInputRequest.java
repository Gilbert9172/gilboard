package com.gilboard.was.referral.dto;

import com.gilboard.domain.member.model.MemberId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReferralInputRequest {

    private MemberId memberId;
    private String referralCode;

}
