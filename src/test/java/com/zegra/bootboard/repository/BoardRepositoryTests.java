package com.zegra.bootboard.repository;

import com.zegra.bootboard.entity.Board;
import com.zegra.bootboard.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    /**
     * 게시글 더미 데이터 입력
     */
    @Test
    public void insertBoard() {

        IntStream.rangeClosed(1,50).forEach( i -> {

            long memberNo = (long)(Math.random() * 50) +1;
            Member member = Member.builder().mno(memberNo).build();

            Board board = Board.builder()
                    .title("제목 " + i)
                    .content("내용 " + i)
                    .writer(member)
                    .delYn('N')
                    .build();

            boardRepository.save(board);
        });
    }
}
