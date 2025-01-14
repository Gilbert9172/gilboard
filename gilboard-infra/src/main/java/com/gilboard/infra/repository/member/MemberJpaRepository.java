package com.gilboard.infra.repository.member;

import com.gilboard.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberJpaRepository extends JpaRepository<Member, UUID> {
}
