package com.example.demo.repository.custom;

import com.example.demo.entity.Resource;

import java.util.List;


public interface CustomResourceRepository {
	List<Resource> findByName(String name);

}
