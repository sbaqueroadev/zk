package co.com.sbaqueroa.zkdev.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.sbaqueroa.zkdev.dto.TodoEventDTO;

@Entity
@Table(name = "todoEvent")
public class TodoEvent implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String name = "";

	@Column(nullable = false)
	private int priority = 0;
	
	@Column(nullable = false)
	private Date date = new Date();

	public TodoEvent() {
	}

	public TodoEvent(Integer id, String name, int priority, Date date) {
    this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id < 0) ? 0 : id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		TodoEvent other = (TodoEvent)obj;
		if(id<0) {
			if(other.id<0)
				return false;
		} else if(id != other.id)
			return false;
		return true;
	}

}
