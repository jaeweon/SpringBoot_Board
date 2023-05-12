package com.example.boardprac.service;

import com.example.boardprac.domain.vo.BoardVO;
import com.example.boardprac.domain.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public List<BoardVO> getList(Criteria criteria);
    public void register(BoardVO boardVO);
    public BoardVO get(Long boardNumber);
    public boolean modify(BoardVO boardVO);
    public boolean remove(Long boardNumber);
    public int getTotal();
}
