package com.example.taskmanager.Task;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getSingleTask(@PathVariable("id") String id){
        return taskService.getByTaskId(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        Task newTask = taskService.addNewTask(task);
        return newTask;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") String id, @RequestBody Task task){
        Task updatedTask = taskService.getByTaskId(id);
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStatus(task.getStatus());

        updatedTask.setUpdatedAt(LocalDateTime.now());
        
        return updatedTask;
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable("id") String id){
        return taskService.deleteTask(id);
    }

}
