package com.example.boardprac.controller;

import com.example.boardprac.domain.vo.BoardVO;
import com.example.boardprac.domain.vo.Criteria;
import com.example.boardprac.domain.vo.PageDTO;
import com.example.boardprac.domain.vo.TestVO;
import com.example.boardprac.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    /*
    *       Task        URL              METHOD      PARAMETE          FORM        URL이동
    *
    *       전체목록   /board/list          GET         없음             없음
    *       등록      /board/register      POST       모든 항목          필요       /board/list
    *       조회      /board/read          GET        boardNumber       없음
    *       삭제      /board/remove        GET        boardNumber       없음       /board/list
    *       수정      /board/modify        POST       모든 항목          필요       /board/read
    */
    private final BoardService boardService;

    @GetMapping("list")
    public String getList(Model model, Criteria criteria){
        log.info("-----------------");
        log.info("list------------");
        log.info("-----------------");
        model.addAttribute("boardList", boardService.getList(criteria));
        model.addAttribute("pageDTO", new PageDTO(criteria, boardService.getTotal(criteria)));
        return "/board/list";
    }

    @GetMapping("register")
    public void register(){}

    @PostMapping("register")
    // 매개변수에 선언된 객체는 자동으로 화면에 전달되므로,
    // 이를 막기 위해서는 redirect 방식의 전송이 필요하다.
    // 쉽게말해, 굳이 전달할 필요가 없는 건 Redirect로 없애주자;
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr){
        log.info("---------------");
        log.info("register--------- : " + boardVO);
        log.info("---------------");
        boardService.register(boardVO);
        // 1. Flash 사용
        // 세션에 파라미터를 저장하고, request 객체가 초기화된 후 다시 request에 담아준다.
        rttr.addFlashAttribute("boardNumber", boardVO.getBoardNumber());
        // 2. 쿼리스트링 = "/board/list?=2121"
        // rttr.addAttribute("boardNumber", boardVO.getBoardNumber());

        // redirect로 쏴주면 해당 컨트롤러를 방문했다가 간다.
        // 방금 등록한 게시글을 포함한 목록을 보여주기 위해서(컨트롤러를 방문 했다가 가야해서), redirect로 해준다
        return new RedirectView("/board/list");
    }

    // 게시글 상세보기
    @GetMapping({"read", "modify"})
    public void read(Long boardNumber, Criteria criteria, Model model, HttpServletRequest req){
        log.info(req.getRequestURI() + "-----------" + boardNumber);
        model.addAttribute("board", boardService.get(boardNumber));
    }



    // 수정
    @PostMapping("modify")
    public RedirectView modify(BoardVO boardVO, RedirectAttributes rttr, Criteria criteria){
        boardService.modify(boardVO);
        // 컨트롤러에서 다른 컨트롤러의 매개변수로 파라미터를 전달할 때에는
        // addAttribute( ), 쿼리스트링 방식으로 전달해야 받을 수 있다.
        // Flash방식은 최종 응답 화면에서 사용될 파라미터를 전달할 때에만 사용하도록 한다.
        rttr.addAttribute("boardNumber", boardVO.getBoardNumber());
        // 객체를 화면에 전달할 때에는 Flash 사용
        rttr.addFlashAttribute("criteria", criteria);
        log.info("----------criteria : " + criteria);
        return new RedirectView("/board/read");
    }


    @PostMapping("remove")
    public String remove(Long boardNumber, Model model, Criteria criteria){
            boardService.remove(boardNumber);
            return getList(model, criteria);
    }


    @GetMapping("login")
    public void login(){}

    @PostMapping("login")
    public String login(TestVO testVO, Model model){
        if(testVO.getId().equals("admin")){
            model.addAttribute("id", testVO.getId());
            return "/board/admin";
        }if (testVO.getId().equals("user")){
            model.addAttribute("id", testVO.getId());
            return "/board/user";
        }
        return "error";
    }
}