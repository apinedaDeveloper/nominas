package pkg_autenticacion.menu;

import enlace_datos.consultas.QUERRYSImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.perfiles_usuario;
import interfaz_usuario.usuario;
import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;
import java.beans.IntrospectionException;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.model.MenuModel;
import oracle.jbo.ApplicationModule;

import pkg_util_base_datos.interfaz_DB;

public class MenuModelAdapter implements Serializable
{
  private           String    _propertyName = null;
  private           Object    _instance = null;
  private transient MenuModel _model = null;
  private transient MenuModel _modelBD = null;
  private           List      _aliasList = null;
  private           HashMap   vHmp_menu= new HashMap();
  private           HashMap   vHmp_menu_nombre= new HashMap();
  private           HashMap   vListadoPaginas=new HashMap();
  private boolean vValidaCuenta;
  private  Object vglIdBitacora;
  

     public ApplicationModule getApplicationModule(String pNomApplication) {  
     
            DCDataControl dc=null;
            try{
            FacesContext context = FacesContext.getCurrentInstance();  
            ValueBinding vb = context.getApplication().createValueBinding("#{data}");  
            BindingContext bc = (BindingContext) vb.getValue(context);  
            dc  = bc.findDataControl(pNomApplication);  
            }catch(Exception exep){
                exep.printStackTrace();
                return null;
            }
            
            return  (ApplicationModule)dc.getDataProvider();  
         }  

  
   /*  Metodo para la busqueda de un nodo en el menu  */
   private MenuItem Mtm_buscarPadre(long pLng_idPadre){
    MenuItem vMtm_nodo=null;
    
    if (vHmp_menu.containsKey(pLng_idPadre)) {  // Si se encuentra el identificador en la mapa obtiene el objeto
        vMtm_nodo =(MenuItem)vHmp_menu.get(pLng_idPadre);
    }

    return vMtm_nodo;
}

   private void AgregarModeloMenu(ArrayList pAryl_menuPrincipal,ArrayList pAryl_menutemp,MenuItem vItem,int vopcion){
       MenuItem vMtm_nodoMenu= null;
       MenuItem vMtm_nodoMenu_aux=null;
       Long vLng_id_Padre;
       ArrayList vAryl_menuNodo=null;
       vLng_id_Padre=vItem.getIdPadre();
   
       if (vLng_id_Padre!=0){ //Si la opcion menu tiene una opcion padre
           vMtm_nodoMenu_aux=this.Mtm_buscarPadre(vLng_id_Padre);
             if (vMtm_nodoMenu_aux!=null){ //Se encontro al padre
                 vAryl_menuNodo=(ArrayList)vMtm_nodoMenu_aux.getChildren();
                if (vAryl_menuNodo==null){ //no existe ningun hijo
                 vAryl_menuNodo=new ArrayList();
                 vAryl_menuNodo.add(vItem);
                 vMtm_nodoMenu_aux.setChildren(vAryl_menuNodo);
                } else{   // Si existen hijos
                 vAryl_menuNodo.add(vItem);   
                }
             }else{
               if (vopcion==1){
                 vItem.setIdPadre(vLng_id_Padre);  
                 pAryl_menutemp.add(vItem);     
                            }
             }
       }else{
       pAryl_menuPrincipal.add(vItem);       
       }
       
   }

/*
 * Metodo para obtener los roles del usuario
 */
   private void getRoles(){
       String pUsuarioLogueado;
       String vPerfiles;
       interfaz_DB con=null;
       pUsuarioLogueado=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login").toString();
       try {
         con=new interfaz_DB();
         Connection vCon_conexion=con.get_Coneccion();
         PreparedStatement vPst_sentencia;
         vPst_sentencia=vCon_conexion.prepareStatement("select distinct UPPER(perfil) as perfil from usuario_perfil where usuario='"+pUsuarioLogueado+"' and tipo_usuario='TRABAJADOR' and activo=1"); 
         ResultSet vRst_filas= vPst_sentencia.executeQuery();
         vPerfiles="";
         while (vRst_filas.next()){
             vPerfiles=vPerfiles+(vPerfiles.length()==0?"":", ")+vRst_filas.getString("perfil");
         }
         vRst_filas.close();
         con.cn_Cerrar_coneccion();
         usuario.set_opciones(usuario.PERFILES_USUARIO_LOGIN,vPerfiles);
       }catch(Exception exep){
           con.cn_Cerrar_coneccion();
           exep.printStackTrace();
       }
       
   }


