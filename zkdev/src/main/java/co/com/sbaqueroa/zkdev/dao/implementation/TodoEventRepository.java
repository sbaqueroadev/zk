package co.com.sbaqueroa.zkdev.dao.implementation;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.sbaqueroa.zkdev.entity.TodoEvent;

public interface TodoEventRepository extends JpaRepository<TodoEvent, String>{

	public TodoEvent findById(String id); 
}
