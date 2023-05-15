package enlace_datos.consultas.admin;

import enlace_datos.consultas.gestiones.empleado.lista_empleadosRowImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.AdfToCSV;

import interfaz_usuario.servlets.verReporteExcel;

import interfaz_usuario.util.ADFUtils;

import interfaz_usuario.util.JSFUtils;


import interfaz_usuario.util.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectManyShuttle;
import oracle.adf.view.faces.component.core.layout.CorePanelTip;
import oracle.adf.view.faces.event.DisclosureEvent;
import oracle.adf.view.faces.event.LaunchEvent;
import oracle.adf.view.faces.event.ReturnEvent;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;

public class historial_salarial {
    private CoreSelectManyShuttle lst_Many_dependencias;
    private UISelectItems item_dependencias;
    private CorePanelTip panel_tip;
    private CoreInputText inpt_registroE;

    public historial_salarial() {
    }

    public void setLst_Many_dependencias(CoreSelectManyShuttle lst_Many_dependencias) {
        this.lst_Many_dependencias = lst_Many_dependencias;
    }

    public CoreSelectManyShuttle getLst_Many_dependencias() {
        return lst_Many_dependencias;
    }

    public void setItem_dependencias(UISelectItems item_dependencias) {
        this.item_dependencias = item_dependencias;
    }

    public UISelectItems getItem_dependencias() {
        return item_dependencias;
    }


    public String btn_buscar_action() {
        //List <String> vParametros;
        //vParametros=new ArrayList<String>();
        
        // Enviar todos los parametros
        // aunque no vayan, en la consulta
        // se verifica, para crear la consulta
        ArrayList vParametros;
        vParametros=new ArrayList();
        Object vValor;
        
        // Registro de empleado
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.reg_empleado1.inputValue}");
           
        if (vValor!=null){
            vParametros.add(vValor);
        }else{
            vParametros.add(null);
        }

