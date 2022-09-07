package com.example.taskmanager.Task;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// @ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    @Disabled
    void testCreateTask() {
        Task sampleTask = new Task("New Task", "A new Task", "ongoing");
        // this.mvc.perform(post("/tasks", sampleTask)).andExpect(content().)
    }

    @Test
    @Disabled
    void testDeleteTask() {

    }

    @Test
    @Disabled
    void testGetSingleTask() {

    }

    @Test
    void testGetTasks() {

    }

    @Test
    @Disabled
    void testUpdateTask() {

    }

    @Test
    void testCreateTask2() {
        
    }

    @Test
    void testDeleteTask2() {
        
    }

    @Test
    void testGetSingleTask2() {
        
    }

    @Test
    void testGetTasks2() {
        
    }

    @Test
    void testUpdateTask2() {
        
    }
}
