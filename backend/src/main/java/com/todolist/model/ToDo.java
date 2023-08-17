package com.todolist.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date dueDate;

    @Column(nullable = false)
    private status status;

    public enum status{
        completed,
        pending
    };
}