    /*
     * Metodo para el nombre del usuario
     */
       private void getNomUsuario(){
           String pUsuarioLogueado;
           interfaz_DB con=null;
           pUsuarioLogueado=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login").toString();
           try {
             con=new interfaz_DB();
             Connection vCon_conexion=con.get_Coneccion();
             PreparedStatement vPst_sentencia;
             vPst_sentencia=vCon_conexion.prepareStatement("select nombres,apellidos from usuario where usuario='"+pUsuarioLogueado+"' and tipo_usuario='TRABAJADOR'"); 
             ResultSet vRst_filas= vPst_sentencia.executeQuery();

               if (vRst_filas.next()){
                   usuario.set_opciones(usuario.NOMUSUARIOLOGUEADO,(vRst_filas.getString("nombres")+" "+vRst_filas.getString("apellidos")).trim());
               }
             vRst_filas.close();
             con.cn_Cerrar_coneccion();
           }catch(Exception exep){
               con.cn_Cerrar_coneccion();
               exep.printStackTrace();
           }
           
       }

    /*
     * Metodo para obtener si se valida los nuevos registros tengan validada la cuenta
     */
       private void getValidarCuentaBancaria(){
           String vQuerry,vOpcion=null;
           
           interfaz_DB con=null;
           try {
             con=new interfaz_DB();
             Connection vCon_conexion=con.get_Coneccion();
             vQuerry="SELECT VALOR_NUMERICO\n" + 
             "           FROM \n" + 
             "          SIS_PARAMETROS_APLICACION\n" + 
             "          WHERE NOM_PARAMETRO='VALIDA_CUENTA_CONTRATO'";
             
             
             PreparedStatement vPst_sentencia;
             vPst_sentencia=vCon_conexion.prepareStatement(vQuerry); 
             ResultSet vRst_filas= vPst_sentencia.executeQuery();

               if (vRst_filas.next()){
                   vOpcion=vRst_filas.getString("VALOR_NUMERICO");
                   
               }
             vRst_filas.close();
             con.cn_Cerrar_coneccion();
             
             if (vOpcion!=null && vOpcion.equals("1")){
                 
                 vValidaCuenta=true;  
             }else{
                 
                 vValidaCuenta=false;   
             }
                 
               
             
           }catch(Exception exep){
               vValidaCuenta=false;   
               con.cn_Cerrar_coneccion();
               exep.printStackTrace();
           }
           
       }


    public String[] getRolesFaces(){
        ExternalContext vExContexto;   
        boolean vResultado=false;
        perfiles_usuario vTodosPerfiles=new perfiles_usuario();
        int vRoles,i=0;
        String [] vRolesUsuario;       
        ArrayList<String> otros=new ArrayList <String>();
        
        vExContexto=FacesContext.getCurrentInstance().getExternalContext();  
        vRoles= vTodosPerfiles.getPerfiles().length;
        
          //Verificando si algun  usuario pertenece a algun rol
          if (vRoles>0){
              while (i<vRoles){
                    vResultado=vExContexto.isUserInRole(vTodosPerfiles.getPerfiles()[i]); 
                    if (vResultado==true){
                       otros.add(vTodosPerfiles.getPerfiles()[i]); 
                    }
                i++;    
              }
          }
        
           vRolesUsuario=new String[otros.size()];
           vRolesUsuario=otros.toArray(vRolesUsuario);
       return vRolesUsuario;    
       }


