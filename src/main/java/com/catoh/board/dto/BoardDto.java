package com.catoh.board.dto;

import com.catoh.board.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

//  Used to type all of these before, but now I can add annotation to help created automatically
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // this is where I can add more entity as it needed
    public BoardEntity toEntity() {
        BoardEntity build = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String writer, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}

// transfering the data information to database
// this dto capsules all the data and transfer between contoller, service and repository