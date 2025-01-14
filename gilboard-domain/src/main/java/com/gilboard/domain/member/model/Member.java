package com.gilboard.domain.member.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @EmbeddedId
    public MemberId id;

    public String name;

    @Builder
    private Member(MemberId id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Member newOne(MemberId id, String name) {
        return Member.builder()
                .id(id)
                .name(name)
                .build();
    }

    @Override
    public String toString() {
        return "id :" + id + "&" + "name :" + name;
    }

}
