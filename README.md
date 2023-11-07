# 게시판

## 게시판 작성
![write.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fwrite.png)

## 메시지
![message.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fmessage.png)

## 게시판 리스트
![list1.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Flist1.png)

## 페이징
![page.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fpage.png)

## 상세 페이지
![view.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fview.png)

## 파일 업로드
![image.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fimage.png)

## 수정 페이지
![modify.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fmodify.png)

## 검색 기능
![searchKeyword.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2FsearchKeyword.png)

## 삭제
![delete.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fdelete.png)

## 삭제 완료
![list2.png](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Flist2.png)

## MY sql
# 스키마 설정 jdbc:mysql://localhost:3306/board
create schema board;

USE Board; -- 데이터베이스 선택

# 테이블 생성 및 컬럼 추가
CREATE TABLE board (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(45) NOT NULL,
    content Text NOT NULL
);


# 테스트 데이터 프로시저 생성 1~120 까지 제목,내용 생성
DELIMITER $$

CREATE PROCEDURE testDataInsert()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 120 DO
            INSERT INTO board(title, content)
            VALUES(concat('제목',i), concat('내용',i));
            SET i = i + 1;
        END WHILE;
END$$
DELIMITER $$

# testDataInsert (테스트 데이터) 불러오기
call testDataInsert;


# 컬럼 추가
ALTER TABLE board
    ADD filename VARCHAR(150),
    ADD filepath VARCHAR(300);
