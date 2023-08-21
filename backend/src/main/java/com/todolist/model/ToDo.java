package com.todolist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Entity
@Table(name = "todo")
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

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @Column(columnDefinition = "priority default normal")
    private priority priority;

    enum priority {
        urgent,
        normal
    }

    @Column
    private String category;

}
