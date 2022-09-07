package com.example.taskmanager.Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 

// @ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @MockBean
    private TaskService taskService;

    @Autowired
    private MockMvc mockMvc;

    private Task sampleTask;

    @BeforeEach
    void setUp(){
         sampleTask = Task.builder()
                        // .id("1L")
                        // .userId("user1")
                        .title("New Task")
                        .description("A new Task")
                        .status("ongoing")
                        .build();
    }


    @Test
    // @Disabled
    void testCreateTask() throws Exception{

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(sampleTask);

        mockMvc
        .perform(post("/tasks")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isCreated());
        
    }

    @Test
    void testDeleteTask() throws Exception{
        
        when(taskService.deleteTask(sampleTask.getId())).thenReturn(Optional.of(sampleTask));
        
        mockMvc.perform(delete("/tasks/", sampleTask.getId())).andExpect(status().isOk());

    }

    @Test
    void testGetSingleTask() throws Exception{

        when(taskService.getByTaskId(sampleTask.getId()))
        .thenReturn(Optional.of(sampleTask));

        mockMvc
        .perform(get("/tasks/{id}", sampleTask.getId()))
        .andExpect(status().isOk());
    }

    @Test
    void testGetTasks() throws Exception {
        mockMvc.perform(get("/tasks")).andExpect(status().isOk());
    }

    @Test
    void testUpdateTask() throws Exception{
        when(taskService.updateTaskById(sampleTask.getId(),sampleTask))
        .thenReturn(sampleTask);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(sampleTask);

        mockMvc.perform(put("/tasks/{id}", sampleTask.getId()).content(json).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

}
