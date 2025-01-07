package com.gilboard.domain.member.infra.repository;

import com.gilboard.domain.member.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
