package com.example.boardprac.service;

import com.example.boardprac.domain.dao.ReplyDAO;
import com.example.boardprac.domain.vo.Criteria;
import com.example.boardprac.domain.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyDAO replyDAO;

    // 댓글 등록
    public void register(ReplyVO replyVO){
        replyDAO.register(replyVO);
    }

    // 댓글 1개 조회
    public ReplyVO read(Long replyNumber){
        return replyDAO.read(replyNumber);
    }

    // 댓글 수정
    public int modify(ReplyVO replyVO){
        return replyDAO.modify(replyVO);
    }

    // 댓글 삭제
    public int remove(Long replyNumber){
        return replyDAO.remove(replyNumber);
    }

    // 댓글 목록
    public List<ReplyVO> getList(Criteria criteria, Long boardNumber){
        return replyDAO.getList(criteria, boardNumber);
    }

    // 댓글 전체 개수
    public int getTotal(Long boardNumber){
        return replyDAO.getTotal(boardNumber);
    }


}
