package com.example.boardprac.service;

import com.example.boardprac.domain.dao.BoardDAO;
import com.example.boardprac.domain.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
// Service
// 여러 개의 DML을 하나의 서비스로 묶어준다.
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;
    @Override
    public List<BoardVO> getList() {
        return boardDAO.getList();
    }

    @Override
    public void register(BoardVO boardVO) {
        boardDAO.register(boardVO);
    }

    @Override
    public BoardVO get(Long boardNumber) {
        return boardDAO.findByBoardNumber(boardNumber);
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        return boardDAO.modify(boardVO);
    }

    @Override
    public boolean remove(Long boardNumber) {
        return boardDAO.remove(boardNumber);
    }

    @Override
    public int getTotal() {
        return boardDAO.getTotal();
    }
}
