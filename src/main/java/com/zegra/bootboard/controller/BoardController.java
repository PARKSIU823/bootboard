package com.zegra.bootboard.controller;

import com.zegra.bootboard.dto.PageRequestDTO;
import com.zegra.bootboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bboard")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping({"/","/list"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("list ============" + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));

        return "/board/list";
    }

}
