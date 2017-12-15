
/* Archivo: PropertyRetrieval.java
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

package gasd.zktest.purejavaexample;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/*
 * @author: gasdsba - 
 * PropertyRetrieval:  
 */
public class PropertyRetrieval extends GenericRichlet {

	/* (non-Javadoc)
	 * @see org.zkoss.zk.ui.Richlet#service(org.zkoss.zk.ui.Page)
	 */
	public void service(Page page) throws Exception {
		final Window main = new Window("Property Retrieval", "normal", false);
		main.appendChild(new Label("Enter a property name: "));

		final Textbox input = new Textbox();
		input.setId("input");
		main.appendChild(input);

		final Button button = new Button("Retrieve");
		button.addEventListener("onClick",
				new EventListener() {
			public void onEvent(Event event) throws Exception {
				Messagebox.show(System.getProperty(input.getValue()));
			}
		});
		main.appendChild(button);

		main.setPage(page); //attach so it and all descendants will be generated to the client
	}

}
