package com.zegra.bootboard.service;

import com.zegra.bootboard.dto.BoardDTO;
import com.zegra.bootboard.dto.PageRequestDTO;
import com.zegra.bootboard.dto.PageResultDTO;
import com.zegra.bootboard.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    //게시글 등록
    @Test
    public void insertBoard() {

        BoardDTO boardDTO = BoardDTO.builder()
                .title("Service Test 제목")
                .content("Service Test 내용")
                .writer(26l)
                .delYn('N')
                .build();
        
        System.out.println(boardService.register(boardDTO));
    
    }

    //게시글 목록
    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(20).build();

        PageResultDTO<BoardDTO, Board> pageResultDTO = boardService.getList(pageRequestDTO);

        System.out.println("이전 페이지 : " + pageResultDTO.isPrevNo());
        System.out.println("다음 페이지 : " + pageResultDTO.isNextNo());
        System.out.println("총 페이지 : " + pageResultDTO.getTotalPage());

        System.out.println("=======================================================");
        for(BoardDTO boardDTO : pageResultDTO.getDtoList()) {
            System.out.println(boardDTO);
        }

        System.out.println("=======================================================");
        pageResultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