        // Dependencias     
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_Dep_histSal.selectedValues}");
        vParametros.add(vValor);  
            
        //unidades    
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_unidades_histSal.selectedValues}");
         vParametros.add(vValor);      
            
        //plan de egresos
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_programa_histSal.selectedValues}");
         vParametros.add(vValor);     
            
        //Renglones  
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_renglon_histSal.selectedValues}");
         vParametros.add(vValor); 
        
        //Tipo nomina
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_tipNomina_histSal.selectedValues}");
         vParametros.add(vValor);       
            
        //descuentos
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_ajustes_histSal.selectedValues}");
         vParametros.add(vValor);       
         
        //Fechas 
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.fecha_de1.inputValue}");
         vParametros.add(vValor);     
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.fecha_hasta1.inputValue}");
         vParametros.add(vValor);  
            
         //puesto
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_puesto_histSal.selectedValues}");
         vParametros.add(vValor);       
         
         // carrera
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.carreraClasif1.inputValue}");
         vParametros.add(vValor);       
            
        // nombreEmpleado
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.nomEmpleado1.inputValue}");
         vParametros.add(vValor);       
         
        // numPago
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.numPago1.inputValue}");
         vParametros.add(vValor);       
         
         
        // TipoProceso
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_tipProc_histSal.selectedValues}");
         vParametros.add(vValor);       
            
        // CUI
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pCui.inputValue}");
        vParametros.add(vValor);
            
            
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vParametros1.inputValue}",vParametros);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"generar_consulta");
        
        return null;
    }
    
        
    public String btn_command_lnk_action() {

       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");
       return "hist_detalle";
       
    }

    public String btn_buscar_unidades_action() {
        // Add event code here...
         Object vValor;
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_Dep_histSal.selectedValues}");
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vDeps1.inputValue}",vValor);
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"consulta_por_Deps");
         JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_unidades_histSal.allItemsx}");
    
        return null;
    }

    public String buscar_opEmpl() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"consultaEmpl");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeISR");
        
       // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalNominal");
       // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalBono");
        return null;
    }

    public String cmd_link_descuento() {
        // Add event code here...
        Number vIdPago;
        
      try{  
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setPosicionarDesc")){
             
             vIdPago=(Number)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDocPago.inputValue}");
             
             JSFUtils.storeOnSession(FacesContext.getCurrentInstance(),"vIdDocPagoSel",vIdPago);
             
         }
                 
        return "hist_sal_detEmpl";
        
      }catch(Exception exep){
          
          return null;
      }
        
    }

    public String cmd_num_pago_tabla1() {
        Number vIdPago;
    
        try{  
           if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowWithKey")){
               
               vIdPago=(Number)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDocumentoBanco.inputValue}");
               
               JSFUtils.storeOnSession(FacesContext.getCurrentInstance(),"vIdDocPagoSel",vIdPago);
               
           }
                   
          return "hist_sal_detEmpl";
          
        }catch(Exception exep){
            
            return null;
        }
        
        
        
    }

    public String cmd_excel_action() {
         HttpServletRequest vRequest=((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest());
         HttpServletResponse vResponse;
         Object vRegistro;
          
         vResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
         

             
         vRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.reg_empleado1.inputValue}");
         
         if (vRegistro==null){
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor ingrese el registro de empleado."));
             return null;
         }
             
            
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vDescripBita1.inputValue}","Consulta de "+vRegistro);   
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"insertar_detalle");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");   
        
             
             verReporteExcel Excel;
             Excel = new verReporteExcel();
             try{
             
               vRequest.setAttribute("id",vRegistro);
               vRequest.setAttribute("rep","HIST_SAL_EMPL");  
               Excel.doGet(vRequest,vResponse);
             
             
             }catch(Exception exep){
                 
                 exep.printStackTrace();
             }
      //   }
         
         return null;


    }

    public void return_nombre_listener(ReturnEvent returnEvent) {
        // Add event code here...
        
         lista_empleadosRowImpl vValor=null;
         
         if (returnEvent.getReturnValue()!=null){
        //vValor=(lista_empleadosRowImpl)returnEvent.getReturnValue();
          
             this.getInpt_registroE().setSubmittedValue(null);
             this.getInpt_registroE().setValue(returnEvent.getReturnValue());
             
         }
        System.out.println("debug "+returnEvent.getReturnValue());

    }

    public void setInpt_registroE(CoreInputText inpt_registroE) {
        this.inpt_registroE = inpt_registroE;
    }

    public CoreInputText getInpt_registroE() {
        return inpt_registroE;
    }

    public String cmd_to_CSV() {
    
        genExcel();
        /*try{ ESTE CODIGO GENERA EL ARCIVO CSV
           String vTituls[]={"RegistroEmpleado","Cui","Nombrecompleto","Sexo","Partida","NomSubProg","NumeroPlaza","IdContrato","FormObtPst","IdProceso","Nombreproceso","Tiponomina","Año","Codigonomina","SueldoBase","Compl","Escalaf","Nominal","TotalBono","TotalDesc","Liquido","Nombrebanco","TipoDoc","NumDocumento","FechaEmision","FechaAnulacion","Sis21","Clasif","NomPuesto","TipoPuesto","NivelPuesto","CatPuesto","TipoServ","ReqProf","D01","D02","D03","D04","D05","D06","D07","D08","D09","D10","D11","D12","D13","D14","D15","D16","D17","D18","D19","D20","D21","D22","D23","D24","D25","D26","D27","D28","D29","D30","D31"};
           String vOrdn[]  ={"RegistroEmpleado","Cui","Nombrecompleto","Genero","Partida2","Nomsubprog","NumeroPlaza","IdContrato","Formaobtpuesto","IdProceso","Nombreproceso","Tiponomina","Correlativo","Codigonomina","SueldoBase","ComplSalarial","Escalafon","Nominal","TotalBono","TotalDescuento","Liquido","Nombrebanco","Nomtipodoc","NumDocFisico","FechaEmision","FechaAnulacion","Sis21","IdPuesto","Nombre","Nomtipo","Nivelpuesto","Catepuesto","NomServicio","ReqProf","Dsc1","Dsc2","Dsc3","Dsc4","Dsc5","Dsc6","Dsc7","Dsc8","Dsc9","Dsc10","Dsc11","Dsc12","Dsc13","Dsc14","Dsc15","Dsc16","Dsc17","Dsc18","Dsc19","Dsc20","Dsc21","Dsc22","Dsc23","Dsc24","Dsc25","Dsc26","Dsc27","Dsc28","Dsc29","Dsc30","Dsc31"};
           AdfToCSV Export;
           Export = new AdfToCSV();
           
           Export.setTitulos(vTituls);
           Export.setOrden(vOrdn);
           Export.setNomArchivo("consultaSalarial");
           
           Export.exportHtmlTableToExcelCustom((DCIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_historial_salarialIterator}"));
        
        }catch(Exception exep){
            exep.printStackTrace();
        }*/
         
        
        return null;
    }
    
    public String excel_sal_fechas() {
        HttpServletRequest vRequest=((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest());
        HttpServletResponse vResponse;
        Object vRegistro,vFechaI,vFechaF;
         
        vResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
        // if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"acreditamiento_final")){
            
        vRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.reg_empleado1.inputValue}");
        vFechaI=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.fecha_de1.inputValue}");
        vFechaF=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.fecha_hasta1.inputValue}");
        
        if (vRegistro==null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor ingrese el registro de empleado."));
            return null;
        }
            
           
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vDescripBita1.inputValue}","Consulta de "+vRegistro);   
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"insertar_detalle");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");   
        
            
            verReporteExcel Excel;
            Excel = new verReporteExcel();
            try{
            
              vRequest.setAttribute("id",vRegistro);
              vRequest.setAttribute("rep","HIST_SAL_EMPL2");  
              vRequest.setAttribute("var1",utils.getFechaFormato3("dd/MM/yyyy",vFechaI));  
              vRequest.setAttribute("var2",utils.getFechaFormato3("dd/MM/yyyy",vFechaF));  
              Excel.doGet(vRequest,vResponse);
            
            
            }catch(Exception exep){
                exep.printStackTrace();
                
                //
                 //
            }
        //   }
        return null;

    }
    
    public String genExcel() {
        HttpServletRequest vRequest=((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest());
        HttpServletResponse vResponse;
        Object vRegistro,vFechaI,vFechaF;
        vResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
        //-PARA OBTENER PARAMETRO
        
         ArrayList vParametros;
         vParametros=new ArrayList();
         Object vValor;
         
         // Registro de empleado
         
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.reg_empleado1.inputValue}");
            
         if (vValor!=null){
             vParametros.add(vValor);
         }else{
             vParametros.add(null);
         }

         // Dependencias     
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_Dep_histSal.selectedValues}");
         vParametros.add(vValor);  
             
         //unidades    
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_unidades_histSal.selectedValues}");
          vParametros.add(vValor);      
             
         //plan de egresos
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_programa_histSal.selectedValues}");
          vParametros.add(vValor);     
             
         //Renglones  
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_renglon_histSal.selectedValues}");
          vParametros.add(vValor); 
         
         //Tipo nomina
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_tipNomina_histSal.selectedValues}");
          vParametros.add(vValor);       
             
         //descuentos
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_ajustes_histSal.selectedValues}");
          vParametros.add(vValor);       
          
         //Fechas 
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.fecha_de1.inputValue}");
          vParametros.add(vValor);     
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.fecha_hasta1.inputValue}");
          vParametros.add(vValor);  
             
          //puesto
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_puesto_histSal.selectedValues}");
          vParametros.add(vValor);       
          
          // carrera
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.carreraClasif1.inputValue}");
          vParametros.add(vValor);       
             
         // nombreEmpleado
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.nomEmpleado1.inputValue}");
          vParametros.add(vValor);       
          
         // numPago
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.numPago1.inputValue}");
          vParametros.add(vValor);       
          
          
         // TipoProceso
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_tipProc_histSal.selectedValues}");
          vParametros.add(vValor);       
             
         // CUI
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pCui.inputValue}");
         vParametros.add(vValor);
             
        
        // -- FIN DE OBTENER PARAMETROS
        String goWhere = goWhere(vParametros);
                   
            verReporteExcel Excel;
            Excel = new verReporteExcel();
            try{
            
            //System.out.println(this.vParams);
            
              vRequest.setAttribute("id",goWhere);                
              vRequest.setAttribute("rep","REPORTEHIST_SAL");   
              Excel.doGet(vRequest,vResponse);
            
            
            }catch(Exception exep){
                exep.printStackTrace();
                
                //
                 //
            }
        //   }
        return null;

    }
    
    public String goWhere(List pParametros){
        String pConsulta="VACIO",vTempo="" ;
        ArrayList vValores;
        Object vTemp1; 
        
        if (pParametros!=null){   
            // Registro de empleado
            pConsulta = "";
            if (pParametros.get(0)!=null){
                pConsulta="$3."+pParametros.get(0);
            } 
            // num pago
            if (pParametros.get(12)!=null){
                vTemp1=pParametros.get(12); 
                vTempo="$4."+vTemp1 + "";
                pConsulta=pConsulta+vTempo; 
            } else {
                //Fechas, periodo de busqueda.       
                if (pParametros.get(7)!=null){
                    vTempo=getIntervaloFechas((Date)pParametros.get(7),(pParametros.get(8)!=null?(Date)pParametros.get(8):utils.getFechaActual()),"MES");
                    vTempo="$6."+vTempo;
                    pConsulta=pConsulta+vTempo;  
                    vTempo=getIntervaloFechas((Date)pParametros.get(7),(pParametros.get(8)!=null?(Date)pParametros.get(8):utils.getFechaActual()),"ANIO");
                    vTempo="$5."+vTempo;
                    pConsulta=pConsulta+vTempo; 
                }else{
                    pConsulta =pConsulta=pConsulta+"$55."+utils.getAnioActual();
                } 
            }
            //dependencias
            if (pParametros.get(1)!=null){
                vValores=(ArrayList)pParametros.get(1);          
                vTempo=getLista(vValores.iterator());
                vTempo="$7." + vTempo;  
                pConsulta=pConsulta+vTempo; 
            }
            // Unidades
            if (pParametros.get(2)!=null){
                vValores=(ArrayList)pParametros.get(2);
                String vTempo2="";
                String [] vTempo3;
                vTempo="$2.";
                Iterator vFilas;
                vFilas=vValores.iterator();
                while (vFilas.hasNext()){
                    vTempo2=vFilas.next().toString(); 
                    vTempo3=vTempo2.split("\\.");
                    vTempo+= "_";
                    vTempo+="|"+vTempo3[0] +"|" +vTempo3[1]  + "|"+vTempo3[2];
                }
                pConsulta=pConsulta+vTempo; 
            }
            //plan de egresos
            if (pParametros.get(3)!=null){
                vValores=(ArrayList)pParametros.get(3);          
                vTempo=getLista(vValores.iterator());
                vTempo="$8." + vTempo;                
                pConsulta=pConsulta+vTempo; 
            }
            //renglones
            if (pParametros.get(4)!=null){
                vValores=(ArrayList)pParametros.get(4);          
                vTempo=getLista(vValores.iterator());
                vTempo="$9." + vTempo;                
                pConsulta=pConsulta+vTempo; 
            }
            //Tipo Nomina
            if (pParametros.get(5)!=null){
                vValores=(ArrayList)pParametros.get(5);          
                vTempo=getLista(vValores.iterator());
                if (vValores.contains("1") ){
                    vTempo="$10." + vTempo + " and d9d10 not in (0,75,76,72,81)";                    
                }else{
                    vTempo="$11." + vTempo;                    
                }          
                pConsulta=pConsulta+vTempo; 
            }
            // tipo proceso                          
            if (pParametros.get(13)!=null){
                vValores=(ArrayList)pParametros.get(13);          
                vTempo=getLista(vValores.iterator());
                vTempo="$12." + vTempo+" and id_proceso<>101";         
                pConsulta=pConsulta+vTempo; 
            }
            //Descuentos 
            if (pParametros.get(6)!=null){
                vValores=(ArrayList)pParametros.get(6);          
                vTempo=getLista(vValores.iterator());
                vTempo="$13." + vTempo;                
                pConsulta=pConsulta+vTempo; 
            } 
            if (pParametros.get(9)!=null){
                vValores=(ArrayList)pParametros.get(9);          
                vTempo=getLista(vValores.iterator());
                vTempo="$14."+vTempo;       
                pConsulta=pConsulta+vTempo; 
            }
            if (pParametros.get(10)!=null){
                vTemp1=pParametros.get(10); 
                if (!vTemp1.equals("TODOS")){
                    vTempo="$15."+vTemp1;           
                    pConsulta=pConsulta+vTempo; 
                }
            }
            // Nombre del empleado
            if (pParametros.get(11)!=null){
                vTemp1=pParametros.get(11); 
                vTempo="$16." +vTemp1.toString().toUpperCase();  
                pConsulta=pConsulta+vTempo; 
            }
            // CUI
            if (pParametros.get(14)!=null && !pParametros.get(14).toString().trim().equals("")){
                vTemp1=pParametros.get(14); 
                vTempo="$17."+vTemp1;
                pConsulta=pConsulta+vTempo; 
            }
        }
        
        //System.out.println(pConsulta);
        return pConsulta;
    
    }
    
    
    public String getLista(Iterator vLista){
        String vTempo="";
        
        while (vLista.hasNext()){
          vTempo+=vLista.next().toString()+","; 
        }
            
          vTempo="(" + vTempo.substring(0,vTempo.length()-1) + ")";                
     return vTempo;   
    }
    
    public String getIntervaloFechas(Date pFechaI,Date pFechaF,String pOpcion){
        int vInter1,vInter2;
        int vAnioI,vAnioF;
        int vPeriodo;
        int vDiffMeses;
        int vRecorrido;
        long vDiffMili;
        String vIntervalo,vMascara;
        
        vDiffMeses=0;
        if (pOpcion.equals("MES")){
            vMascara="MM";
            vAnioI = Integer.parseInt(utils.getFechaFormato2("yyyy",pFechaI));
            vAnioF = Integer.parseInt(utils.getFechaFormato2("yyyy",pFechaF));
            
            vDiffMeses=0;
            
            if (vAnioF>vAnioI){
                
                vDiffMili=pFechaF.timestampValue().getTime()-pFechaI.timestampValue().getTime();
                vDiffMeses=new Double((vDiffMili/(1000*3600*24))/30).intValue();
                
                //vDiffMeses=12;
                
                if (vDiffMeses>12){
                    vDiffMeses=12;   
                }
                
                
            }else{
                vDiffMeses=Integer.parseInt(utils.getFechaFormato2(vMascara,(Date)pFechaF));
                vDiffMeses=vDiffMeses-Integer.parseInt(utils.getFechaFormato2(vMascara,(Date)pFechaI));
                
            }            
        
        }else {
            vMascara="yyyy";
            vDiffMeses=Integer.parseInt(utils.getFechaFormato2(vMascara,(Date)pFechaF));
            vDiffMeses=vDiffMeses-Integer.parseInt(utils.getFechaFormato2(vMascara,(Date)pFechaI));
            
        }
        
        vInter1=Integer.parseInt(utils.getFechaFormato2(vMascara,(Date)pFechaI));
        if (pFechaF!=null){
        
        //    vInter2=Integer.parseInt(utils.getFechaFormato(vMascara,(Date)pFechaF));
        
        vIntervalo="";  
        vPeriodo=vInter1;
        
            for (int a=0;a<=vDiffMeses;a++){
            
              if (vPeriodo>12 && pOpcion.equals("MES"))
                  vPeriodo=1;
                  
                vIntervalo+=String.valueOf(vPeriodo)+","; 
                
                vPeriodo++;
            }
            
            vIntervalo="(" + vIntervalo.substring(0,vIntervalo.length()-1) + ")"; 
            
        
        }else{ // El intervalo es la fecha de inicio
            vIntervalo="("+String.valueOf(vInter1)+")";
        }
        return vIntervalo;
    }
    
    
}
