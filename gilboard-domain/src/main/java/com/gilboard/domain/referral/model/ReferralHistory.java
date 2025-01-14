package com.gilboard.domain.referral.model;

import com.gilboard.domain.member.model.MemberId;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class ReferralHistory {

    @EmbeddedId
    private ReferralHistoryId id;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "invitee_id", nullable = false))
    private MemberId inviteeId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "inviter_id", nullable = false))
    private MemberId inviterId;

    @Column(columnDefinition = "DATETIME(3)", nullable = false)
    private ZonedDateTime createdAt;

    @Builder
    private ReferralHistory(ReferralHistoryId id, MemberId inviteeId, MemberId inviterId, ZonedDateTime createdAt) {
        this.id = id;
        this.inviteeId = inviteeId;
        this.inviterId = inviterId;
        this.createdAt = createdAt;
    }

    public static ReferralHistory newOne(ReferralHistoryId id, MemberId inviteeId, MemberId inviterId) {
        return ReferralHistory.builder()
                .id(id)
                .inviteeId(inviteeId)
                .inviterId(inviterId)
                .createdAt(ZonedDateTime.now())
                .build();
    }
}
