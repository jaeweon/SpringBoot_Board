package com.example.boardprac.mapper;

import com.example.boardprac.domain.vo.Criteria;
import com.example.boardprac.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

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
    // 댓글 목록
    public List<ReplyVO> getList(Criteria criteria);
}
