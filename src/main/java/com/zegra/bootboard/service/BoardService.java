package com.zegra.bootboard.service;

import com.zegra.bootboard.dto.BoardDTO;
import com.zegra.bootboard.entity.Board;
import com.zegra.bootboard.entity.Member;

public interface BoardService  {

    Long register(BoardDTO boardDTO);

    //등록, dto > entity 변환
    default Board dtoToEntity(BoardDTO boardDTO) {

        Board boardEntity = Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(Member.builder().mno(boardDTO.getWriter()).build())
                .delYn(boardDTO.getDelYn())
                .build();
        return boardEntity;
    }
}
