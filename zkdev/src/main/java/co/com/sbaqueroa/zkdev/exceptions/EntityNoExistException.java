package co.com.sbaqueroa.zkdev.exceptions;

import javax.persistence.EntityNotFoundException;

public class EntityNoExistException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2950882625177836855L;
	
	public EntityNoExistException(String message){
		super(message);
	}

}
