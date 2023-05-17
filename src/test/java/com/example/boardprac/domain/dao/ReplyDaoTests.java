package com.example.boardprac.domain.dao;

import com.example.boardprac.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class ReplyDaoTests {
    @Autowired
    private ReplyDAO replyDAO;

    private Long[] arBno = {294L, 293L, 292L, 291L, 296L};

//    @Test
//    public void registerTest(){
//        IntStream.rangeClosed(11, 20).forEach(i ->{
//            ReplyVO replyVO = new ReplyVO();
//            replyVO.setBoardNumber(arBno[i % 5]);
//            replyVO.setReplyContent("댓글 테스트" + i);
//            replyVO.setReplyWriter("댓글 작성자" + i);
//            replyDAO.register(replyVO);
//        });
//    }

//    @Test
//    public void readTest(){
//        log.info(replyDAO.read(62L).toString());
//    }

//      @Test
//      public void modifyTest(){
//          ReplyVO replyVO = replyDAO.read(62L);
//          replyVO.setReplyContent("수정됬습니다");
//          replyDAO.modify(replyVO);
//      }

//        @Test
//        public void removeTest(){
//            replyDAO.remove(62L);
//        }

          @Test
          public void getTotal(){
            replyDAO.getTotal(296L);
          }

}
