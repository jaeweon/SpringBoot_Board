package com.example.boardprac.mapper;

import com.example.boardprac.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;

//    private Long[] arBno = {291L, 292L, 293L, 295L, 296L};
//    @Test
//    public void insertTest(){
//        IntStream.rangeClosed(1, 10).forEach(i ->{
//            ReplyVO replyVO = new ReplyVO();
//
//            replyVO.setBoardNumber(arBno[i % 5]);
//            replyVO.setReplyContent("댓글 테스트" + i);
//            replyVO.setReplyWriter("댓글 작성자" + i);
//            replyMapper.insert(replyVO);
//        });
//    }

//    @Test
//    public void selectTest(){
//        log.info(replyMapper.select(44L).toString());
//    }

//    @Test
//    public void updateTest(){
//        ReplyVO replyVO = replyMapper.select(44L);
//        replyVO.setReplyContent("수정된 댓글");
//        replyMapper.update(replyVO);
//    }

//    @Test
//    public void deleteTest(){
//        replyMapper.delete(44L);
//    }

    @Test
    public void getTotalTest(){
        log.info("COUNT : " + replyMapper.getTotal(296L));
    }
}