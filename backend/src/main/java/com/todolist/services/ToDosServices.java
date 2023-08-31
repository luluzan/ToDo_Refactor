package com.todolist.services;

import com.todolist.model.ToDo;
import com.todolist.repository.ToDosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ToDosServices {
    @Autowired
    ToDosRepository toDosRepository;

    public String saveTask(ToDo toDo) {
        try{
            toDosRepository.save(toDo);
            return "Added new task";
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public ToDo getTaskById(long id) {
        return (ToDo) toDosRepository.findById(id).orElse(null);
    }

    public ArrayList<ToDo> getAllTasks() {
        return (ArrayList<ToDo>) toDosRepository.findAll();
    }

    public String deleteTask(long id) {
        try{
            toDosRepository.deleteById(id);
            return "Deleted "+id;
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public String updateTask(ToDo updateTask) {
        try {
            if (toDosRepository.existsById(updateTask.getId())) {
                toDosRepository.save(updateTask);
                return ("Task updated: " + updateTask.getTitle());
            } else {
                return ("Task not updated: Record with ID :"+ updateTask.getId() + "does not exist");
            }
        }catch(Exception error) {
            throw new RuntimeException("Task not updated: "+error.getMessage());
        }
    }
}
