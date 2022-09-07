package com.example.taskmanager.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Data
@Table
@AllArgsConstructor
// @NoArgsConstructor
@Getter @Setter 
@Builder 
@ToString
public class Task {

    @Id private String id;
    private String userId;
    private String title;
    private String description;
    private String status;
    private LocalDate startDate;
    private LocalDate dueDate;
    @CreationTimestamp private LocalDateTime createdAt;
    @UpdateTimestamp private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private Boolean isDeleted;

    public Task(){
        this.id = UUID.randomUUID().toString();
        this.userId = "1";
        this.startDate = LocalDate.now();
        this.dueDate = LocalDate.now();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public Task(String title, String description, String status){

        String userID = "1";

        this.title = title;
        this.description = description;
        this.status = status;

        this.id = UUID.randomUUID().toString();
        this.userId = userID;
        
        this.createdBy = userID;
        this.updatedBy = userID;
    }
    

}
