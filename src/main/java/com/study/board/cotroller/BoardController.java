package com.study.board.cotroller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService; // 의존성 주입

    // GetMapping : 어떤 url로 접근할 것인지 지정해주는 어노테이션
    @GetMapping("/board/write") // localhost:808/board/write
    public String boardWriteForm() {

        return "boardwrite"; // boardwrite.html 문서를 보여줌
    }

    @PostMapping("/board/writepro") // Entity @Data로 인해서 변경 가능, throws Exception = 예외발생시 대비
    public String boardWritePro(Board board, Model model, MultipartFile file) throws Exception {

        boardService.write(board, file); // 게시글 정보를 데이터베이스에 저장

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

        return "message";
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

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {

        boardService.boardDelete(id); // id 기반으로 서비스에서 dlete 한다.

        return "redirect:/board/list"; // boardlist 할경우작동하지 않음. "redirect:/board/list"는 서버로 새로운 요청을 보냄.
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {   // URL에서 추출한 'id' 값을 사용하여 'model'을 가져오기.

        model.addAttribute("board", boardService.boardView(id)); // html ${board} 사용.  ID를 사용하여 특정 게시물을 식별하고 조회

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board, MultipartFile file) throws Exception { // URL에서 추출한 'id' 값을 사용하여 'board' 데이터를 데이터베이스(DB)에서 수정하기.

        Board boardTemp = boardService.boardView(id); // 기존 게시물 가지고오기
        boardTemp.setTitle(board.getTitle()); // get 가지고오기, set 덮어쓰기
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp, file); // 수정된 게시물 write(save) DB에 업데이트

        return "redirect:/board/list"; // 수정완료시 ulr 게시물 목록으로
    }
}
