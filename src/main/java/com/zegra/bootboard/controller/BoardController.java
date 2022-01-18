package com.zegra.bootboard.controller;

import com.zegra.bootboard.dto.BoardDTO;
import com.zegra.bootboard.dto.PageRequestDTO;
import com.zegra.bootboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/bboard")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 리스트
     * @param pageRequestDTO
     * @param model
     * @return
     */
    @RequestMapping({"/","/list"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("list ============" + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));

        return "/board/list";
    }

    @GetMapping("/regist")
    public String regist() {
        log.info("regist GET ==============");

        return "/board/regist";
    }

    @PostMapping("/regist")
    public String registPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {

        log.info("boardDTO ============" + boardDTO);

        boardDTO.setDelYn('N');
        Long bno = boardService.register(boardDTO);
        redirectAttributes.addFlashAttribute("msg", bno);

        return "redirect:/bboard/list";
    }

    @GetMapping("/read")
    public String getBoard(Long bno, @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO, Model model) {

        log.info("bno ============" + bno);

        BoardDTO boardDTO = boardService.getBoard(bno);

        model.addAttribute("result", boardDTO);

        return "/board/read";
    }


}