        //Método que construye el query de los permisos que tiene un empleado
        private PreparedStatement construirQueryMenu(Connection vCon_conexion, String idLogueado) {
            PreparedStatement vPst_sentencia = null;
            String query = "select unique a.orden, a.id_opcion_menu, nvl(a.id_padre,0) as id_padre, a.nombre, a.outcome, a.pagina, b.guardar, b.actualizar, b.borrar, b.imprimir, a.paginasrel \n" + 
                " from opcion_menu a,permiso_menu b,perfil c,usuario_perfil d,usuario e \n" + 
                " where b.id_opcion_menu=a.id_opcion_menu \n" + 
                " and b.aplicacion=a.aplicacion  \n" + 
                " and b.perfil=c.perfil\n" + 
                " and c.perfil=d.perfil \n" + 
                " and e.usuario=d.usuario \n" + 
                " and a.aplicacion='SIS' \n" + 
                " and d.activo=1 and d.tipo_usuario='TRABAJADOR'  \n" + 
                " and e.tipo_usuario='TRABAJADOR' and e.activo=1\n" + 
                " and e.usuario=?\n" + 
                " and not exists(\n" + 
                " select 1 from usuario_menu_excluye usrm\n" + 
                "  where usrm.id_opcion_menu=a.id_opcion_menu\n" + 
                "  and usrm.menu_aplicacion=a.APLICACION\n" + 
                "  and usrm.usuario=e.usuario\n" + 
                "  and usrm.tipo_usuario='TRABAJADOR' \n" + 
                "  and usrm.ESTADO='1' )\n" + 
                " order by nvl(id_padre,0),a.orden asc";
            //System.out.println("El query para obtener las opciones del menú es: " + sentencia);
            try {
                vPst_sentencia= vCon_conexion.prepareStatement(query);
                vPst_sentencia.setString(1,idLogueado);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return vPst_sentencia;
        }
        
        //Método que construye un query de los permisos que tiene el perfil estudiante_usac.
        private PreparedStatement construirQueryMenuTrabajadorUsac(Connection vCon_conexion, String idLogueado) {
            PreparedStatement vPst_sentencia = null;
            String query = "select unique a.orden, a.id_opcion_menu, nvl(a.id_padre,0) as id_padre, a.nombre, a.outcome, a.pagina, b.guardar, b.actualizar, b.borrar, b.imprimir, a.paginasrel \n" + 
                " from opcion_menu a,permiso_menu b,perfil c,usuario_perfil d,usuario e \n" + 
                " where b.id_opcion_menu=a.id_opcion_menu \n" + 
                " and b.aplicacion=a.aplicacion  \n" + 
                " and b.perfil=c.perfil\n" + 
                " and c.perfil=d.perfil \n" + 
                " and e.usuario=d.usuario \n" + 
                " and a.aplicacion='SIS' \n" + 
                " and d.activo=1 and d.tipo_usuario='TRABAJADOR'  \n" + 
                " and e.tipo_usuario='TRABAJADOR' and e.activo=1\n" + 
                " and e.usuario=? and d.PERFIL = 'trabajador_usac'\n" + 
                " and not exists(\n" + 
                " select 1 from usuario_menu_excluye usrm\n" + 
                "  where usrm.id_opcion_menu=a.id_opcion_menu\n" + 
                "  and usrm.menu_aplicacion=a.APLICACION\n" + 
                "  and usrm.usuario=e.usuario\n" + 
                "  and usrm.tipo_usuario='TRABAJADOR' \n" + 
                "  and usrm.ESTADO='1' )\n" + 
                " order by nvl(id_padre,0),a.orden asc";
            try {
                vPst_sentencia= vCon_conexion.prepareStatement(query);
                vPst_sentencia.setString(1,idLogueado);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return vPst_sentencia;
        }
        
        //Método que verifica si un empleado se encuentra en la tabla usuario_modulo_siif
        private boolean verificarUsuarioModuloSIIF(interfaz_DB vCone, String idLogueado){
           String sqlString;
           ResultSet vFilas;
           boolean verTodasLasOpciones = false; //Si se queda en false, el usuario verá únicamente las opciones de trabajador_usac
           sqlString="select distinct acceso from usuario_modulo_siif where aplicacion in ('SIS') \n" + 
               "and modulo is null and tipo_usuario='TRABAJADOR' and usuario='" + idLogueado + "'";
           //System.out.println("El query para verificar acceso a la aplicación es: " + sqlString);
           try {
               vFilas = vCone.Bol_ejecutar_sentencia(sqlString);
               if (vFilas !=null && vFilas.next()) { //No hubo error y hay filas
                   if (vFilas.getString(1).equals("1")) {
                        //El usuario visualizará todas las opciones de sus perfiles
                        verTodasLasOpciones = true;
                   } 
               } 
           } catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
           }
           return verTodasLasOpciones;
        }
        
        //Método que consulta la Base de Datos y construye el menú
        private void construirMenu(ArrayList vAryl_menuPrincipal){
            interfaz_DB con=null;
            String idLogueado = "", vPaginasRel = "";
            MenuItem vMtm_nodoMenu = null;
            ArrayList vAryl_menutemp=new ArrayList();
            String []vPaginasTemp;
            int vIndice;
            try {
                con=new interfaz_DB();
                Connection vCon_conexion=con.get_Coneccion();
                PreparedStatement vPst_sentencia;
                idLogueado=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login").toString();
                if ( verificarUsuarioModuloSIIF(con, idLogueado) ) {
                    vPst_sentencia = construirQueryMenu(vCon_conexion, idLogueado);
                } else {
                    vPst_sentencia = construirQueryMenuTrabajadorUsac(vCon_conexion, idLogueado);
                }
                ResultSet vRst_filas = vPst_sentencia.executeQuery();
                while (vRst_filas.next()){
                    vMtm_nodoMenu= new MenuItem();
                    vMtm_nodoMenu.setLabel(vRst_filas.getString("nombre"));
                    vMtm_nodoMenu.setOutcome(vRst_filas.getString("outcome"));
                    vMtm_nodoMenu.setViewId(vRst_filas.getString("pagina"));
                    vMtm_nodoMenu.setPaginasRel(vRst_filas.getString("paginasrel"));
                    vMtm_nodoMenu.setIdPadre(vRst_filas.getLong("id_padre"));
                    vPaginasRel=vRst_filas.getString("paginasrel");
                    this.AgregarModeloMenu(vAryl_menuPrincipal,vAryl_menutemp,vMtm_nodoMenu,1);    
                    // Agregamos a la tabla Hash para realizar las busquedas de los nodos   
                    vHmp_menu.put(vRst_filas.getLong("id_opcion_menu"),vMtm_nodoMenu);            
                    vHmp_menu_nombre.put(vRst_filas.getString("nombre"),vMtm_nodoMenu);
                    vListadoPaginas.put(vRst_filas.getString("pagina"),vRst_filas.getString("id_opcion_menu"));
                    if (vPaginasRel!=null) {
                        vPaginasTemp=vPaginasRel.split("\\|");
                        for (int i=0;i<vPaginasTemp.length;i++){
                            vListadoPaginas.put(vPaginasTemp[i],vRst_filas.getString("id_opcion_menu"));   
                        }
                    }
                }
                vRst_filas.close(); 
                vIndice=0;
                if (vAryl_menutemp.size()>0){
                    while (vIndice<vAryl_menutemp.size()){
                    vMtm_nodoMenu=(MenuItem)vAryl_menutemp.get(vIndice);    
                    this.AgregarModeloMenu(vAryl_menuPrincipal,vAryl_menutemp,vMtm_nodoMenu,2); 
                    vIndice++;
                }
                vAryl_menutemp.removeAll(vAryl_menutemp);
              }
            } catch (Exception vExpt_error) {
                System.out.println(vExpt_error.getMessage());
                vExpt_error.printStackTrace();  
            } finally {
                con.cn_Cerrar_coneccion();
            }
        }
        
        //Método que construye un árbol en memoria ram para el menú de opciones
        private void construirArbolMenu(ArrayList vAryl_menuPrincipal){
            MaxLevelChildPropertyTreeModel vMltr_arbol=new MaxLevelChildPropertyTreeModel(vAryl_menuPrincipal,"children",15);
            MaxLevelViewIdPropertyMenuModel model;
            try {
                model = new MaxLevelViewIdPropertyMenuModel(vMltr_arbol, getViewIdProperty());
                if(model!=null && _aliasList != null && !_aliasList.isEmpty()) {
                  int size = _aliasList.size();
                  if (size % 2 == 1)
                    size = size - 1;
                    
                  for ( int i = 0; i < size; i=i+2)
                  {
                    model.addViewId(_aliasList.get(i).toString(),
                                   _aliasList.get(i+1).toString());
                  }
                }
                _modelBD = model;
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
        }
        
        //Método que cambia el estatus de los Items de Inicio y Mantenimiento
        private void cambiarStatusItems(){
            MenuItem vOpcionMenu;
            vHmp_menu=null;  
            try{       
                vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("Empleado");
                CambiarEstadoItem(vOpcionMenu,null,true,false);   
                vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("ISR");
                CambiarEstadoItem(vOpcionMenu,null,true,true);   
                vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("Historial salarial");
                CambiarEstadoItem(vOpcionMenu,null,true,true);   
                vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("Declaración jurada de cargos");
                CambiarEstadoItem(vOpcionMenu,null,true,true);  
                vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("Cambio de Cuenta");
                CambiarEstadoItem(vOpcionMenu,null,true,true);   
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        //Método que obtiene el número de ID de la bitácora y lo asgina a la aplicación actual
        private void obtenerIDBitacoraAcceso(Object vQuerryS, QUERRYSImpl pApplication){
            if (vglIdBitacora==null){
                if (vQuerryS==null)
                    vQuerryS=this.getApplicationModule("QUERRYSDataControl");
                if (vQuerryS!=null){
                    pApplication=(QUERRYSImpl)vQuerryS;
                vglIdBitacora = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idBitacora");
                if (vglIdBitacora!=null)
                    pApplication.setIdBitacora(vglIdBitacora.toString());
                }
            }
        }
        
        //Método que verifica el estatus de la confrontación y cambia status items
        private void verificarConfrontacion() {
            MenuItem vOpcionMenu;
            String vConfronta;
            vConfronta=(String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.actualizaDatosConfronta}");
            if (vConfronta.equals("1")){  // aplica para las opciones del trabajador
                try{
                    vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("ISR");
                    CambiarEstadoItem(vOpcionMenu,null,false,true);   
                    vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("Historial salarial");
                    CambiarEstadoItem(vOpcionMenu,null,false,true); 
                    vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("Declaración jurada de cargos");
                    CambiarEstadoItem(vOpcionMenu,null,false,true);   
                    vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get("Cambio de Cuenta");
                    CambiarEstadoItem(vOpcionMenu,null,false,true); 
                }   catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        /* Metodo para crear el menu a partir de los datos BD  */
        public MenuModel getModeloBD() throws IntrospectionException {
            Object vQuerryS = null;
            ArrayList vAryl_menuPrincipal= new ArrayList();
            QUERRYSImpl pApplication;
            if (_modelBD == null){
                vQuerryS=this.getApplicationModule("QUERRYSDataControl");
                if (vQuerryS!=null){
                    pApplication=(QUERRYSImpl)vQuerryS;
                    pApplication.setRolesUsuario(getRolesFaces());
                    vglIdBitacora = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idBitacora");
                    if (vglIdBitacora!=null)
                        pApplication.setIdBitacora(vglIdBitacora.toString());
                    getRoles();  ///Obteniendo los roles
                    getNomUsuario(); // Obteniendo el nombre del usuario
                    getValidarCuentaBancaria();// parametro que indica si se valida el nuevo de cuenta
                    construirMenu(vAryl_menuPrincipal); // consulta la Base de Datos y construye el menú
                    construirArbolMenu(vAryl_menuPrincipal); // construye un árbol en memoria ram para el menú de opciones
                    cambiarStatusItems(); // cambia el estatus de los Items de Inicio y Mantenimiento
                    obtenerIDBitacoraAcceso(vQuerryS, pApplication); // obtiene el número de ID de la bitácora y lo asgina a la aplicación actual
                    verificarConfrontacion(); // verifica el estatus de la confrontación y cambia status items
                }
            } 
            return _modelBD;
         }

 /*  Metodo para obtener el arbol del menu a partir de las definiciones del faces-config   */    
  public MenuModel getModel() throws IntrospectionException
  {
    if (_model == null)
    {
      MaxLevelViewIdPropertyMenuModel model = 
                             new MaxLevelViewIdPropertyMenuModel(getInstance(),
                                                         getViewIdProperty());
                                                         
      if(_aliasList != null && !_aliasList.isEmpty())    
      {
        int size = _aliasList.size();
        if (size % 2 == 1)
          size = size - 1;
          
        for ( int i = 0; i < size; i=i+2)
        {
          model.addViewId(_aliasList.get(i).toString(),
                         _aliasList.get(i+1).toString());
                         
                         //model.
        }
      }
      
      _model = model;
    }
    return _model;
  }

  public String getViewIdProperty()
  {
    return _propertyName;
  }

  /**
   * Sets the property to use to get at view id
   * @param propertyName
   */
  public void setViewIdProperty(String propertyName)
  {
  //  System.out.println("view property");
    _propertyName = propertyName;
    _model = null;
  }

  public Object getInstance()
  {
    return _instance;
  }

  /**
   * Sets the treeModel
   * @param instance must be something that can be converted into a TreeModel
   */
  public void setInstance(Object instance)
  {
    _instance = instance;
    _model = null;
  }
  

  public List getAliasList()
  {
    return _aliasList;
  }

  public void setAliasList(List aliasList)
  {
    _aliasList = aliasList;
  }



    public void action_menu2(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void listener_menu(ActionEvent actionEvent) {
         CoreCommandMenuItem vMenuItem;
         vMenuItem=(CoreCommandMenuItem)actionEvent.getComponent();
         Object vRegEmpleadoSel,vEstadoEmpleado;
         MenuItem vOpcionMenu;
         oracle.jbo.domain.Number vRegActual;
         if (vMenuItem.getText().equals("Licencias")){ 
             usuario.set_opciones(usuario.CURRENTSOLICITUD,"LICENCIA");
             usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Licencias");
         } 
         else if (vMenuItem.getText().equals("Baja Suspencion Laboral")){ 
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"BAJA SUPENCION LABORAL");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Baja Suspencion Labora");
            usuario.set_opciones(usuario.VISTA_SUSP_LAB,0);
        }
        else if (vMenuItem.getText().equals("Suspensiones Igss")){ 
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"SUSPENSION IGSS");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Suspensiones Igss");
            usuario.set_opciones(usuario.VISTA_SUSP_IGSS,0);
        }//Esto lo esta utilizando Rolando Anona
        else if (vMenuItem.getText().equals("Retiro Obligatorio")){ 
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"RETIRO OBLIGATORIO");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Retiro Obligatorio");
            usuario.set_opciones(usuario.VISTA_RETIRO,0);
        }//Esto lo esta utilizando Rolando Anona
        else if (vMenuItem.getText().equals("Rescisión Contrato")){ 
                usuario.set_opciones(usuario.CURRENTSOLICITUD,"RESCISION DE CONTRATOS");
                usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Rescision de Contrato");
                usuario.set_opciones(usuario.VISTA_RESCISION,0);
        }
        // Fallecimiento
        else if (vMenuItem.getText().equals("Fallecimiento")){ 
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"FALLECIMIENTO");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Fallecimiento");
            usuario.set_opciones(usuario.VISTA_FALLECIMIENTO,0);
        }
        else if (vMenuItem.getText().equals("Alta suspension Igss")){ 
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"ALTA SUSPENSION IGSS");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Suspensiones Igss");
            usuario.set_opciones(usuario.VISTA_SUSP_IGSS,0);
        }else if (vMenuItem.getText().equals("Descuentos Judiciales")){
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"DESCUENTO JUDICIAL");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
            usuario.set_opciones(usuario.VISTA_ORDEN_JUDICIAL,0);
        }
        else if (vMenuItem.getText().equals("Contrataciones")){
        
            Object vRegistroEmpleado;
            vRegistroEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado}");
            
            
            if (isAllowContract(vRegistroEmpleado.toString())){
                                
                 usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0)); 
                 usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
                
            }else{               
             
               try{                   
                   JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.showMensajeCuenta",true);
                  // FacesContext.getCurrentInstance().getExternalContext().redirect("/nomina_usac/faces/gestiones/list_empleado.jspx");    
                 //  utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"El trabajador no ha validado su cuenta monetaria para acreditamiento de su salario.\n El trabajador debe realizar la gestion en la Actualziacion de datos."));                   
               }catch(Exception exep){
                   exep.printStackTrace();
               }
               
               // 
            }

        
            
            
            
        }else if (vMenuItem.getText().equals("Nuevo Aumento")){
            usuario.set_opciones(usuario.VISTA_PROC_AUMENTO_SAL,0);
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
        }else if (vMenuItem.getText().equals("Renuncias")){
           
           usuario.set_opciones(usuario.CURRENTSOLICITUD,"RENUNCIA");
           usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
           usuario.set_opciones(usuario.VISTA_RENUNCIA_PARCIAL,0);
            
       }else if (vMenuItem.getText().equals("Despidos")){
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"DESPIDO");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
       }else if(vMenuItem.getText().equals("Decisión de Autoridades")){
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"DECISION DE AUTORIDADES");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
       }       
       else if (vMenuItem.getText().equals("Descuentos")){
           usuario.set_opciones(usuario.CURRENTSOLICITUD,"NINGUNO");
           usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
       }else if (vMenuItem.getText().equals("Cargos a deudores")){
           usuario.set_opciones(usuario.CURRENTSOLICITUD,"DEUDORES");
           usuario.set_opciones(usuario.VISTA_SOLICITUD,0);
           usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
       }else if (vMenuItem.getText().equals("Anexo A")){
               usuario.set_opciones(usuario.VISTA_OPERACION,0);
               //usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
             //  System.out.println("valor de operacion" );
           }
           else if (vMenuItem.getText().equals("Anexo Promoción")){
               usuario.set_opciones(usuario.VISTA_OPERACION,0);               
               //System.out.println("estoy en el menu promocion");
               //usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
              // System.out.println("valor de operacion" );
           }else if (vMenuItem.getText().equals("Tiempo extraordinario")){
               usuario.set_opciones(usuario.VISTA_OPERACION,0);
               //usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
             //  System.out.println("valor de operacion" );
           }else if (vMenuItem.getText().equals("Datos personales")){
               usuario.set_opciones(usuario.VISTA_FICHAEMPLEADO,0);
           }else if (vMenuItem.getText().equals("Empleado")){// se buscara un empleado para alguna gestion
               usuario.set_opciones(usuario.VISTA_OPERACION,0);               
               //System.out.println("estoy en el menu promocion");
               //usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
              // System.out.println("valor de operacion" );
           }else if (vMenuItem.getText().equals("Analisis Nomina")){
               usuario.set_opciones(usuario.VISTA_OPERACION,1);  //un jeque buscara un empleado             
               //System.out.println("estoy en el menu promocion");
               //usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
              // System.out.println("valor de operacion" );
           }
            else if (vMenuItem.getText().equals("Liquidacion de Nomina")){
              JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.vistaLiquidacion",0);
              
             }
        
           
        else{
            usuario.set_opciones(usuario.VISTA_PROC_AUMENTO_SAL,1);
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"NINGUNO");
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"NO");
        }
        
        vRegEmpleadoSel=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado}");
        
        if (vRegEmpleadoSel==null || vRegEmpleadoSel.equals(0)){
     //   System.out.println("no hay usuario sel");    
            if (vMenuItem.getText().equals("Empleado")){ 
              //  usuario.set_opciones(usuario.CURRENTSOLICITUD,"LICENCIA");
               // usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Licencias");
                vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get(vMenuItem.getText());
                CambiarEstadoItem(vOpcionMenu,null,true,false);
            }
        }else{
            if (vMenuItem.getText().equals("Empleado")){ 
                vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get(vMenuItem.getText());
                
                vRegActual=utils.getNumberOracle(vRegEmpleadoSel);
                if (vRegActual.compareTo(90000000)>=0){
                    CambiarEstadoItem(vOpcionMenu,null,true,false);    
                }else{
                
                    vEstadoEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.estadoEmpleado}");

                    if (vEstadoEmpleado!=null && vEstadoEmpleado.toString().equals("DESHABILITADO")){
                        
                        CambiarEstadoItem(vOpcionMenu,null,true,false);  
                        
                    }else {
                        
                        CambiarEstadoItem(vOpcionMenu,null,false,false);        
                    }
                    
                    
                    
                    
                }
                
            
        }
     }
}
    
