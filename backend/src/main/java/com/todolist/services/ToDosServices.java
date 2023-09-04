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

    //Deberia revisar si se hay entradas duplicadas
    public String saveTask(ToDo toDo) {
        try{
            //if(toDosRepository.findIfItAlreadyExists(toDo.getCategory(), toDo.getDescription(), toDo.getDueDate(), toDo.isStatus(), toDo.getPriority(), toDo.getCategory()))
            if(toDosRepository.findIfItAlreadyExists(toDo)==false){
                toDosRepository.save(toDo);
                return "Added new task";
            }
            else {
                return "Task already exists";}

        }catch(Exception error) {
            //return error.getMessage();
            return "excepcion";
        }
    }

    public ToDo getTaskById(long id) {
        return (ToDo) toDosRepository.findById(id).orElse(null);
    }

    public ArrayList<ToDo> getAllTasks() {
        return (ArrayList<ToDo>) toDosRepository.findAll();
    }

    //Añadida comprobacion de si la tarea existe o no para borrarla.
    public String deleteTask(long id) {
        try{
            if(toDosRepository.existsById(id)){
                toDosRepository.deleteById(id);
                return "Deleted "+id;
            }
            else return "Task doesn't exist";

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
                return ("Task not updated: Record with ID : "+ updateTask.getId() + " does not exist");
            }
        }catch(Exception error) {
            //throw new RuntimeException("Task not updated: "+error.getMessage());
            return ("Task not updated: "+error.getMessage());
        }
    }
}
