package com.gilboard.domain.referral.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Referral {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    UUID id;

    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String referralCode;


    @Column(columnDefinition = "INTEGER default 0", nullable = false)
    private int inviteeMemberCount;

    @Builder
    private Referral(UUID id, String referralCode, int inviteeMemberCount) {
        this.id = id;
        this.referralCode = referralCode;
        this.inviteeMemberCount = inviteeMemberCount;
    }

    public static Referral newOne(UUID memberId, String referralCode) {
        return Referral.builder()
                .id(memberId)
                .referralCode(referralCode)
                .build();
    }

    public void updateInviteeCount() {
        this.inviteeMemberCount++;
    }

}
