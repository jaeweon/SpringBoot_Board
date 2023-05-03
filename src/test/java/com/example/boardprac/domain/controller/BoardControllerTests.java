package com.example.boardprac.domain.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class BoardControllerTests {
    // 마치 브라우저에서 URL을 요청한 것 처럼 환경을 구성해준다.
    private MockMvc mockMvc;
    // 요청을 처리해주는 WebApplicationContext를 불러온다.
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach // 메소드 중 가장 최 우선으로 실행
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Test
//    public void getListTest() throws Exception{
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap().toString());
//    }

//    @Test
//    public void registerTest() throws Exception{
//        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//                .param("boardTitle", "컨트롤러 테스트 제목1")
//                .param("boardContent", "컨트롤러 테스트 내용1")
//                .param("boardWriter", "컨트롤러 유저1")).andReturn().getFlashMap().toString());
//    }

//    @Test
//    public void readTest() throws Exception{
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read").param("boardNumber",  "183")).andReturn().getModelAndView().toString());
//    }


//    @Test
//    public void modifyTest() throws Exception{
//        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//                .param("boardNumber", "183")
//                .param("boardTitle", "수정 컨트롤러 테스트 제목")
//                .param("boardContent", "수정 컨트롤러 테스트 내용")).andReturn().getModelAndView().getModelMap().toString());
//    }

    @Test
    public void deleteTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove").param("boardNumber", "183")).andReturn().getModelAndView().getViewName().toString());
    }





}
