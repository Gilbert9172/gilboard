package com.gilboard.domain.member.repository;

import com.gilboard.domain.member.model.Member;

public interface MemberRepository {
    void save(Member member);
}
