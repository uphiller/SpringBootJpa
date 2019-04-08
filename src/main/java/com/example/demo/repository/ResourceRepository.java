package com.example.demo.repository;

import com.example.demo.entity.Resource;
import com.example.demo.repository.custom.CustomResourceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ResourceRepository extends JpaRepository<Resource, Integer>, JpaSpecificationExecutor<Resource>, CustomResourceRepository {
	List<Resource> findAll();
}
