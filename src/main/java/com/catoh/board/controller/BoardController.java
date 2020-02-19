package com.catoh.board.controller;

import com.catoh.board.dto.BoardDto;
import com.catoh.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    // List of published post (NEW CONTROLLER that took over older one)
    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();

        model.addAttribute("boardList", boardList);
        return "/board/list.html";
    }


    /*  THIS IS GETTING TURNED OFF after an error occur.
    Since there is NEW controller names list to takes it into model form, this would need to be turned off.
    url를 잡아주는곳.  This is where all the pages are set to certain pages and redirect connections
    --------------------------------

    @GetMapping("/")
    public String list() {
        return "/board/list.html";
    }
     */

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