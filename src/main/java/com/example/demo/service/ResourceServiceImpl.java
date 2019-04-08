package com.example.demo.service;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService{
	@Autowired
	ResourceRepository resourceRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Resource> getAllUser() {
		return resourceRepository.findAll();
	}
	
	public List<Resource> getResources() {
		return resourceRepository.findByName("java");
	}

	@Transactional
	public void saveResource() {
		try {
			Resource rs = new Resource();
			rs.setName("Go");
			resourceRepository.save(rs);
			//if(1 != 0 ) throw new Exception("aaa");
		} catch (Exception e) {
			throw new RuntimeException("file not found");
		}
	}
}
