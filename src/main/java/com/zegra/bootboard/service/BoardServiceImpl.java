package com.zegra.bootboard.service;

import com.zegra.bootboard.dto.BoardDTO;
import com.zegra.bootboard.entity.Board;
import com.zegra.bootboard.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    /**
     * 게시글 등록
     * @param boardDTO
     * @return boardEntity.getBno
     */
    @Override
    public Long register(BoardDTO boardDTO) {

        log.info("boardDTO ============== " + boardDTO);
        log.info("BoardService === register ===");

        Board boardEntity = dtoToEntity(boardDTO);

        log.info(boardEntity);

        boardRepository.save(boardEntity);

        return boardEntity.getBno();
    }
}
