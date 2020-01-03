package com.catoh.board.service;

import com.catoh.board.domain.repository.BoardRepository;
import com.catoh.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@AllArgsConstructor // constructor declaration for insert to board repository
@Service // declaration that this is 'Service'
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardDto boardDto) {
//        save(): in charge of insert and update to db
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
