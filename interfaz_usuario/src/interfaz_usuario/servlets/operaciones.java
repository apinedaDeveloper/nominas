package interfaz_usuario.servlets;

import interfaz_usuario.util.utils;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.ResultSet;

import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import pkg_util_base_datos.interfaz_DB;

public class operaciones extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    private String vUsuario;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String vCadena="",vPara;
        vPara=request.getParameter("codop");                      
        
        vUsuario=utils.getUsuarioSinPrefijo(request.getRemoteUser());
        
        if (vPara!=null && vPara.equals("1")){ // cambiar estado gestion
            
         vCadena=insertarDetalleAutorizacion(request.getParameter("var1"),request.getParameter("var2"),request.getParameter("var3"),request.getParameter("var4"));
         
        }
        else if (vPara!=null && vPara.equals("2")){ // consulta de firmas
        
         
        
        }
        
        out.println(vCadena);
        out.flush();
        out.close();
        
        
    }
    
    
private String insertarDetalleAutorizacion(String pIdGestion,String pIdEstado,String pIdTipoGestion,String pComentario){
    

    interfaz_DB datos;
    datos=new interfaz_DB();
    String vResultado,vErrorE;
    ArrayList vParametros;
    vParametros = new ArrayList();
    
    
    vParametros.add(vUsuario);
    vParametros.add(pIdGestion);
    vParametros.add(pIdEstado);
    vParametros.add(pIdTipoGestion);
    vParametros.add(pComentario);
    vParametros.add("SI");
    
    /*System.out.println("Parámetros enviados al Procedimiento almacenado INSERTARDETALLEAUTO");
    System.out.println("vUsuario: [" + vUsuario + "]");
    System.out.println("pIdGestion: [" + pIdGestion + "]");
    System.out.println("pIdEstado: [" + pIdEstado + "]");
    System.out.println("pIdTipoGestion: [" + pIdTipoGestion + "]");
    System.out.println("pComentario: [" + pComentario + "]");
    System.out.println("El sexto parámetro es la palabra SI");*/
    if (datos.Bol_ejecutar_procedimiento("sis_pkg_procs.INSERTARDETALLEAUTO(?,?,?,?,?,?)",vParametros)){
        
      vResultado="{\"cod\":\"OK\",\"msg\":\"Operacion ejecutada exitosamente!!\"}";        
    } else{
        
      vErrorE=datos.getError();
      System.out.println(vErrorE);
      if (vErrorE!=null && vErrorE.indexOf("<<")>0 && vErrorE.length()>2){
          
          vErrorE=vErrorE.substring(vErrorE.indexOf("<<")+2,vErrorE.length());  
      }else {
          vErrorE="Ha ocurrido un error en el traslado";
      }
       
    //  System.out.println(vErrorE);
      
      vResultado="{\"cod\":\"ERR\",\"msg\":\""+vErrorE+"\"}";          
    }
    
    datos.cn_Cerrar_coneccion();        
   return vResultado; 
}
    
}
