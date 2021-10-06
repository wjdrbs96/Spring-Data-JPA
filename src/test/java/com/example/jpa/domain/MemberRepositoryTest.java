package com.example.jpa.domain;

import com.example.jpa.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by jg 2021/08/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() {
        Member member = new Member();
        member.setUsername("Gyunny");
        Long saveId = memberRepository.save(member);

        Member findMember = memberRepository.findOne(saveId);
        assertEquals(member, findMember);
        assertEquals(member.getUsername(), findMember.getUsername());
    }

}