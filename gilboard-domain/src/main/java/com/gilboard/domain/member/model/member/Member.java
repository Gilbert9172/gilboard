package com.gilboard.domain.member.model.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    public UUID id;

    public String name;

    @Builder
    private Member(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Member newOne(UUID id, String name) {
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
