package com.zegra.bootboard.service;

import com.zegra.bootboard.dto.BoardDTO;
import com.zegra.bootboard.dto.PageRequestDTO;
import com.zegra.bootboard.dto.PageResultDTO;
import com.zegra.bootboard.entity.Board;
import com.zegra.bootboard.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

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

    /**
     * 게시글 리스트
     * @param pageRequestDTO
     * @return
     */
    @Override
    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO) {

        log.info("BoardService === getList ===");

        Pageable pageable = pageRequestDTO.getPageable(Sort.by("bno").descending());

        Page<Board> result = boardRepository.findAll(pageable);

        Function<Board, BoardDTO> fn = (boardEntity -> entityToDTO(boardEntity));

        return new PageResultDTO<>(result, fn);
    }

    /**
     * 게시글 조회
     * @param bno
     * @return
     */
    @Override
    public BoardDTO getBoard(Long bno) {

        Optional<Board> result = boardRepository.findById(bno);

        return result.isPresent() ? entityToDTO(result.get()) : null;
    }
}
