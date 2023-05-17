package com.example.boardprac.mapper;

import com.example.boardprac.domain.vo.Criteria;
import com.example.boardprac.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    // 댓글 등록
    public void insert(ReplyVO replyVO);

    // 댓글 1개 조회
    public ReplyVO select(Long replyNumber);

    // 댓글 수정
    public int update(ReplyVO replyVO);

    // 댓글 삭제
    public int delete(Long replyNumber);

    // 댓글 목록      @Param : 전달하고 하는 parameter 타입이 2개 이상일 경우 Param을 사용해주면 Map 으로 묶여서 사용 가능
    public List<ReplyVO> getList(@Param("criteria") Criteria criteria, @Param("boardNumber") Long boardNumber);

    // 댓글 전체 개수
    public int getTotal(Long boardNumber);
}
