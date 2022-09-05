package com.example.taskmanager.Task;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;
    private TaskService underTest;
    private AutoCloseable autoCloseable;
    private Task sampleTask;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TaskService(taskRepository);
        sampleTask = new Task();
        
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
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
        // when
        Task task = new Task();
        underTest.addNewTask(task);

        // then
        verify(taskRepository).save(task);
    }

    @Test
    void testDeleteTask() {
        // when
        
        underTest.deleteTask(sampleTask.getId());

        // then
        verify(taskRepository).deleteById(sampleTask.getId());
    }

    @Test
    @Disabled
    void testGetAllTasks() {
        
    }

    @Test
    @Disabled
    void testGetByTaskId() {
        
    }

    
}
