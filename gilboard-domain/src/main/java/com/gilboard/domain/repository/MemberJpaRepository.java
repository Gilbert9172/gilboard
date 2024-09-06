package com.gilboard.domain.repository;

import com.gilboard.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
