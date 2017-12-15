
/* Archivo: OSPropertyRetriver.java
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

package gasd.zktest.mvcexample;

/*
 * @author: gasdsba - 
 * OSPropertyRetriver:  
 */
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class OSPropertyRetriever implements Composer {

	public void doAfterCompose(final Component target) { //handle UI here
		target.addEventListener("onClick", new EventListener() { //add a event listener in Java
			public void onEvent(Event event) {
				String prop = System.getProperty(((Textbox)target.query("#input")).getValue());
				target.query("#result").appendChild(new Label(prop));
			}
		});
	}
}