package com.example.demo.repository;

import com.example.demo.entity.Resource;

import java.util.List;


public interface ResourceRepository {
	List<Resource> findAll();
	void save(Resource rs);
}
