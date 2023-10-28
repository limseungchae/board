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

    // 글 작성 처리
    public void write(Board board) {

        boardRepository.save(board); // boardRepository를 사용하여 Board 객체를 저장 (데이터베이스에 저장)

    }

    // 게시글 리스트 처리
    public List<Board> boardList() {

        return boardRepository.findAll(); // 데이터베이스에서 모든 게시물을 조회하여 Board 엔티티의 리스트로 반환합니다
    }
}
