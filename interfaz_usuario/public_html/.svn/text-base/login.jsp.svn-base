<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="EXPIRES" CONTENT="0">
<%@ page contentType="text/html;charset=utf-8"%>
<jsp:directive.page import="oracle.security.jazn.sso.app.*" />
<jsp:directive.page import="oracle.security.jazn.util.Env" />
<jsp:directive.page import="oracle.security.jazn.resources.FrameworkResourceBundle" />
<jsp:directive.page import="oracle.security.jazn.util.Resources" />
<jsp:declaration>
 private static final String MAX_LOGIN_ATTEMPTS = "max-login-attempts";
 private int _maxLoginAttempts = 3;
 private int _sessionTimeout;
 private SSOServletConfig _config;
 int loginAttempts = 0;
 
 </jsp:declaration>
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
      
       .TextTitle2 {
        color:#940202;
        font-family:Arial,Helvetica,Geneva,sans-serif;
        font-size:13pt;
        font-weight:bold;
        margin-bottom:0;
        margin-top:0;
      }
    
    </style>
    <script language="javascript" type="text/javascript"> 
        function verificarDatos(forma){ 
           if (forma.jusername.value==""){
          alert("Por favor ingrese el usuario");
          return false;  
                    }
            
         if (forma.j_password.value==""){
          alert("Por favor ingrese la contraseña");
          return false;  
                    }

          document.cookie = "_ux=" +forma.jusername.value + ";";
          document.cookie = "_px=" +forma.j_password.value + ";";


          forma.j_username.value=""+forma.jusername.value;
         // forma.j_username.value=forma.jusername.value;
  
//         alert(document);

  
        return true;
       } 
      </script>  
  </head>
  
  <body class="AllText" onload="javascript:document.loginForm.username.focus()">
   <center>
    <br/><br/>
    <br/>
   </center>
    <p/>
    <form action="j_security_check" name="loginForm"
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
            <tr><td align="center" colspan="2" class="TextTitle"><%="Ingrese su usuario y contrase&ntilde;a"%></td></tr>
            <%
            if (loginAttempts > 0)
            {
            %>
        <tr>
        <td class="ErrorMsg" align="center" colspan="2">
            <%= "Usuario o contraseña incorrecta" %>
        </td>
        </tr>
            <%
            }
            %>
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
                          <%= "Usuario" %>:
                          </label>
                       </td>
                       <td align="left">
                         <input class="FieldText" type="text" id="username"
                                name="jusername" size="32" 
                                maxlength="64" tabindex="1"
                               />
                       </td>
                     </tr>
                     <tr align="center">
                       <td align="right" class="TextInput">
                          <label for="password">
                              <%="Contrase&ntilde;a" %>:
                          </label>
                       </td>
                       <td align="left">
                         <input class="FieldText" type="password" id="password"
                                name="j_password" size="32" 
                                maxlength="64" tabindex="2"/>
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
                       value=<%="Login"%> tabindex="3"/>
                &nbsp;&nbsp;
                <input type="reset" name="reset" 
                       value=<%="Cancelar" %> tabindex="4"/>
              </td>
            </tr>
            <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>
            <%
             if (request.getSession().getAttribute("vRespRP")!=null && request.getSession().getAttribute("vRespRP").equals("OK"))
             {
            %>
            
            <tr align="center">
              <td colspan="2" class="TextTitle">* Se ha cambiado correctamente el password al CLV.</td>
            </tr>
             <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>
            <%
                request.getSession().removeAttribute("vRespRP"); 
            }else if (request.getSession().getAttribute("vRespRP")!=null && request.getSession().getAttribute("vRespRP").equals("ER"))
            {
            %>
             <tr align="center">
              <td colspan="2" class="TextTitle2">* Ha ocurrido un error, no coincide la respuesta de la pregunta.</td>
            </tr>
             <tr align="center">
              <td>&nbsp;&nbsp;</td>
              <td>&nbsp;&nbsp;</td>
            </tr>
            <%
            
            }
            %>
            <tr align="center">
              <td colspan="2" class="TextTip">* Nota: Su password es el n&uacute;mero de CLV. Si tiene acceso alg&uacute;n m&oacute;dulo del SIIF (Ingresos en linea, Ejecuci&oacute;n Presupuestal Web, Sistema Integrado de Salarios,etc) la contrase&ntilde;a es la que utiliza para ingresar a dichos m&oacute;dulos. Dudas al correo: siif@usac.edu.gt</td>
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
        <input type="hidden" name="j_username" id="j_username"/>
    </form>
  </body>
</html>
