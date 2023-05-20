package com.example.boardprac.controller;

import com.example.boardprac.domain.vo.Criteria;
import com.example.boardprac.domain.vo.ReplyVO;
import com.example.boardprac.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/*
* Rest(Representational State transfer)
* 하나의 URI는 하나의 고유한 리소스(데이터)를 대표하도록 설계된다.
* ex) /board/36 : 게시글 중 36번 게시글의 전체 정보
* */
@RestController
@Slf4j
@RequestMapping("/reply/*")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

//  댓글 등록
//  브라우저에서 JSON타입으로 데이터를 전송하고 서버에서는 댓글이 처리 결과에 따라 문자열로 결과를 리턴한다.
//  consumes : 전달받은 데이터의 타입
//  produces : 콜백함수로 결과를 전달할 때의 타입
//  @RequestBody : 전달받은 데이터를 알맞는 매개변수로 주입할 때 사용
//  ResponseEntity : 서버의 상태코드, 응답 메세지 등을 담을 수 있는 타입

    @PostMapping(value ="/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) throws UnsupportedEncodingException{
        log.info("replyVO : " + replyVO);
        replyService.register(replyVO);
        return new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8"), HttpStatus.OK);
    }

    @GetMapping("/{replyNumber}")
    public ReplyVO read(@PathVariable("replyNumber") Long replyNumber){
        return replyService.read(replyNumber);
    }

    @GetMapping("/list/{boardNumber}/{page}")
    public List<ReplyVO> getList(@PathVariable("page") int pageNum, @PathVariable("boardNumber") Long boardNumber){
        return replyService.getList(new Criteria(pageNum, 10), boardNumber);
    }

//    @PostMapping("/remove/{replyNumber}")
//    public void remove(@PathVariable("replyNumber") Long replyNumber){
//        replyService.remove(replyNumber);
//    }

    // 댓글 삭제
    @DeleteMapping("/{replyNumber}")
        public void remove(@PathVariable("replyNumber") Long replyNumber){
        replyService.remove(replyNumber);
    }

    // 댓글 수정
    // PUT : 자원의 전체 수정
    // PATCH : 자원의 일부 수정
    // POST도 사용(검증단계에서 라이브러리 사용?)

    @PostMapping("/{replyNumber}")
    public void modify(@PathVariable("replyNumber") Long replyNumber, @RequestBody ReplyVO replyVO){
        log.info("modify................ : " + replyNumber);
        log.info(replyVO.toString());
        replyVO.setReplyNumber(replyNumber);
        replyService.modify(replyVO);
    }
}