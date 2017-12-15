package co.com.sbaqueroa.zkdev.dto;

import java.util.Date;

import javax.persistence.Column;

import co.com.sbaqueroa.zkdev.entity.TodoEvent;

public class TodoEventDTO {

	private Integer id;
	private String name = "";
	private int priority = 0;
	private Date date = new Date();

	public TodoEventDTO() {
	}

	public TodoEventDTO(Integer id, String name, int priority, Date date) {
    this.id = id;
    this.name = name;
    this.priority = priority;
    this.date = date;
}

	public TodoEventDTO(TodoEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.priority = event.getPriority();
		this.date = event.getDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
