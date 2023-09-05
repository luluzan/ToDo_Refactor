package com.todolist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.model.ToDo;
import com.todolist.repository.ToDosRepository;
import com.todolist.services.ToDosServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(ToDosController.class)
@AutoConfigureMockMvc
class ToDosControllerTest {

    //entorno
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ToDosServices myServices;

    ArrayList<ToDo> myArrayList;
    ToDo task1=new ToDo(1L, "testear front", "Usar Mockito y pañuelo", Date.valueOf("2023-09-22"), false, ToDo.Priority.valueOf("normal"), "Sin Categoria"  );
    ToDo task2=new ToDo(2L, "testear back", "Usar vitest y lo que haga falta", Date.valueOf("2023-09-21"), false, ToDo.Priority.valueOf("urgent"), "Con Categoria"  );

    @BeforeEach
    public void initEach(){
        myArrayList=new ArrayList<>();
        myArrayList.add(task1);
        //myArrayList.add(task2);
    }

    @Test
    void test_if_can_get_All_Tasks() throws Exception {

        when(myServices.getAllTasks()).thenReturn(myArrayList);

        MockHttpServletResponse request = mockMvc.perform(MockMvcRequestBuilders
            .get("/todo")
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

        assertTrue(myArrayList.contains(task1));
        assertTrue(myArrayList.size()==1);
        assertEquals(200, request.getStatus());
    }

    @Test
    void test_if_can_get_a_Tasks() throws Exception{
        when(myServices.getTaskById(1)).thenReturn(myArrayList.get(0));

        MockHttpServletResponse request = mockMvc.perform(MockMvcRequestBuilders
                        .get("/todo/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertEquals(myArrayList.get(0), task1);
        assertEquals(200, request.getStatus());
    }

    @Test
    void test_if_can_delete_a_Tasks() throws Exception{
        when(myServices.deleteTask(1)).thenReturn("Deleted 1");
        when(myServices.deleteTask(3)).thenReturn("Task doesn't exist");

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .delete("/todo/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        MockHttpServletResponse response2 = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/todo/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertEquals(200, response.getStatus());
        assertEquals("Deleted 1", response.getContentAsString());

        assertEquals(200, response2.getStatus());
        assertEquals("Task doesn't exist", response2.getContentAsString());
    }

    @Test
    void test_if_can_save_a_Tasks() throws Exception{
        when(myServices.saveTask(any(ToDo.class))).thenReturn("Gets services");

        // Crea un ObjectMapper para serializar objetos Java a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String bodyTask2=objectMapper.writeValueAsString(task2);

        //Emula el envio
        MockHttpServletResponse response2 = mockMvc.perform(MockMvcRequestBuilders
                .post("/todo")
                .content(bodyTask2)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertEquals(200, response2.getStatus());
        assertEquals("Gets services", response2.getContentAsString());
    }

    @Test
    void test_if_can_upgrade_a_Tasks() throws Exception {
        when(myServices.updateTask(any(ToDo.class))).thenReturn("Gets services");

        // Crea un ObjectMapper para serializar objetos Java a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String bodyTask2=objectMapper.writeValueAsString(task2);

        //long example=123;
        ToDo toDo=new ToDo();
        toDo.setId(123);

        MockHttpServletResponse response2 = mockMvc.perform(MockMvcRequestBuilders
                .put("/todo/123")
                .content(bodyTask2)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertEquals(200, response2.getStatus());
        assertEquals("Gets services", response2.getContentAsString());
        assertEquals(123, toDo.getId());
    }
}