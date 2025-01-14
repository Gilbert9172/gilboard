package com.gilboard.domain.referral.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class ReferralHistory {

    @Id
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID id;

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID inviteeId;

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID inviterId;

    @Column(columnDefinition = "DATETIME(3)", nullable = false)
    private ZonedDateTime createdAt;

    @Builder
    private ReferralHistory(UUID id, UUID inviteeId, UUID inviterId, ZonedDateTime createdAt) {
        this.id = id;
        this.inviteeId = inviteeId;
        this.inviterId = inviterId;
        this.createdAt = createdAt;
    }

    public static ReferralHistory newOne(UUID id, UUID inviteeId, UUID inviterId) {
        return ReferralHistory.builder()
                .id(id)
                .inviteeId(inviteeId)
                .inviterId(inviterId)
                .createdAt(ZonedDateTime.now())
                .build();
    }
}
