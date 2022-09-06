package com.example.taskmanager.Task;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
// @DataJpaTest
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService underTest;
    // private TaskRepository sampleTaskRepository;
    private Task sampleTask;
    

    @BeforeEach
    void setUp(){
        underTest = new TaskService(taskRepository);
        sampleTask = Task.builder()
                        .title("New Task")
                        .description("A new Task")
                        .status("ongoing")
                        .build();
    }

    @Test    
    void testGetUserTasks() {
        // when 
        Task task = new Task();
        underTest.getUserTasks(task.getUserId());

        // then
        verify(taskRepository).findByUserId(task.getUserId());
    }

    @Test
    void testAddNewTask() {
        // given
        Task task = new Task("Task 1", "A new Task", "ongoing");
        
        // when
        underTest.addNewTask(task);

        // then
        ArgumentCaptor<Task> taskArgumentCaptor = ArgumentCaptor.forClass(Task.class);

        verify(taskRepository).save(taskArgumentCaptor.capture());
        Task capturedTask = taskArgumentCaptor.getValue();
        assertThat(capturedTask).isEqualTo(task);
    }

    @Test
    // @Disabled
    void testDeleteTask() {

        willDoNothing().given(taskRepository).deleteById("123");
        
        underTest.deleteTask("123");

        verify(taskRepository).deleteById("123");

        
    }

    @Test
    @Disabled
    void testGetAllTasks() {
        
    }

    @Test
    // @Disabled
    void testGetByTaskId() {
        underTest.getByTaskId("123");

        verify(taskRepository).findById("123");

    }

    @Test
    void testUpdateTaskById() {
        // taskRepository.save(sampleTask);
        when(taskRepository.findById(sampleTask.getId())).thenReturn(Optional.of(sampleTask) );

        Task result = underTest.updateTaskById(sampleTask.getId(),sampleTask);

        assertThat(result.getTitle()).isEqualTo(sampleTask.getTitle());
        
    }

    
}
