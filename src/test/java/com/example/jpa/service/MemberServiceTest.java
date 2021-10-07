package com.example.jpa.service;

import com.example.jpa.domain.Member;
import com.example.jpa.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by Gyunny 2021/10/06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        // given
        Member member = new Member();
        member.setUsername("Gyunny");

        // when
        Long memberId = memberService.join(member);

        // then
        assertEquals(member, memberService.findOne(memberId));
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setUsername("Gyunny");

        Member member2 = new Member();
        member2.setUsername("Gyuuny");

        // when
        memberService.join(member1);
        try {
            memberService.join(member2); // 예외 발생!
        } catch (IllegalStateException e) {
            return;
        }
    }

}