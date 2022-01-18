package com.zegra.bootboard.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bboard")
@Log4j2
public class BoardController {

    @RequestMapping({"/","/list"})
    public String list() {

        log.info("list ============" );

        return "/board/list";
    }

}
