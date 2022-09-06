package com.example.taskmanager.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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

    

    public Optional<Task> deleteTask(String id){
        Optional<Task> task = taskRepository.findById(id);
        taskRepository.deleteById(id);
        return task;
    }

    
    public Optional<Task> getByTaskId(String id){
        return taskRepository.findById(id);
    }

    @Modifying
    public Task updateTaskById(String id, Task updatedTask){
        Optional<Task> foundTask = taskRepository.findById(id);
        Task task = foundTask.get();
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());

        task.setUpdatedAt(LocalDateTime.now());

        return task;
    }
}
