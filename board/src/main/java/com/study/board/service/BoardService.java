package com.study.board.service;

import com.study.board.controller.dto.BoardResponseDto;
import com.study.board.controller.dto.BoardSearchReqDto;
import com.study.board.entity.Board;
import com.study.board.exception.BoardNotFoundException;
import com.study.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResponseDto get(Long id) throws BoardNotFoundException {
        return boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException("Not Found by id: " + id))
                .toSearchResponseDto();
    }

    public List<Board> search(BoardSearchReqDto searchReqDto) {
        if (StringUtils.hasText(searchReqDto.getTitle())) return boardRepository.findAllByTitleContains(searchReqDto.getTitle());
        return boardRepository.findAll();
    }
}
