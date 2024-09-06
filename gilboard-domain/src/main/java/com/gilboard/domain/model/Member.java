package com.gilboard.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = AUTO)
    public Long id;

    public String name;

    @Builder
    private Member(String name) {
        this.name = name;
    }

    public static Member newOne(String name) {
        return new Member(name);
    }
}
