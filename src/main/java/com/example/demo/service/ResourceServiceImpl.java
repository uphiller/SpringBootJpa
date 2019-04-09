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
@Transactional
public class ResourceServiceImpl implements ResourceService{
	@Autowired
	ResourceRepository resourceRepository;

	public void saveResource() {
		Resource rs = new Resource();
		rs.setName("Nomal");
		resourceRepository.save(rs);
	}

	public void rollbackResourceCheckedException() throws Exception {
		Resource rs = new Resource();
		rs.setName("checkException");
		resourceRepository.save(rs);
		throw new Exception("file not found");
	}

	public void rollbackResourceUncheckedException(){
		Resource rs = new Resource();
		rs.setName("unCheckException");
		resourceRepository.save(rs);
		throw new RuntimeException("file not found");
	}

}
