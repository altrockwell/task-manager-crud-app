package com.example.taskmanager.Task;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task sampleTask;
    

    @BeforeEach
    void setUp(){
         sampleTask = Task.builder()
                        .id("1L")
                        .userId("user1")
                        .title("New Task")
                        .description("A new Task")
                        .status("ongoing")
                        .build();
    }


    @Test
    void testAddNewTask() {
        when(taskRepository.save(sampleTask)).thenReturn(sampleTask);

        Task result = taskService.addNewTask(sampleTask);
        System.out.println(result.getId());
        assertThat(result.getTitle()).isEqualTo(sampleTask.getTitle());
    }


    @Test    
    void testGetUserTasks() {
        when(taskRepository.findByUserId(sampleTask.getUserId())).thenReturn(Arrays.asList(sampleTask));
        
        List<Task> result = taskService.getUserTasks(sampleTask.getUserId());

        verify(taskRepository).findByUserId(sampleTask.getUserId());
        assertThat(result.get(0).getId()).isEqualTo(sampleTask.getId());
    }

    
    @Test
    void testDeleteTask() {
        willDoNothing().given(taskRepository).deleteById(sampleTask.getId());
        when(taskRepository.findById(sampleTask.getId())).thenReturn(Optional.of(sampleTask));
        
        Task result = taskService.deleteTask(sampleTask.getId()).get();
        
        verify(taskRepository).deleteById(sampleTask.getId());
        assertThat(result.getId()).isEqualTo(sampleTask.getId());
    }


    @Test
    void testGetByTaskId() {
        when(taskRepository.findById(sampleTask.getId())).thenReturn(Optional.of(sampleTask));

        Task result = taskService.getByTaskId(sampleTask.getId()).get();

        verify(taskRepository).findById(sampleTask.getId());
        assertThat(result.getId()).isEqualTo(sampleTask.getId());

    }

    @Test
    void testUpdateTaskById() {
        // taskRepository.save(sampleTask);
        when(taskRepository.findById(sampleTask.getId())).thenReturn(Optional.of(sampleTask) );

        Task result = taskService.updateTaskById(sampleTask.getId(),sampleTask);

        assertThat(result.getTitle()).isEqualTo(sampleTask.getTitle());
        
    }

    
}
