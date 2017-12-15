package co.com.sbaqueroa.zkdev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.sbaqueroa.zkdev.entity.TodoEvent;

@Repository
public class TodoEventRepository{

	private static final Logger logger = LoggerFactory.getLogger(TodoEventRepository.class);
	
	/**
	 * Hibernate's entity manager.
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<TodoEvent> findAll() throws Exception {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<TodoEvent> cq = builder.createQuery(TodoEvent.class);
	    Root<TodoEvent> root = cq.from(TodoEvent.class);
	    cq.select(root);
	    logger.info("Getting All TodoEvent entities");
	    return entityManager.createQuery(cq).getResultList();
	}
	
	
	public TodoEvent findById(int id) throws Exception {
		logger.info("getting TodoEvent by id");
		TodoEvent evt = entityManager.find(TodoEvent.class,id);
		return evt;
	}
	@Transactional(readOnly=false)
	public void delete(TodoEvent evt) throws Exception {
		logger.info("deleting TodoEvent by id");
		if (!entityManager.contains(evt))
			evt = this.findById(evt.getId());
		entityManager.remove(evt);
		entityManager.flush();
	}
	
	@Transactional(readOnly=false)
	public TodoEvent save(TodoEvent evt) throws Exception {
		entityManager.persist(evt);
		entityManager.flush();
		return evt;
	}

	@Transactional(readOnly=false)
	public TodoEvent update(TodoEvent evt) throws Exception {
		entityManager.merge(evt);
		entityManager.flush();
		return evt;
	}


	public TodoEvent refresh(TodoEvent todoEvent) throws Exception {
		if (!entityManager.contains(todoEvent)){
			todoEvent = this.findById(todoEvent.getId());
		}else{
			entityManager.refresh(todoEvent);
		}
		return todoEvent;
	}

}