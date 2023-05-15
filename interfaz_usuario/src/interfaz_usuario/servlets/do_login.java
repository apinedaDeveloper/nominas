package interfaz_usuario.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import pkg_util_base_datos.interfaz_DB;

public class do_login extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

   public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
       
   }

    public void doPost(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {
                      
        response.setContentType(CONTENT_TYPE);
        interfaz_DB conexion = new interfaz_DB();
        ArrayList vLista= new ArrayList();
        Object vConsulta;
        String vRepuesta,vValResp;
        
        if (request.getSession().getAttribute("pUsuario")!=null)
        {
          vValResp=(request.getSession().getAttribute("pValResp")!=null?request.getSession().getAttribute("pValResp").toString():"");
        
          if (vValResp.equals("1")){ //validar respuesta
              
              vRepuesta=request.getParameter("resp");
              conexion.Crear_sentencia("select count(0) as ok from usuario\n" + 
                                    "            where tipo_usuario='TRABAJADOR'\n" + 
                                    "            and resp_seguridad =? and usuario=?");  
                                    
              conexion.setParametrosSentencia(1,"String",request.getParameter("resp"));
              conexion.setParametrosSentencia(2,"String",request.getSession().getAttribute("pUsuario"));
              vConsulta=conexion.getValorConsulta("ok");
               
               if (vConsulta.toString().equals("1")){
                   
                   vLista.add(request.getSession().getAttribute("pUsuario"));
                   conexion.Bol_ejecutar_procedimiento("sis_pkg_procs.RESETEARPASSWORD(?)",vLista);
                   conexion.commit();
                   conexion.cn_Cerrar_coneccion();
                   request.getSession().removeAttribute("pUsuario");         
                   request.getSession().setAttribute("vRespRP","OK");         
                   
               }else{
                   
                   request.getSession().removeAttribute("pUsuario");         
                   request.getSession().setAttribute("vRespRP","ER");  
                   
               }
                  
              
          }else if (vValResp.equals("0")){ // sin validar respuesta
              
               vLista.add(request.getSession().getAttribute("pUsuario"));
               conexion.Bol_ejecutar_procedimiento("sis_pkg_procs.RESETEARPASSWORD(?)",vLista);
               conexion.commit();
               conexion.cn_Cerrar_coneccion();
               request.getSession().removeAttribute("pUsuario");         
               request.getSession().setAttribute("vRespRP","OK");           
                                
          }

        }
      
        response.sendRedirect(request.getSession().getServletContext().getInitParameter("PaginaInicio"));
    }

    
}