public void cambiarEstadoItem(String pNombrePadre,boolean vEstado){
    MenuItem vItemPadre;
    vItemPadre=pNombrePadre.equals("029") ? buscarItem("Empleado") : buscarItem(pNombrePadre);
    
    if (vItemPadre!=null){
        if (pNombrePadre.equals("029"))
            CambiarEstadoItem029(vItemPadre,null,vEstado,false);
        else
            CambiarEstadoItem(vItemPadre,null,vEstado,false);
    }
    
}
    
public MenuItem buscarItem(String vNombre){
    
    MenuItem vOpcionMenu;
    try{
    vOpcionMenu=(MenuItem)this.vHmp_menu_nombre.get(vNombre);
    }catch(Exception exep){
        
        vOpcionMenu=null;
        
    }
    return vOpcionMenu;
}
    
 /*
  *  Metodo para cambiar el estado del item
  */
 public void CambiarEstadoItem(MenuItem vItemPadre,String vExcepciones[],boolean vValor, boolean cambiarPadre){
     //_modelBD.getv
     ArrayList vLista;
     int vTamanio;
     MenuItem vItem;
     
     if (vItemPadre!=null)
     {
        if (cambiarPadre==true){
            vItemPadre.setReadOnly(vValor);
        }
        
        vLista=(ArrayList)vItemPadre.getChildren();
        if (vLista!=null)
        {
       
        vTamanio=vLista.size();
     
              
         for (int i=0;i<vTamanio;i++)
         {
           vItem=(MenuItem)vLista.get(i);
             if (vItem.getChildren()!=null){
                 CambiarEstadoItem(vItem,vExcepciones,vValor,true);
                 
             }else{
                 vItem.setReadOnly(vValor);
             }
         }
        
        }
    }
              
 }
 
    /*
     *  Metodo para cambiar el estado del 
     */
    public void CambiarEstadoItem029(MenuItem vItemPadre,String vExcepciones[],boolean vValor, boolean cambiarPadre){
        //_modelBD.getv
        ArrayList vLista;
        int vTamanio;
        MenuItem vItem;
        
        if (vItemPadre!=null)
        {
           if (cambiarPadre==true){
               vItemPadre.setReadOnly(vValor);
           }
           
           vLista=(ArrayList)vItemPadre.getChildren();
           if (vLista!=null)
           {
          
           vTamanio=vLista.size();
        
                 
            for (int i=0;i<vTamanio;i++)
            {
              vItem=(MenuItem)vLista.get(i);
              String label = vItem.getLabel();
              
              if(label.equals("Contratos 029")){
                    vItem.setReadOnly(vValor);
                    break;
              }
            
            }
           
           }
       }
                 
    }
    
 /*
  * Metodo para validar si es permitido crear un contrato para un nuevo registro
  */
