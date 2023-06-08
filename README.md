# SpringBoot_Board
스프링부트로 REST FUL 하게 게시판 만들기!
기능 : SELECT, INSERT, UPDATE, DELETE, REPLY 

# Developer Tools
Spring Boot DevTools, 
Lombok, 
Spring Configuration Processor

# Web
Spring Web, 
Spring Web Service

# Template Engines
Thymeleaf, 
SQL

# JDBC API
MyBatis Framework, 
Oracle Driver

# 게시글 정렬 (HINT)
## HINT를 사용해랴 하는 이유
오라클에서 눈에 보이지는 않지만 ROW ID(행) 라는 것이 존재한다. * 각 행의 주소
ROW ID 를 관리해주는 객체 : INDEX (JAVA에서의 INDEX와 전혀 다름)
흔히 SELECT 를 하게되면 정렬이되는 것이 아니라 INDEX가 가져올 수 있는 최적의 알고리즘을 토대로 가져오는 것이다. (정렬이 되는 것이 아님)
ORDER BY는 SELECT 다음에 실행되기 때문에, SQL문이 길어지기 때문에, 실행 속도가 느려지기 때문에 사용 X
# HINT 문법 사용
/** INDEX_DESC(TBL_BOARD PK_BOARD)*/
