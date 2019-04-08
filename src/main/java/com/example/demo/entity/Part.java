package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Part {

    @Id
    @GeneratedValue
    private Long idx;

    @Column(length = 30, nullable = false)
    private String name;
}