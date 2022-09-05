package com.example.taskmanager.Task;

import java.util.List;

// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    
    public List<Task> findByUserId(String userId);

    // @Query("Select * from Task")
    // public List<Task> getAllTask();
    
    

}
