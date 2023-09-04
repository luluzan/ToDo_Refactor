package com.todolist.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {

    ToDo task1;
    @BeforeEach
    public void initEach(){
        task1=new ToDo(1L, "testear front", "Usar Mockito y pañuelo", Date.valueOf("2023-09-22"), false, ToDo.Priority.valueOf("normal"), "Sin Categoria"  );
    }

    @Test
    void getId() {
        assertEquals(task1.getId(), 1);
    }

    @Test
    void getTitle() {
        assertEquals(task1.getTitle(), "testear front");
    }

    @Test
    void getDescription() {
        assertEquals(task1.getDescription(), "Usar Mockito y pañuelo");
    }

    @Test
    void getDueDate() {
        assertEquals(task1.getDueDate(), Date.valueOf("2023-09-22"));
    }

    @Test
    void isStatus() {
        assertEquals(task1.isStatus(),false);
    }

    @Test
    void getPriority() {
        assertEquals(task1.getPriority(),ToDo.Priority.valueOf("normal"));
    }

    @Test
    void getCategory() {
        assertEquals(task1.getCategory(),"Sin Categoria");
    }

    @Test
    void setId() {
        task1.setId(2);
        assertEquals(task1.getId(), 2);
    }

    @Test
    void setTitle() {
        task1.setTitle("Pasa el test");
        assertEquals(task1.getTitle(),"Pasa el test" );
    }

    @Test
    void setDescription() {
        task1.setDescription("Pasa el test");
        assertEquals(task1.getDescription(),"Pasa el test" );
    }

    @Test
    void setDueDate() {
        task1.setDueDate(Date.valueOf("2023-09-08"));
        assertEquals(task1.getDueDate(),Date.valueOf("2023-09-08") );
    }

    @Test
    void setStatus() {
        task1.setStatus(true);
        assertEquals(task1.isStatus(),true );
    }

    @Test
    void setPriority() {
        task1.setPriority(ToDo.Priority.valueOf("high"));
        assertEquals(task1.getPriority(),ToDo.Priority.valueOf("high"));
    }

    @Test
    void setCategory() {
        task1.setCategory("5");
        assertEquals(task1.getCategory(),"5");
    }
}