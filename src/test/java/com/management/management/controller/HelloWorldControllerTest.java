package com.management.management.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldControllerTest {
    @Autowired
    private HelloWorldController HelloWorldController;

    private MockMvc mockMvc;
    @Test
    void helloWorld() {
        System.out.println(HelloWorldController.helloWorld());

        assertThat(HelloWorldController.helloWorld()).isEqualTo("HelloWorld");
//        assertThat(HelloWorldController.HelloWorldController()).isEqualTo("HelloWorld");
        //AssertionThat(2번쨰꺼 넣음)
    }

    @Test
    void mockMvcTest() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(HelloWorldController).build();

        mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/helloWorld"))
        MockMvcRequestBuilders.post("/api/helloWorld"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));
    }
}