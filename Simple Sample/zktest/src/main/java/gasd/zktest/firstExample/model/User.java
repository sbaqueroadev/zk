
/* Archivo: User.java
* Fecha: 14/12/2017
* Todos los derechos de propiedad intelectual e industrial sobre esta
* aplicacion son de propiedad exclusiva del GRUPO ASESORIA EN
* SISTEMATIZACION DE DATOS SOCIEDAD POR ACCIONES SIMPLIFICADA – GRUPO ASD
* S.A.S.
* Su uso, alteracion, reproduccion o modificacion sin la debida
* consentimiento por escrito de GRUPO ASD S.A.S.
* autorizacion por parte de su autor quedan totalmente prohibidos.
* 
* Este programa se encuentra protegido por las disposiciones de la
* Ley 23 de 1982 y demas normas concordantes sobre derechos de autor y
* propiedad intelectual. Su uso no autorizado dara lugar a las sanciones
* previstas en la Ley.
*/
	
package gasd.zktest.firstExample.model;

import java.util.ArrayList;
import java.util.Collection;

/*
* @author: gasdsba - 
* User:  
*/
public class User {
	private String name;
	private String title;
	private int age;
	
	static Collection<User> users = new ArrayList<User>();
	
	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public static Collection<User> getAll() {
		if(users.size()==0){
			User a = new User();
			a.setName("Sergio Baquero");
			a.setAge(25);
			a.setTitle("Java Developer");
			User b = new User();
			b.setName("Some else");
			b.setAge(100);
			b.setTitle("Other title");
			users.add(b);
			users.add(a);
		}
		return users;
	}
	
	
}
