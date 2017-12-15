
/* Archivo: UserResolver.java
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
	
package gasd.zktest.model.resolver;

import org.zkoss.xel.VariableResolver;
import org.zkoss.xel.XelException;

import gasd.zktest.firstExample.model.User;

/*
* @author: gasdsba - 
* UserResolver:  
*/
public class UserResolver implements VariableResolver {

	/* (non-Javadoc)
	 * @see org.zkoss.xel.VariableResolver#resolveVariable(java.lang.String)
	 */
	public Object resolveVariable(String name) throws XelException {
		return "users".equals(name)? User.getAll():null;
	}

}
