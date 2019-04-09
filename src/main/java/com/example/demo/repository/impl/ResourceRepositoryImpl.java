package com.example.demo.repository.impl;

import com.example.demo.entity.QProject;
import com.example.demo.entity.QResource;
import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ResourceRepositoryImpl extends QuerydslRepositorySupport implements ResourceRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public ResourceRepositoryImpl(){
 		super(Resource.class);
	}

	@Override
	public List<Resource> findByName(String name) {
		JPAQuery<Resource> queryFactory = new JPAQuery<Resource>(em);
		QResource resource = QResource.resource;
		QProject project = QProject.project;

		return queryFactory
			  .from(resource)  
			  .where(resource.name.eq(name))
			  .fetch();
	}

	@Override
	public void save(Resource rs) {
		em.persist(rs);
	}


}
