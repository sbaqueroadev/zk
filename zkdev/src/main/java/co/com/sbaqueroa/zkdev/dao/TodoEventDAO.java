package co.com.sbaqueroa.zkdev.dao;

import java.util.List;

import co.com.sbaqueroa.zkdev.dao.implementation.TodoEventRepository;
import co.com.sbaqueroa.zkdev.entity.TodoEvent;
import co.com.sbaqueroa.zkdev.exceptions.TodoEventNoExistException;



public class TodoEventDAO {
  
	private TodoEventRepository todoEventRepository;

	public TodoEventDAO(TodoEventRepository repository){
		this.todoEventRepository = repository;
	}
	
	public List<TodoEvent> findAll() {
		return todoEventRepository.findAll();
  }
   
  public boolean delete(TodoEvent evt) {
  	todoEventRepository.delete(evt);
  	if (todoEventRepository.findById(evt.getId()) != null ){
  		return false;
  	}else{
  		return true;
  	}
  	
  }
   
  public boolean insert(TodoEvent evt) {
  	TodoEvent tEvt= todoEventRepository.save(evt);
  	if(tEvt != null){
  		return true;
  	}else{
  		return false;
  	}
  }
   
  public boolean update(TodoEvent evt) {
  	if (todoEventRepository.findById(evt.getId()) != null ){
	  	TodoEvent tEvt= todoEventRepository.save(evt);
	  	if(tEvt == null){
	  		return false;
	  	}
  	}else{
  		throw new TodoEventNoExistException("No existe Evento Pendiente con id: " + evt.getId());
  	}
  	return true;
  }
}
