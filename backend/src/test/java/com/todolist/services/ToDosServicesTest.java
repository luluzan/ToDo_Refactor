package com.todolist.services;
import com.todolist.model.ToDo;
import com.todolist.repository.ToDosRepository;
import com.todolist.services.ToDosServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ToDosServicesTest {

    @InjectMocks
    ToDosServices myServices;

    @Mock
    ToDosRepository myRepository;

    @Test
    void test_should_get_all_tasks() {

        ToDo task1=new ToDo(1L, "testear front", "Usar Mockito y pañuelo", Date.valueOf("2023-09-22"), false, ToDo.Priority.valueOf("normal"), "Sin Categoria"  );
        ToDo task2=new ToDo(2L, "testear back", "Usar vitest y lo que haga falta", Date.valueOf("2023-09-21"), false, ToDo.Priority.valueOf("urgent"), "Con Categoria"  );

        ArrayList<ToDo> myArrayList=new ArrayList<>();
        myArrayList.add(task1);
        myArrayList.add(task2);

        when(myRepository.findAll()).thenReturn(myArrayList);

        ArrayList<ToDo> myResult=myServices.getAllTasks();

        assertEquals(myResult, myArrayList);
    }

    @Test
    void test_should_get_a_tasks() {

        ToDo task1=new ToDo(1L, "testear front", "Usar Mockito y pañuelo", Date.valueOf("2023-09-22"), false, ToDo.Priority.valueOf("normal"), "Sin Categoria"  );
        ToDo task2=new ToDo(2L, "testear back", "Usar vitest y lo que haga falta", Date.valueOf("2023-09-21"), false, ToDo.Priority.valueOf("urgent"), "Con Categoria"  );

        ArrayList<ToDo> myArrayList=new ArrayList<>();
        myArrayList.add(task1);
        myArrayList.add(task2);

        when(myRepository.findById(1L)).thenReturn(Optional.of(task1));

        ToDo myResult=myServices.getTaskById(1);

        assertEquals(myResult, task1);
    }

    @Test
    void test_should_delete_a_task() {
        //Creo un entorno, una base de datos falsa:
        ToDo task1=new ToDo(1L, "testear front", "Usar Mockito y pañuelo", Date.valueOf("2023-09-22"), false, ToDo.Priority.valueOf("normal"), "Sin Categoria"  );
        ToDo task2=new ToDo(2L, "testear back", "Usar vitest y lo que haga falta", Date.valueOf("2023-09-21"), false, ToDo.Priority.valueOf("urgent"), "Con Categoria"  );

        ArrayList<ToDo> myArrayList=new ArrayList<>();
        myArrayList.add(task1);
        myArrayList.add(task2);

        //Defino lo que va a pasar cuando intente acceder a la BBDD verdadera, es como hacerle un puente al coche
        when(myRepository.existsById(1L)).thenReturn(true);	//Cuando pase por estos metodos, diseñamos lo que tiene que ocurrir
        when(myRepository.existsById(3L)).thenReturn(false);

        doNothing().when(myRepository).deleteById(1L);	//Como el metodo devuelve void, se pone de esta forma
        lenient().doNothing().when(myRepository).deleteById(3L);	//Esta linea no es necesaria porque nunca vamos a llegar a ella. Lenient() le dice al test que no nos de error aunque el flujo no pase nunca por este metodo (se podria borrar directamente)

        String myResult=myServices.deleteTask(1);
        String myResult3=myServices.deleteTask(3);	//La tarea no existe

        //Iniciamos las comprobaciones
        verify(myRepository).deleteById(1L);	//Comprueba si se ha llamado a un metodo concreto (Como este devuelve void, es importante saber si ha pasado por él)
        //verify(myRepository).deleteById(3L);	//Por aqui NO queremos que pase, para eso ponemos el "if" en ToDoServices.deleteTask()

        assertEquals(myResult, "Deleted 1");
        assertEquals(myResult3, "Task doesn't exist");
    }

    @Test
    void test_should_update_a_task() {

        ToDo task1=new ToDo(1L, "testear front", "Usar Mockito y pañuelo", Date.valueOf("2023-09-22"), false, ToDo.Priority.valueOf("normal"), "Sin Categoria"  );
        ToDo task2=new ToDo(2L, "testear back", "Usar vitest y lo que haga falta", Date.valueOf("2023-09-21"), false, ToDo.Priority.valueOf("urgent"), "Con Categoria"  );

        ArrayList<ToDo> myArrayList=new ArrayList<>();
        myArrayList.add(task1);
        myArrayList.add(task2);

        when(myRepository.existsById(task1.getId())).thenReturn(true);
        when(myRepository.existsById(task2.getId())).thenReturn(false);
        lenient().when(myRepository.existsById(null)).thenThrow(new IllegalArgumentException("Cannot invoke \"com.todolist.model.ToDo.getId()\" because \"updateTask\" is null") );

        when(myRepository.save(task1)).thenReturn(task1);
        lenient().when(myRepository.save(task2)).thenReturn(task2);
        //when(myRepository.save(null)).thenThrow(IllegalArgumentException.class );

        String myResult=myServices.updateTask(task1);
        String myResult2=myServices.updateTask(task2);
        String myResult3=myServices.updateTask(null);

        assertEquals(myResult,"Task updated: testear front" );
        assertEquals(myResult2, "Task not updated: Record with ID : 2 does not exist");
        assertEquals(myResult3,"Task not updated: Cannot invoke \"com.todolist.model.ToDo.getId()\" because \"updateTask\" is null" );
    }

    @Test
    void test_should_save_a_task() {

        ToDo task1=new ToDo(1L, "testear front", "Usar Mockito y pañuelo", Date.valueOf("2023-09-22"), false, ToDo.Priority.valueOf("normal"), "Sin Categoria"  );
        ToDo task2=new ToDo(2L, "testear back", "Usar vitest y lo que haga falta", Date.valueOf("2023-09-21"), false, ToDo.Priority.valueOf("urgent"), "Con Categoria"  );

        ArrayList<ToDo> myArrayList=new ArrayList<>();
        myArrayList.add(task1);
        myArrayList.add(task2);

        when(myRepository.findIfItAlreadyExists(task1)).thenReturn(false);
        when(myRepository.findIfItAlreadyExists(task2)).thenReturn(true);

        when(myRepository.save(task1)).thenReturn(task1);
        lenient().when(myRepository.save(task2)).thenReturn(task2);

        String myResult=myServices.saveTask(task1);
        String myResult2=myServices.saveTask(task2);

        assertEquals(myResult,"Added new task" );
        assertEquals(myResult2, "Task already exists");
    }
}