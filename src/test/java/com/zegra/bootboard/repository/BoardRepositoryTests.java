package com.zegra.bootboard.repository;

import com.zegra.bootboard.entity.Board;
import com.zegra.bootboard.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
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

    /**
     * 게시글 조회
     */
    @Test
    public void testSelect() {

        long mno = 43l;

        Optional<Board> result = boardRepository.findById(mno);

        System.out.println("testSelect ===============================================");
        if(result.isPresent()) {
            Board board = result.get();
            System.out.println(board);
        }
    }

    /**
     * 게시글 수정
     */
    @Test
    public void testModify() {

        Board board = Board.builder()
                .bno(50l)
                .writer(Member.builder().mno(19l).build())
                .title("제목 수정 repository test")
                .content("내용 수정 repository test")
                .delYn('N')
                .build();

        System.out.println(boardRepository.save(board));
        
    }

    /**
     * 게시글 삭제
     */
    @Test
    public void testDelete() {

        Board board = Board.builder()
                .bno(49l)
                .writer(Member.builder().mno(19l).build())
                .title("제목 삭제 repository test")
                .content("내용 삭제 repository test")
                .delYn('Y')
                .build();

        System.out.println(boardRepository.save(board)); 
    }

    /**
     * 목록 페이징 테스트
     */
    @Test
    public void testListPage() {

        Pageable pageable = PageRequest.of(0,20); //한 페이지 당 20개 게시물
        Page<Board> result = boardRepository.findAll(pageable);

        System.out.println("testListPage ===============================================");
        System.out.println(result);
        System.out.println("총 페이지 : " + result.getTotalPages());
        System.out.println("총 게시글 수 : " + result.getTotalElements());
        System.out.println("현재 페이지 : " + result.getNumber());
        System.out.println("페이지 당 게시글 수 : " + result.getNumberOfElements());
        System.out.println("페이지 당 게시글 수 : " + result.getSize());
        System.out.println("다음 페이지 여부 : " + result.hasNext());
        System.out.println("이전 페이지 여부 : " + result.hasPrevious());
        System.out.println("testListPage ===============================================");

        for( Board board : result) {
            System.out.println(board);
        }

    }

    /**
     * 목록 정렬 + 페이징
     */
    @Test
    public void testListSort() {

        Sort sort = Sort.by("bno").descending();

        Pageable pageable = PageRequest.of(0,20, sort); //한 페이지 당 20개 게시물
        Page<Board> result = boardRepository.findAll(pageable);

        System.out.println("testListSort ===============================================");
        for( Board board : result) {
            System.out.println(board);
        }

    }

}
