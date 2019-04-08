package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Resource implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(length = 20, nullable = false)
    private String name;
    
    
	/*
	 * @OneToOne(cascade=CascadeType.ALL, targetEntity=Part.class)
	 * 
	 * @JoinColumn(name="partIdx") private Part part;
	 */
}