public boolean isAllowContract(String pRegistroEmpleado){
    String vQuerry;
    String vNuevo=null;
    String vCheckCuenta=null;
    boolean vResultado=true;
    
    try {
    
    if (vValidaCuenta==true)
    {
      interfaz_DB con=new interfaz_DB();
      Connection vCon_conexion=con.get_Coneccion();
      vQuerry="select \n" + 
      "          datos.*,\n" + 
      "          case when "+pRegistroEmpleado+">=20110001 then 1 else 0 end as nuevo\n" + 
      "          from \n" + 
      "          (\n" + 
      "          select          \n" + 
      "          count(0) as cuentaOK             \n" + 
      "          from\n" + 
      "          sis_ficha_empleado\n" + 
      "          where statuscuenta=1\n" + 
      "          and registro_empleado=" +pRegistroEmpleado+"\n" + 
      "          )datos";
      
      
      PreparedStatement vPst_sentencia;
      vPst_sentencia=vCon_conexion.prepareStatement(vQuerry); 
      ResultSet vRst_filas= vPst_sentencia.executeQuery();

        if (vRst_filas.next()){
            vCheckCuenta=vRst_filas.getString("cuentaOK");
            vNuevo=vRst_filas.getString("nuevo");
        }
      vRst_filas.close();
      con.cn_Cerrar_coneccion();
      
      if (vNuevo.equals("1"))  // es un nuevo registro
      {
         if (vCheckCuenta.equals("0")){ // si no esta validada la cuenta no permite crear el contrato
             
             vResultado=false;
         }
          
      }
     
    }else{
        
        vResultado=true;
    }
   }catch(Exception exep){
        exep.printStackTrace();
   }    
    
    
return vResultado;    
}
 

public HashMap getListadoPagina(){
    return vListadoPaginas;
}


    public String mnu_msg_redactanuevo() {
        // Add event code here...
        JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.replyMensaje","0");
        return null;
    }

    public void mnu_msg_redactat_listener(ActionEvent actionEvent) {
        // Add event code here...
         JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.replyMensaje","0");
         JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.asunto","");
         JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.destinatario","");
    }
}
