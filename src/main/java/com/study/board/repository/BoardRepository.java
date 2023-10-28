package com.study.board.repository;

import com.study.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // JpaRepository는 Entity 클래스와 해당 Entity의 Primary Key 데이터 타입을 받아 엔티티에 대한 데이터 액세스를 제공 합니다.
}
