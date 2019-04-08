package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long idx;

    @Column(length = 30, nullable = false)
    private String name;
}