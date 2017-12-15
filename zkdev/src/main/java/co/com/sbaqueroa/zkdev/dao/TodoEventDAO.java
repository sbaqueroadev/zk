package co.com.sbaqueroa.zkdev.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sbaqueroa.zkdev.entity.TodoEvent;
import co.com.sbaqueroa.zkdev.exceptions.TodoEventNoExistException;



public class TodoEventDAO {
  
	@Autowired
	private TodoEventRepository todoEventRepository;

	public TodoEventDAO(TodoEventRepository repository){
		this.todoEventRepository = repository;
	}
	
	public TodoEventDAO() {
		super();
	}

	public List<TodoEvent> findAll() {
		try {
			return todoEventRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<TodoEvent>();
  }
   
  public boolean delete(TodoEvent evt) throws Exception {
  	todoEventRepository.delete(evt);
  	if (todoEventRepository.findById(evt.getId()) != null ){
  		return false;
  	}else{
  		return true;
  	}
  	
  }
   
  public boolean insert(TodoEvent evt) throws Exception {
  	TodoEvent tEvt= todoEventRepository.save(evt);
  	if(tEvt != null){
  		return true;
  	}else{
  		return false;
  	}
  }
   
  public boolean update(TodoEvent evt) throws TodoEventNoExistException {
  	try {
			if (todoEventRepository.findById(evt.getId()) != null ){
				TodoEvent tEvt= todoEventRepository.update(evt);
				if(tEvt == null){
					return false;
				}
			}else{
				throw new TodoEventNoExistException("No existe Evento Pendiente con id: " + evt.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
  	return true;
  }

	public TodoEvent refresh(TodoEvent todoEvent) throws Exception {
		return this.todoEventRepository.refresh(todoEvent);
	}
}
