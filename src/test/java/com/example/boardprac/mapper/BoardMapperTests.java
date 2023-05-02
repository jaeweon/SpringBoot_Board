package com.example.boardprac.mapper;

import com.example.boardprac.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

//    @Test       게시글 목록 test
//    public void getListTest(){
//        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
//    }


//        @Test        // 게시글 등록 test
//        public void insertTest(){
//            BoardVO boardVO = new BoardVO();
//            boardVO.setBoardTitle("새롭게 추가된 게시글 제목2");
//            boardVO.setBoardContent("새롭게 추가된 게시글 내용2");
//            boardVO.setBoardWriter("재원2");
//            boardMapper.insert(boardVO);
//            log.info("방금 추가된 게시글 번호" + boardVO.getBoardNumber().toString());
//        }

//          @Test       게시글 1개 조회 test
//          public void selectTest(){
//            log.info(boardMapper.select(2L).toString());
//           }

//        @Test      // 게시글 수정 test
//        public void updateTest(){
//            BoardVO boardVO = boardMapper.select(1L);
//            boardVO.setBoardTitle("수정된 게시글 제목");
//            boardVO.setBoardContent("수저왼 게시글 내용");
//            log.info("UPDATE CONUNT : " + boardMapper.update(boardVO));
//        }


        @Test       //  게시글 삭제 test
       public void deleteTest(){
            boardMapper.delete(2L);
        }


//        @Test         // 게시글 총 개수 test
//        public void getTotalTest(){
//            log.info("총 게시글" + boardMapper.getTotal());
//        }



}