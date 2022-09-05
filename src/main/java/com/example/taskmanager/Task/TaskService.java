package com.example.taskmanager.Task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public List<Task> getUserTasks(String userId){
        return taskRepository.findByUserId(userId);
    }

    public Task addNewTask(Task task){
        return taskRepository.save(task);
    }

    

    public Task deleteTask(String id){
        Optional<Task> task = taskRepository.findById(id);


        if(!task.isPresent() || task.isEmpty()){
            throw new IllegalStateException("Task is not found!");
        }
        taskRepository.deleteById(id);
        return task.get();
    }

    
    public Task getByTaskId(String id){
        Optional<Task> task = taskRepository.findById(id);
        return task.get();
    }
}
