package com.example.demo.repository;

import com.example.demo.entity.Resource;

import java.util.List;


public interface ResourceRepository {
	List<Resource> findByName(String name);
	void save(Resource rs);

}
