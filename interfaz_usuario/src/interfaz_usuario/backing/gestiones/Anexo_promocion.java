package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.anexo.consul_plazaXempleado_vwImpl;

import enlace_datos.consultas.gestiones.anexo.consul_plazaXempleado_vwRowImpl;
import enlace_datos.consultas.gestiones.anexo.sis_movimiento_plazaRowImpl;
import enlace_datos.consultas.gestiones.contrato.sis_contrato_busq2RowImpl;

import enlace_datos.consultas.gestiones.contrato.unidades_ejecRowImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreTable;

import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.adf.view.faces.component.core.layout.CorePanelGroup;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.adf.view.faces.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.NameValuePairs;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class Anexo_promocion {
    private CoreTable varTabla;
    private BindingContainer bindings;
    private CoreSelectOneChoice lisTipDoc;
    private CoreSelectOneChoice lisDep;
    private CoreCommandButton promover;
    private CoreTable tblBajas;
    private CoreCommandButton guardar;
    private CoreSelectOneChoice lisPuestoNuevo;
    private CoreCommandButton imprimir;
    private CoreCommandButton autorizar;
    private CoreShowDetailItem showDetail2;
    private CoreSelectInputDate fechaFin;
    private CoreSelectInputDate fechaInicio;


    public Anexo_promocion() {
    }

    public String btn_crear_detalle() {//boton promoverrrr
        // Add event code here...
        /* ejecuto la consulta de las plazas que tiene el empleado*/
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"plazaXempleado");
        //Iterator valIterador;
        //Key llave;
        NameValuePairs datos;
        consul_plazaXempleado_vwRowImpl valFila;
        JUIteratorBinding vIterBinding;
       // RowSetIterator vBinding;
        //valIterador = varTabla.getSelectionState().getKeySet().iterator();
        vIterBinding=(JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_plazaXempleado_vw1Iterator}");
        //vBinding=vIterBinding.getRowSetIterator();
        Object aux[] = vIterBinding.getViewObject().getAllRowsInRange();
        int tamano = 0; // llevara el control del numero de filas en el viewobject
        Number varIdPromocion = new Number(20); // variabble que lleva el valor del atributo idPromocion
        Integer x = 1;
        Date varFechafin, varFechaIni;
       // while(valIterador.hasNext())
                   
       // tomando los datos de la fecha de inicio
       if (this.fechaInicio.getValue() == null || this.fechaInicio.getValue().equals("")){// 
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar la fecha de inicio."));
           return null;
       }else {
           
           //varFechaIni = (Date) this.fechaInicio.getValue();
            varFechaIni = utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy",this.fechaInicio.getValue()));
           //System.out.println("la fecha de inicio es "+ varFechaIni);
            //System.out.println("la fecha fin  es*** "+ varFechafin);
       }
             // tomando los datos de la fehca de finalizaciojn
       if (this.fechaFin.getValue() == null){
                  varFechafin = null;
             }
             else{
                 //varFechafin = (Date)this.fechaFin.getValue();
                 varFechafin = utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy",this.fechaFin.getValue()));
                 
                 //Verificando que la fecha de finalizacion sea mayor a la fecha de inicio
                 Date auxIni =  utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy",this.getFechaInicio().getValue()));
                 Date auxIni1 = utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy",this.getFechaFin().getValue()));
                 
                 if(auxIni.compareTo(auxIni1) > 0 ) {
                    
                     utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"La fecha de inicio es mayor que la fecha fin "));
                     return null;
                 }
             } 
          
        while (tamano < aux.length)// recorriendo la vista que contiene las plazas del empleado..
        {
         
          //llave =  (Key) valIterador.next();
          //valFila=(consul_plazaXempleado_vwRowImpl)vBinding.getRow(llave);
          valFila = (consul_plazaXempleado_vwRowImpl) aux[tamano];
          
          if ((varFechaIni.compareTo(valFila.getFechaFin()) <= 0 && varFechafin == null)|| (varFechaIni.compareTo(valFila.getFechaFin()) <= 0 && varFechafin.compareTo(valFila.getFechaInicio() )>= 0) ){ //La fecha de inicio de la promocion esta dentro de la vigencia del contrato
              x++;
              varIdPromocion = varIdPromocion.add(x);
             // datos = new NameValuePairs();
             /* datos.setAttribute("Operacion","B");
              datos.setAttribute("IdPartida",valFila.getIdPartida());
              datos.setAttribute("IdPuesto",valFila.getIdPuesto());
              datos.setAttribute("NumeroPlaza",valFila.getNumeroPlaza());
              datos.setAttribute("Correlativo",valFila.getCorrelativo());
              datos.setAttribute("CantidaHoras",valFila.getHorascontratadas());
              datos.setAttribute("FechaInicio",valFila.getFechaInicio());
              datos.setAttribute("FechaFin",valFila.getFechaFin());
              datos.setAttribute("SueldoBase",valFila.getSueldobase());
              datos.setAttribute("Escalafon",valFila.getEscalaf());
              datos.setAttribute("ComplSalarial",valFila.getComplSal());
              datos.setAttribute("PeriodoPlaza",valFila.getPeriodoPlaza());
              
                auxiliar = new ArrayList();
                auxiliar.add(valFila.getIdPartida());
                auxiliar.add(valFila.getIdPuesto());
                auxiliar.add(valFila.getNumeroPlaza());
                auxiliar.add(valFila.getCorrelativo());
                auxiliar.add(valFila.getHorascontratadas());
                auxiliar.add(valFila.getFechaInicio());
                auxiliar.add(valFila.getFechaFin());
                auxiliar.add(valFila.getSueldobase());
                auxiliar.add(valFila.getEscalaf());
                auxiliar.add(valFila.getComplSal());
                auxiliar.add(valFila.getPeriodoPlaza());
              */  
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdPartida1.inputValue}",valFila.getIdPartida());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdPuesto1.inputValue}",valFila.getIdPuesto());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNumPlaza1.inputValue}",valFila.getNumeroPlaza());
                //System.out.println("la plaza es No. "+ valFila.getNumeroPlaza());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pCorrelativo1.inputValue}",valFila.getCorrelativo());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHoras1.inputValue}",valFila.getHorascontratadas());
                if(varFechaIni.compareTo(valFila.getFechaInicio())< 0){// la fecha de inicio ingresada es menor que la fecha de incio de la plaza
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechIni1.inputValue}",valFila.getFechaInicio());
                }
                else {
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechIni1.inputValue}",varFechaIni);
                }
                //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}",valFila.getFechaFin());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pSueldo1.inputValue}",valFila.getSueldobase());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pEscalaf1.inputValue}",valFila.getEscalaf());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pComplemen1.inputValue}",valFila.getComplSal());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pPeriodoPLaza1.inputValue}",valFila.getPeriodoPlaza());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdPromocion1.inputValue}",varIdPromocion);
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pRegistroEmpleado1.inputValue}",valFila.getRegistroEmpleado());
                if (JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pRegistroEmpleado1.inputValue}") == null){
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pRegistroEmpleado1.inputValue}",valFila.getRegistroEmpleado());

                }
                //System.out.println("registro de empleado es "+ valFila.getRegistroEmpleado());
                //System.out.println("registro de empleado clase "+ valFila.getRegistroEmpleado().getClass());
                if (varFechafin == null || varFechafin.equals("")){ //no se ingreso la fecha fin en la promocion o reclasificacion, se utilizara la vigencia de la plaza.
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}",valFila.getFechaFin());
                    if (JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}")== null){
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}",valFila.getFechaFin());
                        //System.out.println("ESTABA NULO GUI GUI GUIG");
                    }
                    //System.out.println("**entre al iff **  fecha fin es "+valFila.getFechaFin());
                    //System.out.println("fecha fin clase "+valFila.getFechaFin().getClass());
                }
                else{//verifico que la fecha  fin ingresada sea igual o menor a la fecha de la plaza
                    if (varFechafin.compareTo(valFila.getFechaFin() ) >= 0){ //La fecha fin es mayor que la fecha del contrato
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}",valFila.getFechaFin());
                        if (JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}")== null){
                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}",valFila.getFechaFin());
                            //System.out.println("ESTABA NULO GUI GUI GUIG");
                        }
                        
                        //System.out.println("**entre al iff **  fecha fin es "+valFila.getFechaFin());
                        //System.out.println("fecha fin clase "+valFila.getFechaFin().getClass());
                    }
                    else {/// la fecha fin ingresada es menor a la fecha del contrato
                         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}",varFechafin);
                         if (JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}")== null){
                             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pFechaFin1.inputValue}",varFechafin );
                             //System.out.println("ESTABA NULO GUI GUI GUIG");
                         }
                    
                    }
                }
                //obtengo  los valores para la plaza nueva
                 x++;
                varIdPromocion = varIdPromocion.add(x);
                Number varIdPuesto = (Number) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_puesto_promocion_vw1Iterator.currentRow['idPuesto']}");
                Number varSueldo =  (Number) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_puesto_promocion_vw1Iterator.currentRow['escalamin']}");
                Number varEscalafon = (Number) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_puesto_promocion_vw1Iterator.currentRow['escalafon']}");
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdPuestoNuevo1.inputValue}",varIdPuesto);
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pSueldoNuevo1.inputValue}",varSueldo);
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pEscalafNuevo1.inputValue}",varEscalafon);
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdPromocion1.inputValue}",varIdPromocion);
            /*  if (this.getInpt_id_padre().getValue()==null||vFila.getIdContrato().compareTo((Number)this.getInpt_id_padre().getValue())!=0){
              
                  vFila.setIdContratoPadre((Number)this.getInpt_id_padre().getValue());
              }*/
             // System.out.println(fila1.getIdContrato());
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crear_promocion");
          }
         tamano++;
        
        }
        this.lisTipDoc.setDisabled(true);
        this.lisDep.setDisabled(true);
        this.guardar.setDisabled(false);
        this.lisPuestoNuevo.setDisabled(true);
        this.promover.setDisabled(true);
        this.tblBajas.setRendered(true);
        return null;
    }

    public void setVarTabla(CoreTable varTabla) {
        this.varTabla = varTabla;
    }

    public CoreTable getVarTabla() {
        return varTabla;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_buscar() {// busca los puestos para reclasificacion o promocion docente
        boolean resultado;
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteWithParams1");
        /*BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("ExecuteWithParams1");
        Object result = operationBinding.execute();*/
        if(resultado == true){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"FiltraPuestos");
            lisPuestoNuevo.setDisabled(false);
            promover.setDisabled(false);
            lisPuestoNuevo.setRendered(true);
            promover.setRendered(true);
            fechaInicio.setSubmittedValue(null);
            this.fechaInicio.setValue(null);            
            this.fechaFin.setSubmittedValue(null);
            this.fechaFin.setValue(null);
            this.fechaFin.setDisabled(false);
            this.fechaInicio.setDisabled(false);
        }
       // this.varTabla.setRendered(true);
        /*if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }*/
        return null;
    }

    public void setLisTipDoc(CoreSelectOneChoice lisTipDoc) {
        this.lisTipDoc = lisTipDoc;
    }

    public CoreSelectOneChoice getLisTipDoc() {
        return lisTipDoc;
    }

    public void setLisDep(CoreSelectOneChoice lisDep) {
        this.lisDep = lisDep;
    }

    public CoreSelectOneChoice getLisDep() {
        return lisDep;
    }

    public void setPromover(CoreCommandButton promover) {
        this.promover = promover;
    }

    public CoreCommandButton getPromover() {
        return promover;
    }

    public void setTblBajas(CoreTable tblBajas) {
        this.tblBajas = tblBajas;
    }

    public CoreTable getTblBajas() {
        return tblBajas;
    }

    public void setGuardar(CoreCommandButton guardar) {
        this.guardar = guardar;
    }

    public CoreCommandButton getGuardar() {
        return guardar;
    }

    public void setLisPuestoNuevo(CoreSelectOneChoice lisPuestoNuevo) {
        this.lisPuestoNuevo = lisPuestoNuevo;
    }

    public CoreSelectOneChoice getLisPuestoNuevo() {
        return lisPuestoNuevo;
    }

    public String btn_autorizar() {
        // Add event code here...
         util_dialog_adf vDialog= new util_dialog_adf();
         Object vVariable,vEstado;
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdAnexo.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Estatus.inputValue}");
         vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"ANEXO_A",vVariable,vEstado,"innecesario");
         
        return null;
    }

    public void setImprimir(CoreCommandButton imprimir) {
        this.imprimir = imprimir;
    }

    public CoreCommandButton getImprimir() {
        return imprimir;
    }

    public void setAutorizar(CoreCommandButton autorizar) {
        this.autorizar = autorizar;
    }

    public CoreCommandButton getAutorizar() {
        return autorizar;
    }

    public String btn_guardar() {
        boolean resultado;
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
        /*BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        */if (resultado == true) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));
            //return null;
        }
        else{
            return null;
        }
        this.autorizar.setDisabled(false);
        this.imprimir.setDisabled(false);
        this.guardar.setDisabled(true);
        this.showDetail2.setDisabled(false);
      //  this.lisTipDoc.setDisabled(false);
        //this.lisDep.setDisabled(false);
        
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"reset");
        return null;
    }

    public String btn_borrar() {
    
        sis_movimiento_plazaRowImpl auxVista;
        JUIteratorBinding vIterBinding; 
        Iterator valIterador;
        Key llave;
        RowSetIterator vBinding;
        vIterBinding=(JUIteratorBinding) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.sis_movimiento_plaza1Iterator}");  
        valIterador = this.tblBajas.getSelectionState().getKeySet().iterator();
        // vIterBinding.getViewObject().setCurrentRow( vIterBinding.getViewObject().getAllRowsInRange()[3]);
         vBinding=vIterBinding.getRowSetIterator();
        Number varEmpleado = new Number(0);
         
         if(valIterador.hasNext()){
         
             llave =  (Key) valIterador.next();
             auxVista = (sis_movimiento_plazaRowImpl) vBinding.getRow(llave);
             varEmpleado = auxVista.getRegistroEmpleado();
             
         }
        Object Var[] =  vIterBinding.getViewObject().getAllRowsInRange();
        int tamano = Var.length ;
        tamano = tamano -1;
        while( tamano >=0) {
        
           //System.out.println("fila No. " + tamano);
          // System.out.println("registro de empleado es:  "+ varEmpleado);
           auxVista = (sis_movimiento_plazaRowImpl) Var[tamano];
           
           if (auxVista.getRegistroEmpleado().compareTo(varEmpleado)== 0){
                    auxVista.remove();          
           }
               
           tamano--;
        }
      /*  BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Delete");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        //}*/
        this.guardar.setDisabled(false);
        return null;
    }

    public String btn_adjuntarArchivo() {
        // Add event code here...
         FacesContext context = FacesContext.getCurrentInstance();  
          ViewHandler vh = context.getApplication().getViewHandler();  
            // el jspx que se mostrara en forma de  ventana emergente  
          UIViewRoot dialog = vh.createView(context, "/util/adjuntar_archivo.jspx");  
          AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
            // fijamos el ancho y el alto de la ventana emergente  
           Map windowProperties = new HashMap();  
           windowProperties.put("width", new Integer(450));  
           windowProperties.put("height", new Integer(350));  
           //añadimos mas paremetros que seran recogidos en la jspx ventana  
           Map dialogParameters = new HashMap();  
           dialogParameters.put("IdAnexo",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdAnexo.inputValue}").toString());
           dialogParameters.put("Opcion", 5);
           a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
           System.out.println("salir");
          
            return null;
    }

    public void setShowDetail2(CoreShowDetailItem showDetail2) {
        this.showDetail2 = showDetail2;
    }

    public CoreShowDetailItem getShowDetail2() {
        return showDetail2;
    }

    public void setFechaFin(CoreSelectInputDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CoreSelectInputDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaInicio(CoreSelectInputDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public CoreSelectInputDate getFechaInicio() {
        return fechaInicio;
    }
}
