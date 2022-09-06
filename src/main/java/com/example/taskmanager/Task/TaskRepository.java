package com.example.taskmanager.Task;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    
    public List<Task> findByUserId(String userId);

    // @Query("Delete from Task where id = ?1")
    // public Optional<Task> removeByID(String id);

    // @Query("Select * from Task")
    // public List<Task> getAllTask();
    
    // @Modifying
    // @Query(value = "update Task t set t.title = ?2, t.description= ?3, t.status=?4 where t.id = ?1")
    // public Task updateTaskById(String id, String title, String description, String status);
    

}
