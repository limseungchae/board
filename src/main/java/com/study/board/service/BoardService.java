package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository; // 의존성 주입을 통해 BoardRepository 객체 생성

    public void write(Board board) {

        boardRepository.save(board); // boardRepository를 사용하여 Board 객체를 저장 (데이터베이스에 저장)

    }

    public List<Board> boardList() {

        return boardRepository.findAll();
    }
}
