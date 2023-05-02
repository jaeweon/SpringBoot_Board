package com.example.boardprac.service;

import com.example.boardprac.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public List<BoardVO> getList();
    public void register(BoardVO boardVO);
    public BoardVO get(Long boardNumber);
    public boolean modify(BoardVO boardVO);
    public boolean remove(Long boardNumber);
    public int getTotal();
}
