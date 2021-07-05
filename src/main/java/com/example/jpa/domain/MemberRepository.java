package com.example.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by jg 2021/06/02
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
