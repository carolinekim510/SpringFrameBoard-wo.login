package com.catoh.board.service;

import com.catoh.board.domain.entity.BoardEntity;
import com.catoh.board.domain.repository.BoardRepository;
import com.catoh.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor // constructor declaration for insert to board repository
@Service // declaration that this is 'Service'
public class BoardService {
    private BoardRepository boardRepository;


    @Transactional
    public List<BoardDto> getBoardlist() {
        List<BoardEntity> boardEntities = boardRepository.findAll();    // find all attribute of posted from db
        List<BoardDto> boardDtoList = new ArrayList<>();                // create array list to contain all the entities from db

        for (BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDTO);                                 // adding all found entities from db into the arraylist boardDtoList
        }
        return boardDtoList;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        // save(): in charge of insert and update to db
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}