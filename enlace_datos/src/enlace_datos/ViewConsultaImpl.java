package enlace_datos;

import enlace_datos.util.utils;

import oracle.jbo.Variable;
import oracle.jbo.VariableManager;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;

public class ViewConsultaImpl extends ViewObjectImpl{

    private boolean verificarParam=false;
    private boolean ejecutarConsulta=true;
    public  int consultaFecha=0;
    public int consultaContrato=0;
    
    public ViewConsultaImpl() {
    }

    public void setEjecutarConsulta(boolean pValor){
        
        this.ejecutarConsulta=pValor;
        
    }


    public void setVerificarParam(boolean vValor){
      this.verificarParam=vValor;  
    }
    
    public void BusquedaAvanzada(Date FechaInicial, Date FechaFinal,Number regEmpleado,Number Dependencia,String pUsuario,String pCui){
        String vConector="";
        String vSqlQuerry="";
        if (FechaInicial!=null && FechaFinal!=null){
            vSqlQuerry ="trunc (fecha_inicio) between to_date('"+utils.getFechaFormato(FechaInicial.getValue())+"','dd/mm/yyyy') and to_date('"+utils.getFechaFormato(FechaFinal.getValue())+"','dd/mm/yyyy')";
            vConector=" and ";
        }
        if (regEmpleado!=null){
            vSqlQuerry=vSqlQuerry + vConector + "registro_empleado= " + regEmpleado;
            vConector=" and ";
        }
        if (pCui!=null && !pCui.trim().equals("")){
            vSqlQuerry=vSqlQuerry + vConector + "cui= " + pCui;
            vConector=" and ";
        }
        if (Dependencia!=null){
           vSqlQuerry=vSqlQuerry+vConector+"id_dependencia="+Dependencia;  
        }
        this.setWhereClause(vSqlQuerry);
        this.setNamedWhereClauseParam("pUsuario", pUsuario);        
        if (ejecutarConsulta)
            this.executeQuery();
    }

    public void BusquedaAvanzada(Date FechaInicial, Date FechaFinal,Number regEmpleado,Number Dependencia,String pUsuario,String pEstado, String pCui){
        String vConector="";
        String vSqlQuerry="";
        String vFechaF;
        if (FechaInicial!=null && FechaFinal!=null){
            if (consultaFecha==0){
                if(consultaContrato==0){
                    vSqlQuerry ="trunc (fecha_inicio) between to_date('"+utils.getFechaFormato(FechaInicial.getValue())+"','dd/mm/yyyy') and to_date('"+utils.getFechaFormato(FechaFinal.getValue())+"','dd/mm/yyyy')";
                }
                else{
                    vSqlQuerry ="((trunc (fecha_inicio) <= to_date('"+utils.getFechaFormato(FechaInicial.getValue())+"','dd/mm/yyyy') and tipo_validez ='I' and id_estado not in (15)) or (trunc (fecha_inicio) between to_date('"+utils.getFechaFormato(FechaInicial.getValue())+"','dd/mm/yyyy') and to_date('"+utils.getFechaFormato(FechaFinal.getValue())+"','dd/mm/yyyy')))";
                    consultaContrato=0;
                }
                vConector=" and ";
            } else if (consultaFecha==1){ //desc judicial 
                vFechaF=utils.getFechaFormato(FechaFinal.getValue());
                vSqlQuerry ="trunc (fecha_inicio) between to_date('"+utils.getFechaFormato(FechaInicial.getValue())+"','dd/mm/yyyy') and to_date('"+utils.getFechaFormato(FechaFinal.getValue())+"','dd/mm/yyyy')";
                vSqlQuerry ="(fecha_doc between to_date('"+utils.getFechaFormato(FechaInicial.getValue())+"','dd/mm/yyyy')  and to_date('"+vFechaF+"','dd/mm/yyyy') and to_date('"+vFechaF+"','dd/mm/yyyy')>=nvl(fecha_baja,to_date('"+vFechaF+"','dd/mm/yyyy')" +"))";
                vConector=" and ";
            }else if (consultaFecha == 2){ //suspencion laboral
                vSqlQuerry ="trunc (fecha_baja_laboral) between to_date('"+utils.getFechaFormato(FechaInicial.getValue())+"','dd/mm/yyyy') and to_date('"+utils.getFechaFormato(FechaFinal.getValue())+"','dd/mm/yyyy')";
                vConector=" and ";
            }
        }
        if (regEmpleado!=null){
            vSqlQuerry=vSqlQuerry + vConector + "registro_empleado= " + regEmpleado;
            vConector=" and ";
        }
        if (pCui!=null && !pCui.trim().equals("")){
            vSqlQuerry=vSqlQuerry + vConector + "cui= " + pCui;
            vConector=" and ";
        }
        if (Dependencia!=null){
           vSqlQuerry=vSqlQuerry+vConector+"id_dependencia="+Dependencia;  
           vConector=" and ";
        }
        if (pEstado!=null){
            if (!pEstado.equals("0")){
                vSqlQuerry=vSqlQuerry+vConector+"id_estado="+pEstado;  
            }
        }
        //System.out.println(vSqlQuerry);
        this.setWhereClause(vSqlQuerry);
        this.setNamedWhereClauseParam("pUsuario", pUsuario);
        if (ejecutarConsulta)
            this.executeQuery();
    }

