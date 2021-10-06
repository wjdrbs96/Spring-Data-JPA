package com.example.jpa.repository;

import com.example.jpa.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * created by Gyunny 2021/08/08
 */
@RequiredArgsConstructor
@Repository
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("Select m from Member m where m.username = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}

