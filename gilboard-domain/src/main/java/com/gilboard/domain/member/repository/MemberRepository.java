package com.gilboard.domain.member.repository;

import com.gilboard.domain.member.model.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository {
    void save(Member member);

    Optional<Member> findById(UUID uuid);
}
