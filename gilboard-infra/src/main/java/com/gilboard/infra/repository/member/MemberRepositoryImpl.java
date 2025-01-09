package com.gilboard.infra.repository.member;

import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository jpaRepository;

    @Override
    public void save(Member member) {
        jpaRepository.save(member);
    }

    @Override
    public Optional<Member> findById(UUID uuid) {
        return jpaRepository.findById(uuid);
    }
}
