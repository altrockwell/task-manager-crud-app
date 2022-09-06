package com.example.taskmanager.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public Optional<Task> getSingleTask(@PathVariable("id") String id){
        return taskService.getByTaskId(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        Task newTask = taskService.addNewTask(task);
        return newTask;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") String id, @RequestBody Task task){        
        return taskService.updateTaskById(id,task);
    }

    @DeleteMapping("/{id}")
    public Optional<Task> deleteTask(@PathVariable("id") String id){
        return taskService.deleteTask(id);
    }

}
