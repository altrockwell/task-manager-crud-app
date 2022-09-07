package com.example.taskmanager.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(path="/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    @Transactional
    public ResponseEntity<Optional<Task>> deleteTask(@PathVariable("id") String id){
        return ResponseEntity.status(200).body(taskService.deleteTask(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){

        return ResponseEntity.status(200).body(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public Optional<Task> getSingleTask(@PathVariable("id") String id){
        return taskService.getByTaskId(id);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity
        .status(201)
        .body(taskService.addNewTask(task));
    }

    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    @Transactional
    public Task updateTask(@PathVariable("id") String id, @RequestBody Task task){        
        return taskService.updateTaskById(id,task);
    }

    

}
