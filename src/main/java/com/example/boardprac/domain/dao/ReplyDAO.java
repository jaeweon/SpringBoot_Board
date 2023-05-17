package com.example.boardprac.domain.dao;

import com.example.boardprac.domain.vo.Criteria;
import com.example.boardprac.domain.vo.ReplyVO;
import com.example.boardprac.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;
    // 댓글 등록
    public void register(ReplyVO replyVO){
        replyMapper.insert(replyVO);
    }

    // 댓글 1개 조회
    public ReplyVO read(Long replyNumber){
       return replyMapper.select(replyNumber);
    }

    // 댓글 수정
    public int modify(ReplyVO replyVO){
       return replyMapper.update(replyVO);
    }

    // 댓글 삭제
    public int remove(Long replyNumber){
       return replyMapper.delete(replyNumber);
    }

    // 댓글 목록      @Param : 전달하고 하는 parameter 타입이 2개 이상일 경우 Param을 사용해주면 Map 으로 묶여서 사용 가능
    public List<ReplyVO> getList(Criteria criteria,Long boardNumber){
       return replyMapper.getList(criteria, boardNumber);
    }

    // 댓글 전체 개수
    public int getTotal(Long boardNumber){
        return replyMapper.getTotal(boardNumber);
    }
}
