package co.com.sbaqueroa.zkdev.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.sbaqueroa.zkdev.dto.TodoEventDTO;

@Document(collection = "todoEvent")
public class TodoEvent implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;
	private int priority;
	private Date date;

	public TodoEvent() {
	}

	public TodoEvent(String name, int priority, Date date) {
    this.name = name;
    this.priority = priority;
    this.date = date;
}

	public TodoEvent(TodoEventDTO eventDTO) {
		this.id = eventDTO.getId();
		this.name = eventDTO.getName();
		this.priority = eventDTO.getPriority();
		this.date = eventDTO.getDate();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

}
