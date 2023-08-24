package com.todolist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Date;

@Entity
@Table(name = "todo")
@CrossOrigin(origins = "*")
@Getter
@Setter
public class ToDo {
    public ToDo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private Date dueDate;

    @Column
    private boolean status;

    @Column(columnDefinition = "varchar(255) default 'normal'")
    private String priority;

    @Column
    private String category;

}
