package com.todolist.repository;

import com.todolist.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface ToDosRepository extends JpaRepository<ToDo, Long> {
    //@Query(value = "SELECT EXISTS( SELECT 1 FROM todo WHERE category = :thisCategory AND " +
    //"description = :thisDescription AND due_date =:thisDate AND " +
    //        " status = :thisStatus AND title=:thisTitle)", nativeQuery = true)
    //Boolean findIfItAlreadyExists(String thisCategory, String thisDescription, Date thisDate, boolean status, ToDo.Priority priority, String category );

    @Query(value = "SELECT EXISTS( SELECT 1 FROM todo WHERE category = :#{#myTask.getCategory()} AND " +
            "description = :#{#myTask.getDescription()} AND due_date =:#{#myTask.getDueDate()} AND " +
            " status = :#{#myTask.isStatus()} AND title=:#{#myTask.getCategory()})", nativeQuery = true)
    Boolean findIfItAlreadyExists(@Param("myTask") ToDo myTask);
}
