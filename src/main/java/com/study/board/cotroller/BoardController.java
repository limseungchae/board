package com.study.board.cotroller;

import com.study.board.entity.Board;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    // GetMapping : 어떤 url로 접근할 것인지 지정해주는 어노테이션
    @GetMapping("/board/write") // localhost:808/board/write
    public String boardWriteForm() {

        return "boardwrite"; // boardwrite.html 문서를 보여줌
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) { // Entity @Data로 인해서 변경 가능

        System.out.println(board.getTitle());
        System.out.println(board.getContent());

        return "";
    }
}
