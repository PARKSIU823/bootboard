package com.zegra.bootboard.service;

import com.zegra.bootboard.dto.BoardDTO;
import com.zegra.bootboard.dto.PageRequestDTO;
import com.zegra.bootboard.dto.PageResultDTO;
import com.zegra.bootboard.entity.Board;
import com.zegra.bootboard.entity.Member;

public interface BoardService  {

    //등록
    Long register(BoardDTO boardDTO);

    //리스트
    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO);

    //등록, dto > entity 변환
    default Board dtoToEntity(BoardDTO boardDTO) {

        Board boardEntity = Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(Member.builder().mno(boardDTO.getWriter()).build())
                .delYn(boardDTO.getDelYn())
                .hit(boardDTO.getHit())
                .build();
        return boardEntity;
    }

    //entity > dto
    default BoardDTO entityToDTO(Board boardEntity) {

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(boardEntity.getBno())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter().getMno())
                .delYn(boardEntity.getDelYn())
                .regDate(boardEntity.getRegDate())
                .modDate(boardEntity.getModDate())
                .hit(boardEntity.getHit())
                .build();

        return boardDTO;
    }
}
