package com.study.board.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {
    private String applicationName;
    private String title;
    private String content;
    private String creator;
}
