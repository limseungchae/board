# 게시판

## 게시판 작성
![게시판 작성](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fwrite.png)

## 메시지
![메시지](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fmessage.png)

## 게시판 리스트
![게시판 리스트](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Flist1.png)

## 페이징
![페이징](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fpage.png)

## 상세 페이지
![상세 페이지](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fview.png)

## 파일 업로드
![파일 업로드](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fimage.png)

## 수정 페이지
![수정 페이지](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fmodify.png)

## 검색 기능
![검색 기능](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2FsearchKeyword.png)

## 삭제
![삭제](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Fdelete.png)

## 삭제 완료
![삭제 완료](src%2Fmain%2Fresources%2Fstatic%2Ffiles%2Flist2.png)

## MySQL 스키마 설정
```sql
CREATE SCHEMA board;
```

## 스키마 선택
```sql
USE board;
```

## 테이블 생성
```sql
CREATE TABLE board (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(45) NOT NULL,
    content TEXT NOT NULL,
    filename VARCHAR(150),
    filepath VARCHAR(300)
);
```

## 테스트 데이터 프로시저 생성 1~120 까지 제목,내용 생성
```sql
DELIMITER $$

CREATE PROCEDURE testDataInsert()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 120 DO
            INSERT INTO board(title, content)
            VALUES(CONCAT('제목',i), CONCAT('내용',i));
            SET i = i + 1;
        END WHILE;
END$$
DELIMITER $$
```

## testDataInsert (테스트 데이터) 불러오기
```sql
CALL testDataInsert;
```
