package com.study.board.repository;

import com.study.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // JpaRepository는 Entity 클래스와 해당 Entity의 Primary Key 데이터 타입을 받아 엔티티에 대한 데이터 액세스를 제공 합니다.

    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
    // page로 entity 정렬후 findBy 메서드 생성후 TitleContaining 검색조건 (검색 키워드, 정보)
}
