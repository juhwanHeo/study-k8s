package com.study.board.controller;

import com.study.board.controller.dto.BoardResponseDto;
import com.study.board.controller.dto.BoardSearchReqDto;
import com.study.board.entity.Board;
import com.study.board.exception.BoardNotFoundException;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> search(BoardSearchReqDto searchReqDto) {
        List<BoardResponseDto> searchResult = boardService.search(searchReqDto).stream()
                .map(Board::toSearchResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(searchResult);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> search(@PathVariable Long id) throws BoardNotFoundException {
        return ResponseEntity.ok(boardService.get(id));
    }

    @GetMapping("/random")
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
