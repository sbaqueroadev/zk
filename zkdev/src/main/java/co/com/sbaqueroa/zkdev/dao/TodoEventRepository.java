package co.com.sbaqueroa.zkdev.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.client.model.FindOneAndDeleteOptions;

import co.com.sbaqueroa.zkdev.entity.TodoEvent;

public interface TodoEventRepository extends MongoRepository<TodoEvent, Integer>{

	/**
	 * Hibernate's entity manager.
	 */
	
	public List<TodoEvent> findAll();
	
	
	public Optional<TodoEvent> findById(String string);
	
	public void delete(TodoEvent evt);
	
	public TodoEvent insert(TodoEvent evt);
	
	public boolean existsById(String id);


	//public TodoEvent refresh(TodoEvent todoEvent);

}