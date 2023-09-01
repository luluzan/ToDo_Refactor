package com.todolist.repository;

import com.todolist.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDosRepository extends JpaRepository<ToDo, Long> {
}