    /* modificado por bug en jdeveloper 10.1.33, en algunos casos trata de ejecutar la consulta
        sin enviar los parametros necesarios */
  protected void executeQueryForCollection(Object qc, Object params[], int noUserParams) {
          // Si no vienen los parametros entonces no se ejecuta la consulta
           if (verificarParam==true && params!=null){
               VariableManager varManager = this.ensureVariableManager();
                        
               if (varManager != null) {
                   Variable[] vars = varManager.getVariables();
                   boolean ejecutar=true;
                   Object [] vValor;
                              
                   if (params.length>=vars.length){
                       for (int i=0;i<vars.length;i++){
                                    
                           vValor=(Object [])params[i];
                             if (!vars[i].getName().equalsIgnoreCase(vValor[0].toString())){
                                     ejecutar=false;
                                                                                        }
                                                    }
                             if (ejecutar==true)
                                   super.executeQueryForCollection(qc, params, noUserParams);      
                                                }
                                        }
                     }
            else if (verificarParam==false){
                 super.executeQueryForCollection(qc, params, noUserParams);
            }
}


  /*  
    protected void executeQueryForCollection(Object qc, Object params[], int noUserParams) {
    
            
             // Si no vienen los parametros entonces no se ejecuta la consulta
             if (verificarParam==true && params!=null){
                 VariableManager varManager = this.ensureVariableManager();

                  if (varManager != null) {
                      Variable[] vars = varManager.getVariables();
                       if (vars.length==params.length)
                           super.executeQueryForCollection(qc, params, noUserParams);      
                         }
             }
             else if (verificarParam==false)
                super.executeQueryForCollection(qc, params, noUserParams);
    }
*/

/*    
    public void BusquedaAvanzada(Date FechaInicial, Date FechaFinal,Number regEmpleado,Number Dependencia){
     
        String vConector="";
        String vSqlQuerry="";
        
   
        if (FechaInicial!=null && FechaFinal!=null){
            vSqlQuerry ="fecha_inicio between :1 and :2";
            vConector=" and ";
            this.setWhereClauseParam(0,FechaInicial);
            this.setWhereClauseParam(1,FechaFinal);
        }
        
        
        if (regEmpleado!=null){
            vSqlQuerry=vSqlQuerry + vConector + "registro_empleado= " + regEmpleado;
        }
        
        this.setWhereClause(vSqlQuerry);
        this.executeQuery();
        
    }
    

    public void BusquedaAvanzada(Date FechaInicial, Date FechaFinal,Number regEmpleado,Number Dependencia){
     
        String vConector="";
        String vSqlQuerry="";
    
                
        this.setNamedWhereClauseParam("FechaI",FechaInicial);
        this.setNamedWhereClauseParam("FechaF",FechaFinal);
                        
       
            if (regEmpleado!=null){
                vSqlQuerry="registro_empleado="+regEmpleado.toString();  
                vConector=" and ";
            }
            
            if (Dependencia!=null){
               vSqlQuerry=vSqlQuerry+vConector+"id_dependencia="+Dependencia;  
            }
       
        this.setWhereClause(vSqlQuerry);
        this.executeQuery();
    }
    */
}
