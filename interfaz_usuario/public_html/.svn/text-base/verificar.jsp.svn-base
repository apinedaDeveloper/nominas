<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<jsp:directive.page import="pkg_util_base_datos.interfaz_DB" />
<jsp:scriptlet>

  interfaz_DB conexion = new interfaz_DB();
  String vUsuario="";
  Object vConsulta=null;
  
   if (request.getSession().getAttribute("pUsuario")!=null)
   {  
   
    conexion.Crear_sentencia("select initcap(nvl(preg_seguridad,preg.pregunta)) as pregunta from usuario b left outer join pregunta_seguridad preg  on (preg.id_pregunta_seguridad=b.id_pregunta) where usuario=? and tipo_usuario='TRABAJADOR'");    
    conexion.setParametrosSentencia(1,"String",request.getSession().getAttribute("pUsuario"));
    vConsulta=conexion.getValorConsulta("pregunta");
    conexion.cn_Cerrar_coneccion(); 
    
    if (vConsulta!=null  && !vConsulta.toString().equals("")){
      request.getSession().setAttribute("pValResp","1");
    }else{

      request.getSession().setAttribute("pValResp","0");
      response.sendRedirect(request.getSession().getServletContext().getInitParameter("PaginaResetPass"));
      
    }
   
   }else{
   
      response.sendRedirect(request.getSession().getServletContext().getInitParameter("PaginaInicio"));
   
   }
</jsp:scriptlet>

<html lang="es"   >
  <head>
    <title><%="Login" %></title>
    <style type="text/css">
      .TableStyle { 
         background-color: #F7F7E7;
         border-color: #D2D8B0;
         border-width: 1px;
         border-style: solid;
      }
      .AllText {
         font-family: Arial, Helvetica, Geneva, sans-serif times;
         font-size: 10pt;
      }
      .Form {
         background-color: #ffffff; 
         border-color: #C3D9FF;
         border-width: 1px;
      }
      .ErrorMsg { 
         font-family: Arial, Helvetica, Geneva, sans-serif; 
         font-size: 10pt;
         color: #ff0000;
      }
      .FieldText { font-family: Arial, Helvetica, Geneva, sans-serif; }
      .Title { 
         color: #336699; 
         font-family: Arial, Helvetica, Geneva, sans-serif times;
         font-size: 20pt;
      }
      .TextTitle {
        color:#336699;
        font-family:Arial,Helvetica,Geneva,sans-serif;
        font-size:13pt;
        font-weight:bold;
        margin-bottom:0;
        margin-top:0;
      }
      
      .TextTip {
        color:#c97436;
        font-family:Arial,Helvetica,Geneva,sans-serif;
        font-size:10pt;
        font-weight:bold;
        margin-bottom:0;
        margin-top:0;
      }

      .TextTip2 {
        color:#c97436;
        font-family:Arial,Helvetica,Geneva,sans-serif;
        font-size:10pt;
        font-weight:bold;
        margin-bottom:0;
        margin-top:0;
      }
      
      .TextInput {
        color:#336699;
        font-family:Arial,Helvetica,Geneva,sans-serif;
        font-size:10pt;
        font-weight:bold;
        margin-bottom:0;
        margin-top:0;
      }  
    </style>
    <script language="javascript" type="text/javascript"> 
        function verificarDatos(forma){ 
           if (forma.resp.value==""){
          alert("Por favor ingrese la respuesta");
          return false;  
                    }
            
        return true;
         } 
         
         function cancelar(){
         
          window.location="faces/inicio.jspx";
          return true;
         }
      </script>
      
  </head>  
  <body class="AllText" onload="javascript:document.loginForm.resp.focus()">
   <center>
    <br/><br/>
    <br/>
   </center>
    <p/>
    <form action="rstpss" name="loginForm"
          autocomplete="Off" 
          method="post" onsubmit="return verificarDatos(this)">
      <table cellspacing="0" cellpadding="0"
               border="0" align="center" width="50%">
      <tr align="center">
      <td>
      <img alt="Escudo USAC" src="/Nomina/imagenes/bannerprincipal.jpg" />
      </td>
      </tr>
      </table>
       <table cellspacing="0" cellpadding="0" class="TableStyle"
               border="0" align="center" width="640">
          <tbody>
            <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>
            <tr><td align="center" colspan="2" class="TextTitle">
            <%=vConsulta%></td></tr>
            <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>
            <tr align="center">
               <td colspan="2">
                  <table>
                     <tr align="center">
                       <td align="right" class="TextInput">
                          <label for="username">
                          <%= "Respuesta" %>:
                          </label>
                       </td>
                       <td align="left">
                         <input class="FieldText" type="text" id="resp"
                                name="resp" size="32" 
                                maxlength="64" tabindex="1"
                               />
                       </td>
                     </tr>
                  </table>
               </td>
            </tr>
            <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>
            <tr align="center">
              <td colspan="2" align="center">
                <input type="submit" name="submit" 
                       value=<%="Enviar"%> tabindex="3"/>
                &nbsp;&nbsp;
                <input type="button" name="reset" 
                       value=<%="Cancelar" %> tabindex="4" onclick="cancelar();"/>
              </td>
            </tr>
            <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>            
            <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>
            <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>

         </tbody>
        </table>
        <input type="hidden" name="j_character_encoding" value="utf-8" />
    </form>
  </body>
</html>