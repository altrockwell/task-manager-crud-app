package com.example.taskmanager.Task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

import java.util.List;


@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void testFindByUserId() {
        //given
        Task task = new Task("Task 1", "A new Task", "ongoing");
        underTest.save(task);

        // when
        List<Task> result = underTest.findByUserId(task.getUserId());

        // then
        assertThat(result.get(0).getTitle()).isEqualTo("Task 1");

    }
}
