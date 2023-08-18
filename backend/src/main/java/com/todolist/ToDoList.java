package com.todolist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-local.properties")
public class ToDoList {

	public static void main(String[] args) {
		SpringApplication.run(ToDoList.class, args);
	}

}
