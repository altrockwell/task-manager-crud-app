package com.example.taskmanager.Sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SampleController.class)
public class SampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSayHello() throws Exception {
        mockMvc
        .perform(post("/hello")
        .contentType(MediaType.APPLICATION_JSON)
        .param("name", "Maria"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().string("Hello World Maria"))
        .andExpect(status().isOk());
    }
}
