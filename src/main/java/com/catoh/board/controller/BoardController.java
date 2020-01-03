package com.catoh.board.controller;

import com.catoh.board.dto.BoardDto;
import com.catoh.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

//  url를 잡아주는곳.  This is where all the pages are set to certain pages and redirect connections
    @GetMapping("/")
    public String list() {
        return "/board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "/board/write.html";
    }

//    dto: receiving data information between the controller and service
    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }
}
