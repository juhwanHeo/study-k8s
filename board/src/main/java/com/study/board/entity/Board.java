package com.study.board.entity;

import com.study.board.controller.dto.BoardResponseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "TB_BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id = 0L;

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "creator")
    private String creator;

    public BoardResponseDto toSearchResponseDto() {
        return BoardResponseDto.builder()
                .title(this.title)
                .content(this.content)
                .creator(this.creator)
                .build();
    }

}
