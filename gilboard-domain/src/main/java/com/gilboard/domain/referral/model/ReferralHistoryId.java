package com.gilboard.domain.referral.model;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor
public class ReferralHistoryId {

    private Long id;

    @Builder
    private ReferralHistoryId(Long id) {
        this.id = id;
    }

    public static ReferralHistoryId newOne(Long id) {
        if (ObjectUtils.isEmpty(id)) {
            return null;
        }
        return new ReferralHistoryId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReferralHistoryId oId = (ReferralHistoryId) o;
        return Objects.equals(id, oId.id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
