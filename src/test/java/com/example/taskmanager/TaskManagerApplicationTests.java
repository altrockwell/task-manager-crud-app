package com.example.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TaskManagerApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void contextLoads() {
		
	}

	@Test
	void itShouldReturnCorrect(){
		//given
		int num1 = 2;
		int num2 = 3;

		//when
		int result = underTest.add(num1, num2);

		//then
		assertThat(result).isEqualTo(5);
	}

	class Calculator{
		int add(int num1, int num2){ return num1 + num2;}
	}

}
