package com.gilboard.infra.persistence.repository.member;

import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository jpaRepository;

    @Override
    public void save(Member member) {
        jpaRepository.save(member);
    }
}
