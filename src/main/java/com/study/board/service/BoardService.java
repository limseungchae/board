package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository; // 의존성 주입을 통해 BoardRepository 객체 생성

    // 글 작성 처리
    public void write(Board board, MultipartFile file) throws Exception { /* 작성 bord, file 저장, throws Exception 예외처리 */

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"; /* 저장할 경로, "user.dir" = 절대경로 지정*/

        UUID uuid = UUID.randomUUID(); /* 램덤 이름 생성 */

        String fileName = uuid + "_" + file.getOriginalFilename(); /* 랜덤 이름_파일이름 */

        File saveFile = new File(projectPath, fileName); /* 경로, 파일이름으로 저장 객체 생성 */

        file.transferTo(saveFile); /* 업로드 파일을 새파일로 이동(복사) */

        board.setFilename(fileName); /* entity <- fileName */
        board.setFilepath("/files/" + fileName); /* 저장된 파일 경로, 이름 */

        boardRepository.save(board); // boardRepository를 사용하여 Board 객체를 저장 (데이터베이스에 저장)

    }

    // 게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable); // 데이터베이스에서 모든 게시물을 조회하여 Board 엔티티의 리스트로 반환합니다
    }

    // 특정 게시글 불러오기 (상세조회)
    public Board boardView(Integer id) { //메서드의 인수(parameter)로서, id라는 변수를 전달

        return boardRepository.findById(id).get(); // ID를 DB 찾아오고 .get() 메소드를 호출하여 실제 객체를 반환합니다.
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer board) {

        boardRepository.deleteById(board); // boardRepository를 사용하여 Board 객체를 삭제 (데이터베이스에 삭제)
    }
}
