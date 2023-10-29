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

        return "boardwrite";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());
        // boardService.boardList()로부터 조회한 게시물 목록을 "list"라는 이름으로 모델에 추가합니다.
        // 이렇게 모델에 데이터를 추가하면 해당 데이터는 뷰(템플릿)에서 ${list} 형태로 사용가능

        return "boardlist";
    }

    @GetMapping("/board/view") // lodcalhost:8080/board/view?id=1 (parameter)
    public String boardView(Model model, Integer id) { // model 뷰전달, Integer 인수타입의 id 를 가지고온다.

        model.addAttribute("board", boardService.boardView(id)); // html에 ${board} 선언 추가,  ID를 사용하여 특정 게시물을 식별하고 조회

        return "boardview";
    }
}
