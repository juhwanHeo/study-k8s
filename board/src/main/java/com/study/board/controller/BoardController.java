package com.study.board.controller;

import com.study.board.controller.dto.BoardResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public ResponseEntity<BoardResponseDto> find() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        log.info(">>> uuid: {}", uuid);
        return ResponseEntity.ok(BoardResponseDto.builder()
                .applicationName(appName)
                .title("title-" + uuid)
                .content("content-" + uuid)
                .build());
    }
}
