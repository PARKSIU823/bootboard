package com.zegra.bootboard.repository;

import com.zegra.bootboard.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * member 테이블에 데이터 추가
     */
    @Test
    public void insertMember() {

        IntStream.rangeClosed(1,50).forEach( i -> {

            Member member = Member.builder()
                    .email("abc"+ i +"@aaaaa.com")
                    .birth("19960717")
                    .name("이름" + i)
                    .password("password" + i)
                    .penName("닉네임 " + i)
                    .resignYn('N')
                    .build();

            memberRepository.save(member);

        });

    }
}
