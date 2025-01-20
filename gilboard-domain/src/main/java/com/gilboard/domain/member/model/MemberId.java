package com.gilboard.domain.member.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor
public class MemberId {

    private Long id;

    private MemberId(Long id) {
        this.id = id;
    }

    public static MemberId from(String id) {
        return new MemberId(Long.parseLong(id));
    }

    public static MemberId newOne(Long id) {
        if (ObjectUtils.isEmpty(id)) {
            return null;
        }
        return new MemberId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MemberId oId = (MemberId) o;
        return Objects.equals(id, oId.id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
