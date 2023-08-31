package com.todolist;

import com.todolist.model.ToDo;
import com.todolist.repository.ToDosRepository;
import com.todolist.services.ToDosServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApirestTodolistApplicationTests {

	@InjectMocks
	ToDosServices myServices;

	@Mock
	ToDosRepository myRepository;

	@Test
	void test_should_get_all_tasks() {
		//Entorno
		ToDo task1= new ToDo(1L,"Hacer test de back", "Implementar mockito",);
	}

}
