
/* Archivo: OSPropertyRetriverSelectorComposer.java
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

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

/*
* @author: gasdsba - 
* OSPropertyRetriverSelectorComposer:  
*/
public class OSPropertyRetriverSelectorComposer extends SelectorComposer<Window> {
	@Wire
  Textbox input; //wired to a component called input
  @Wire
  Vlayout result; //wired to a component called result
   
  @Listen("onClick=#retrieve")
  public void submit(Event event) { //register a listener to a component called retrieve
      String prop = System.getProperty(input.getValue());
      result.appendChild(new Label(prop));
  }
}
