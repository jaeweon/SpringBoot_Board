package com.example.boardprac.domain.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class BoardControllerTests {
    // 마치 브라우저에서 URL을 요청한 것 처럼 환경을 구성해준다.
    private MockMvc mockMvc;
    // 요청을 처리해주는 WebApplicationContext를 불러온다.
    @Autowired
    private WebApplicationContext webApplicationContext;





}
