package com.study.board.cotroller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService; // 의존성 주입

    // GetMapping : 어떤 url로 접근할 것인지 지정해주는 어노테이션
    @GetMapping("/board/write") // localhost:808/board/write
    public String boardWriteForm() {

        return "boardwrite"; // boardwrite.html 문서를 보여줌
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) { // Entity @Data로 인해서 변경 가능

        boardService.write(board); // 게시글 정보를 데이터베이스에 저장

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }
}
