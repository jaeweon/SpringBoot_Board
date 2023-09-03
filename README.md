# SpringBoot_Board
#### 스프링부트로 REST FUL 하게 게시판 만들기!
##### 기능 : SELECT, INSERT, UPDATE, DELETE, REPLY, SEARCH
##### 목적 : Spring Frame Work을 활용해 REST API를 공부헤보자

![image](https://github.com/jaeweon/SpringBoot_Board/assets/34277606/cf118726-aa14-409a-ad0d-248f5c090d4c)

# Developer Tools
### Spring Boot DevTools
### Lombok
### Spring Configuration Processor

# Web
### Spring Web 
### Spring Web Service

# Template Engines
### Thymeleaf 
### SQL

# JDBC API
### MyBatis Framework
### Oracle Driver

# 게시글 정렬 (HINT) DB 튜닝
## HINT를 사용해랴 하는 이유
### 오라클에서 눈에 보이지는 않지만 ROW ID(행) 라는 것이 존재한다. * 각 행의 주소
### ROW ID 를 관리해주는 객체 : INDEX (JAVA에서의 INDEX와 전혀 다름)
### 흔히 SELECT 를 하게되면 정렬이되는 것이 아니라 INDEX가 가져올 수 있는 최적의 알고리즘을 토대로 가져오는 것이다. (정렬이 되는 것이 아님)
### ORDER BY는 SELECT 다음에 실행되기 때문에, SQL문이 길어지기 때문에, 실행 속도가 느려지기 때문에 사용 X
# HINT 문법 사용
/** INDEX_DESC(TBL_BOARD PK_BOARD)*/

# 게시글 페이징
### Criteria : 페이징 처리용 클래스
### pageNum : current page
### amount(10) : 한 페이지에 10개의 게시글 
### type : 검색 키워드
### keyword : 전체, 제목, 제목 또는 내용, 작성자

pageCount
startPage
endPage
realEnd
prev
next
total

# 게시글 댓글(RESTFUL)
### 댓글 등록 : http://localhost:10003/reply/new
#### {
#### "boardNumber" : 292, 
#### "replyContent" : "REST TEST CONTENT3", 
#### "replyWriter" : "REST TEST WRITER"
#### }

### 댓글 상세보기 : http://localhost:10003/reply/84
## 
#### {
#### "replyNumber": 84,
#### "boardNumber": 292,
#### "replyContent": "REST로 추가한 댓글",
#### "replyWriter": "이재원",
#### "replyRegisterDate": "2023-05-17 23:06:28",
#### "replyUpdateDate": "2023-05-17 23:06:28"
#### }

### 댓글 수정 : http://localhost:10003/reply/84
#### {
#### "boardNumber" : 292, 
#### "replyContent" : "REST TEST CONTENT4"
#### , "replyWriter" : "REST TEST WRITER"
#### }

### 댓글 삭제 : http://localhost:10003/reply/88
