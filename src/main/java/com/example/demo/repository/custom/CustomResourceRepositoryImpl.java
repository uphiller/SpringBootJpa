package com.example.demo.repository.custom;

import com.example.demo.entity.QProject;
import com.example.demo.entity.QResource;
import com.example.demo.entity.Resource;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomResourceRepositoryImpl extends QuerydslRepositorySupport implements CustomResourceRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public CustomResourceRepositoryImpl(){
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
	
	

}
