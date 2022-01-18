package com.zegra.bootboard.repository;

import com.zegra.bootboard.entity.Board;
import com.zegra.bootboard.entity.Member;
import com.zegra.bootboard.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    /**
     * 댓글 더미 데이터 입력
     */
    @Test
    public void insertReply(){

        IntStream.rangeClosed(1,500).forEach( i -> {
            long bno = (long)(Math.random() * 50) +1;

            Board board = Board.builder().bno(bno).build();

            long randomNo = (long)(Math.random() * 50) + 1;

            Member member = Member.builder().mno(randomNo).build();

            Reply reply = Reply.builder()
                    .board(board)
                    .rtext("댓글 내용 어쩌구 " + i)
                    .member(member)
                    .build();

            replyRepository.save(reply);
        });
    }

}
