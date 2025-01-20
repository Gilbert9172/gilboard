package com.gilboard.infra.persistence.repository.member;

import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.model.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, MemberId> {
}
