package com.gilboard.domain.referral.model;

import com.gilboard.domain.member.model.MemberId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

// TODO : ReferralCode Indexing
@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Referral {

    @EmbeddedId
    MemberId id;

    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String referralCode;


    @Column(columnDefinition = "INTEGER default 0", nullable = false)
    private int inviteeMemberCount;

    @Builder
    private Referral(MemberId id, String referralCode, int inviteeMemberCount) {
        this.id = id;
        this.referralCode = referralCode;
        this.inviteeMemberCount = inviteeMemberCount;
    }

    public static Referral newOne(MemberId memberId, String referralCode) {
        return Referral.builder()
                .id(memberId)
                .referralCode(referralCode)
                .build();
    }

    public void updateInviteeCount(int count) {
        this.inviteeMemberCount = count;
    }

    public void updateInviteeCountV2() {
        this.inviteeMemberCount++;
    }

}
