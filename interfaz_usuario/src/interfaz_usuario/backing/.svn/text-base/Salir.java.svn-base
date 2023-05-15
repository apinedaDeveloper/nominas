package interfaz_usuario.backing;

import java.io.IOException;

import javax.faces.component.html.HtmlForm;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.view.faces.event.DisclosureEvent;

public class Salir {

    public Salir(){
                  
    }


    public String DoSalir() throws IOException{
        HttpServletResponse response=null;
        try{
           ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
           response = (HttpServletResponse)ectx.getResponse();
           HttpSession session = (HttpSession)ectx.getSession(false);
           session.invalidate();
           System.out.println("ya sali");
           response.sendRedirect("/nomina_usac/faces/inicio.jspx");
        }catch(Exception exep) {
            exep.printStackTrace();
            try{
            response.sendRedirect("/nomina_usac/faces/inicio.jspxp");
            
            }catch(Exception exep2){
                exep2.printStackTrace();
            }
        }        
        return null;
 }
}
