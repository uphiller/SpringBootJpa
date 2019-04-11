package com.example.demo.repository.impl;

import com.example.demo.entity.QResource;
import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Resource> findAll() {
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		QResource resource = QResource.resource;

		return queryFactory.selectFrom(resource).fetch();
	}

	@Override
	public void save(Resource rs) {
		em.persist(rs);
	}

	@Override
	@Transactional
	public boolean deleteByName(Resource param) {
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		QResource resource = QResource.resource;
		queryFactory.delete(resource).where(resource.name.eq(param.getName())).execute();
		return true;
	}


}
