package com.gilboard.infra.repository.member;

import com.gilboard.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, UUID> {
}
