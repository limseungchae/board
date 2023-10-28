package com.study.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// Entity는 JPA에서 DB의 테이블을 의미
@Entity
@Data // lombok - get/ set 자동설정
// @Table(name = "board") // "board" 테이블과 일치시킴
public class Board { // Table 이름과 일치

    // DB 필드를 넣어줌
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY : mysql,mariaDB에서 사용 : 자동생성값
    private Integer id;

    private String title;

    private String content;
}
