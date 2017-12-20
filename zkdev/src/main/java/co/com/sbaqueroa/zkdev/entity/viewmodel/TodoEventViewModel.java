
package co.com.sbaqueroa.zkdev.entity.viewmodel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import co.com.sbaqueroa.zkdev.dao.TodoEventDAO;
import co.com.sbaqueroa.zkdev.dao.TodoEventRepository;
import co.com.sbaqueroa.zkdev.dto.TodoEventDTO;
import co.com.sbaqueroa.zkdev.entity.TodoEvent;
import co.com.sbaqueroa.zkdev.exceptions.NotPersistEntity;
import co.com.sbaqueroa.zkdev.exceptions.TodoEventNoExistException;

/*
* @author: gasdsba - sbaqueroa@gmail.com
* TodoEventViewModel:  
*/


public class TodoEventViewModel {

	private TodoEventDAO eventDao;
	private List<TodoEvent> events = new ArrayList<TodoEvent>();
	private TodoEventDTO selectedTodoEventDTO = new TodoEventDTO();
	private TodoEvent selectedTodoEvent = null;
	
	public TodoEventViewModel(){
		super();
	}
	
	public TodoEventViewModel(TodoEventDAO repository){
		super();
		this.eventDao = repository;
	}

	public List<TodoEvent> getEvents() throws Exception {
		this.events = eventDao.findAll();
		return events;
	}

	public void setEvents(List<TodoEvent> events) {
		this.events = events;
	}

	public void setEventDao(TodoEventDAO eventDao) {
		this.eventDao = eventDao;
	}

	public TodoEventDTO getSelectedTodoEventDTO() {
		return this.selectedTodoEventDTO;
	}

	public void setSelectedTodoEventDTO(TodoEventDTO selectedTodoEventDTO) {
		this.selectedTodoEventDTO = selectedTodoEventDTO;
	}
	
	@NotifyChange({"selectedTodoEventDTO","selectedTodoEvent"})
	public void setSelectedTodoEvent(TodoEvent selectedTodoEvent) throws Exception {
		TodoEventDTO evt = new TodoEventDTO(selectedTodoEvent);
		this.setSelectedTodoEventDTO(evt);
		this.selectedTodoEvent = selectedTodoEvent;
	}
	
	

	public TodoEventDAO getEventDao() {
		return eventDao;
	}

	public TodoEvent getSelectedTodoEvent() {
		return selectedTodoEvent;
	}

	@Command("add")
	@NotifyChange({"events","selectedTodoEvent","selectedTodoEventDTO"})
	public boolean insert() throws Exception {
		this.getSelectedTodoEventDTO().setId(null);
		TodoEvent todoEvent = new TodoEvent(this.getSelectedTodoEventDTO());
		if(this.eventDao.insert(todoEvent)){
			this.resetSelection();
			return true;
		}
		return false;
	}

	@Command("update")
	@NotifyChange({"events","selectedTodoEvent","selectedTodoEventDTO"})
	public void update() throws TodoEventNoExistException {
		TodoEvent todoEvent = new TodoEvent(this.getSelectedTodoEventDTO());
		this.eventDao.update(todoEvent);
		this.resetSelection();
	}

	private void resetSelection() {
		this.selectedTodoEvent = null;
		this.selectedTodoEventDTO = new TodoEventDTO();
	}

	@Command("delete")
	@NotifyChange({"events","selectedTodoEvent","selectedTodoEventDTO"})
	public void delete() throws Exception {
		TodoEvent todoEvent = new TodoEvent(this.getSelectedTodoEventDTO());
		this.eventDao.delete(todoEvent);
		this.resetSelection();
	}
	
	
		
}
