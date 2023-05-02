package com.example.boardprac.domain.dao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDaoTests {

    @Autowired
    private BoardDAO boardDAO;

//    @Test       //게시글 목록 test
//    public void getListTest(){
//        boardDAO.getList().stream().map(BoardVO::toString).forEach(log::info);
//    }


//        @Test        // 게시글 등록 test
//        public void insertTest(){
//            BoardVO boardVO = new BoardVO();
//            boardVO.setBoardTitle("새롭게 추가된 게시글 제목3");
//            boardVO.setBoardContent("새롭게 추가된 게시글 내용3");
//            boardVO.setBoardWriter("재원3");
//            boardDAO.register(boardVO);
//            log.info("방금 추가된 게시글 번호" + boardVO.getBoardNumber().toString());
//        }

//          @Test       //게시글 1개 조회 test
//          public void selectTest(){
//            log.info(boardDAO.findByBoardNumber(182L).toString());
//           }

//        @Test      // 게시글 수정 test
//        public void updateTest(){
//            BoardVO boardVO = boardDAO.findByBoardNumber(182L);
//            boardVO.setBoardTitle("수정된 게시글 제목");
//            boardVO.setBoardContent("수정된 게시글 내용");
//            log.info("UPDATE : " + boardDAO.modify(boardVO));
//        }


    @Test       //  게시글 삭제 test
    public void deleteTest(){
        boardDAO.remove(182L);
    }
}
